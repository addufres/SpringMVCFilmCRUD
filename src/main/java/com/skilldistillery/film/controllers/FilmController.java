package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView seeFilmInfo(@RequestParam(name = "ID") Integer filmId) {
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
	@RequestMapping(path = "search.do", method = RequestMethod.GET)
	public ModelAndView seeFilmInfoSearched(@RequestParam(name = "search") String s) {
		List<Film> film = new ArrayList<>();
		ModelAndView mv;
		try {
			film.addAll(dao.getFilmBySearch(s));
			mv = new ModelAndView();
			mv.setViewName("WEB-INF/views/resultMulti.jsp");
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
	public ModelAndView addFilm(RedirectAttributes redir, @RequestParam(name = "title") String title,
			@RequestParam(name = "description") String description, @RequestParam(name = "year") Short releaseYear,
			@RequestParam(name = "languageID") Integer languageId,
			@RequestParam(name = "rentalduration") Integer rentalDuration,
			@RequestParam(name = "rentalrate") Double rentalRate, @RequestParam(name = "length") Integer length,
			@RequestParam(name = "cost") Double replacementCost, @RequestParam(name = "rating") String rating) {
		Film film = new Film(title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
				replacementCost, rating);
		Film filmy = dao.addFilm(film);
		System.out.println(filmy);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/result.jsp");
		mv.addObject("film", filmy);
		return mv;
	}
	
	@RequestMapping(path = "delete.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(RedirectAttributes redir, @RequestParam(name = "filmId") Integer fid) {
		ModelAndView mv = new ModelAndView();
		boolean b = dao.deleteFilm(fid);
		if (b) {
			mv.setViewName("WEB-INF/views/delete.jsp");
		}
		else {
			mv.setViewName("WEB-INF/views/Fail.jsp");
		}
		return mv;
	}
	
	@RequestMapping(path = "update.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(RedirectAttributes redir,@RequestParam(name="id") Integer id, @RequestParam(name = "title") String title,
			@RequestParam(name = "description") String description, @RequestParam(name = "year") Short releaseYear,
			@RequestParam(name = "languageID") Integer languageId,
			@RequestParam(name = "rentalduration") Integer rentalDuration,
			@RequestParam(name = "rentalrate") Double rentalRate, @RequestParam(name = "length") Integer length,
			@RequestParam(name = "cost") Double replacementCost, @RequestParam(name = "rating") String rating) {
		Film film = new Film(title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
				replacementCost, rating);
		film.setId(id);
		Film filmy = dao.updateFilm(film);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/result.jsp");
		mv.addObject("film", filmy);
		return mv;
	}
}
