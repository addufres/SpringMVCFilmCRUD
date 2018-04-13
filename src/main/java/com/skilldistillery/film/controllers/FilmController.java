package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.MVCFilmDAOImpl;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private MVCFilmDAOImpl dao; 
	
	@RequestMapping(path = "result.do", method = RequestMethod.GET)
	public ModelAndView seeFilmInfo(int filmId) {
		Film film;
		ModelAndView mv;
		try {
			film = dao.getFilmById(filmId);
			mv = new ModelAndView("WEB-INF/result.jsp", "film", film);
			return mv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv = new ModelAndView("WEB-INF/home.jsp");
		return mv;
	}

}
