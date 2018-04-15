package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;


public interface MVCFilmDAO {
	public Film getFilmById(int filmId) throws SQLException;

	public List<Film> getFilmsByActorId(int actorId);

	public List<Film> getFilmBySearch(String word) throws SQLException;

	public String getLanguage(Film film);
	public Film updateFilm(Film film);
	public Film addFilm(Film film);
	public boolean deleteFilm(int id);
	public List<Category> getFilmsCategoriesByFilmId(int filmId);
	Actor getActorById(int actorId);

	List<Actor> getActorsByFilmId(int filmId);
}
