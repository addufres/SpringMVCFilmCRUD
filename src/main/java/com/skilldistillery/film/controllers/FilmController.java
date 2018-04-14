package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.MVCFilmDAOImpl;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private MVCFilmDAOImpl dao;

	@RequestMapping(path = "home.do")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/home.jsp");
		return mv;
	}

	// USER STORY 1 GET FILM INFO BY FILMID
	@RequestMapping(path = "result.do", method = RequestMethod.GET)
	public ModelAndView seeFilmInfo(@RequestParam( name = "ID") Integer filmId) {
		Film film;
		ModelAndView mv;
		try {
			film = dao.getFilmById(filmId);
			mv = new ModelAndView();
			mv.setViewName("WEB-INF/views/result.jsp");
			mv.addObject("film", film);
			return mv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv = new ModelAndView("WEB-INF/views/fail.jsp");
		return mv;
	}

	// USER STORY 2
	// A user can choose to add a new film. They can enter all the
	// properties of the film.
	// Their input will be used to create Film object, which the DAO implementation
	// will save in the database.
	// If the insert fails, the user is informed of this.
	@RequestMapping(path = "addfilm.do", method = RequestMethod.POST)
	public ModelAndView addFilm(Film film, Errors errors) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/result.jsp");
		mv.addObject("film", film);
		System.out.println(film);
		if (errors.hasErrors()) {
			mv.setViewName("WEB-INF/views/fail.jsp");
		}
		return mv;
	}
}
