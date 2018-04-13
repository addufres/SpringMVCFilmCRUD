package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;


public interface MVCFilmDAO {
	public Film getFilmById(int filmId) throws SQLException;

	public List<Film> getFilmsByActorId(int actorId);

	public List<Film> getFilmBySearch(String word) throws SQLException;

	public String getLanguage(Film film);
	
	public Film addFilm(Film film);
	public boolean deleteFilm(Film film);

	Actor getActorById(int actorId);

	List<Actor> getActorsByFilmId(int filmId);
}
