package com.skumarv.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javastrava.api.v3.auth.AuthorisationService;
import javastrava.api.v3.auth.impl.retrofit.AuthorisationServiceImpl;
import javastrava.api.v3.auth.model.Token;
import javastrava.api.v3.model.StravaAthlete;
import javastrava.api.v3.service.Strava;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/hello")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		AuthorisationService service = new AuthorisationServiceImpl();
		String code = req.getParameter("code");
		Token token = service.tokenExchange(41792, "41f41b41cada9987e2d856039c42c149e6f2ff75", code);
		Strava strava = new Strava(token);
		StravaAthlete athlete = strava.getAthlete(761939);
		resp.getWriter().write("Hello World! Maven Web Project Example.");
	}
}