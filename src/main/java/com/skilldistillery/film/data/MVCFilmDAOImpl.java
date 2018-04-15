package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;

public class MVCFilmDAOImpl implements MVCFilmDAO {

	private static final String URL = "JDBC:mysql://localhost:3306/sdvid";
	private static final String user = "student";
	private static final String pass = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load database driver...exiting");
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public Film getFilmById(int filmId) throws SQLException {
		Film film = null;
		// CONNECT TO DATABASE
		Connection conn = DriverManager.getConnection(URL, user, pass);
		// SQL TEXT TO QUERY WITH
		String sql = "SELECT * FROM film WHERE id = ?";
		// PASS INTO PREPARESTATEMENT(TEXT)
		PreparedStatement stmt = conn.prepareStatement(sql);
		// DECLARE AND INITIALIZE RESULTSET
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		// PRINT RESULTSET
		if (rs.next() == false && filmId != 0) {
			return film;
		} else {
			rs.beforeFirst();
			while (rs.next()) {
				int id = filmId;
				String title = rs.getString(2);
				String description = rs.getString(3);
				short releaseYear = rs.getShort(4);
				int languageId = rs.getInt(5);
				int rentalDuration = rs.getInt(6);
				double rentalRate = rs.getDouble(7);
				int length = rs.getInt(8);
				double replacementCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String specialfeatures = rs.getString(11);
				
				film = new Film(id, title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
						replacementCost, rating, specialfeatures, getActorsByFilmId(id));
				film.setCategories(getFilmsCategoriesByFilmId(film.getId()));
			}
		}

		// CLOSE UTILITIES
		rs.close();
		stmt.close();
		conn.close();
		return film;
	}

	@Override
	public Actor getActorById(int actorId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor(actorResult.getInt(1), actorResult.getString(2), actorResult.getString(3));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	public List<Film> getFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration, ";
			sql += " rental_rate, length, replacement_cost, rating, special_features "
					+ " FROM film JOIN film_actor ON film.id = film_actor.film_id " + " WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == false && actorId != 0) {
				return null;
			} else {
				while (rs.next()) {
					int filmId = rs.getInt(1);
					String title = rs.getString(2);
					String desc = rs.getString(3);
					short releaseYear = rs.getShort(4);
					int langId = rs.getInt(5);
					int rentDur = rs.getInt(6);
					double rate = rs.getDouble(7);
					int length = rs.getInt(8);
					double repCost = rs.getDouble(9);
					String rating = rs.getString(10);
					String features = rs.getString(11);
					Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost,
							rating, features, getActorsByFilmId(filmId));
					films.add(film);
				}
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Film> getFilmBySearch(String word) throws SQLException {
		List<Film> films = new ArrayList<>();
		// CONNECT TO DATABASE
		Connection conn = DriverManager.getConnection(URL, user, pass);
		// SQL TEXT TO QUERY WITH
		String sql = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?";
		// PASS INTO PREPARESTATEMENT(TEXT)
		PreparedStatement stmt = conn.prepareStatement(sql);
		// DECLARE AND INITIALIZE RESULTSET
		String word2 = "%" + word + "%";
		stmt.setString(1, word2);
		stmt.setString(2, word2);
		ResultSet rs = stmt.executeQuery();
		// PRINT RESULTSET
		while (rs.next()) {
			int id = rs.getInt(1);
			String title = rs.getString(2);
			String description = rs.getString(3);
			short releaseYear = rs.getShort(4);
			int languageId = rs.getInt(5);
			int rentalDuration = rs.getInt(6);
			double rentalRate = rs.getDouble(7);
			int length = rs.getInt(8);
			double replacementCost = rs.getDouble(9);
			String rating = rs.getString(10);
			String specialfeatures = rs.getString(11);
			Film film = new Film(id, title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
					replacementCost, rating, specialfeatures, getActorsByFilmId(id));
			film.setCast(getActorsByFilmId(film.getId()));
			film.setCategories(getFilmsCategoriesByFilmId(film.getId()));
			System.out.println(film);
			films.add(film);
		}

		rs.close();
		stmt.close();
		conn.close();
		return films;
	}
	
	
	@Override
	public List<Actor> getActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		String sql = "select a.first_name, a.last_name, a.id from film f join film_actor fa on f.id = "
				+ "fa.film_id join actor a on a.id = fa.actor_id where f.id = ? limit 5";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String fname = rs.getString(1);
				String lname = rs.getString(2);
				int id = rs.getInt(3);
				Actor actor = new Actor(id, fname, lname);
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return actors;
	}

	@Override
	public String getLanguage(Film film) {
		String lang = "";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT f.language_id, l.name FROM film f JOIN language l ON f.language_id = l.id WHERE f.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				StringBuilder sb = new StringBuilder(rs.getString(2));
				return sb.toString();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lang;
	}

	public Film addFilm(Film film) {
		Connection conn = null;
		try {
			System.out.println("dldldldl");
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating) "
					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			int updateCount = stmt.executeUpdate();
			System.out.println(updateCount);
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newFilmID = keys.getInt(1);
					film.setId(newFilmID);
					System.out.println(newFilmID);
				}
			} else {
				film = null;
			}
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting film " + film);
		}
		return film;
	}

	public boolean deleteFilm(int id) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	public Film updateFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "UPDATE film SET title=?, description=?, release_year=?, language_id=?, "
					+ "rental_duration=?,rental_rate=?, length=?, replacement_cost=?, rating=?   WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setInt(10, film.getId());
			int updateCount = stmt.executeUpdate();
			System.out.println(updateCount);
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
		}
		return film;
	}

	@Override
	public List<Category> getFilmsCategoriesByFilmId(int filmId) {
		List<Category> categories = new ArrayList<>();
		String sql = "select c.id, c.name FROM film f join film_category fc on f.id = fc.film_id join category c on c.id = fc.film_id where f.id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Category Category = new Category(id, name);
				categories.add(Category);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categories;
	}

}
