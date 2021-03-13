package fr.epsi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Facture;

@WebServlet("/factures")
public class FactureServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
			if(req.getParameter("action").equals("list")) {
				req.setAttribute("factures", HomeServlet.factures);
				this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/factureListe.jsp").forward(req, resp);
			}
	    	else {
	    		Facture f = HomeServlet.getFactureByNumero(req.getParameter("action"));
	    		if(f != null){
		    		req.setAttribute("facture", f != null ? f : null);
					this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/factureDetail.jsp").forward(req, resp);
	    		}else {
	    			req.setAttribute("factures", HomeServlet.factures);
					this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/factureListe.jsp").forward(req, resp);
	    		}
	    			
	    	}
	    		
	    }
}
