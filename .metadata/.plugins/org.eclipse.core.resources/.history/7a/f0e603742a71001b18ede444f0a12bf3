package fr.epsi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Article;
import fr.epsi.service.ArticleService;

@WebServlet("/articles")
public class ArticleServlet extends HttpServlet{
	
	@EJB
	private ArticleService service;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
			if(req.getParameter("action").equals("create"))
	    		this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/articleCreate.jsp").forward(req, resp);
			else {
				req.setAttribute("articles", service.getArticles());
				this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/articleListe.jsp").forward(req, resp);
			}
	    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
		   	Article p=new Article();
		   	try {
		   		p.setPrix(Double.parseDouble(req.getParameter("prixArticle")));
		   	}catch (NumberFormatException e) {
		   	    e.printStackTrace();
		   	}
		   	
		   	p.setNom(req.getParameter("nomArticle"));
		   
		   	service.createArticle(p);
		   	this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/home.jsp").forward(req, resp);
	    }

}
