package fr.epsi.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Article;
import fr.epsi.entite.Client;
import fr.epsi.entite.Facture;
import fr.epsi.entite.LigneFacture;
import fr.epsi.service.InitialisationService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
		
	// A appeler au moins une fois pour l'initialisation des données en dur
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
			this.Initialize();
		   	this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/home.jsp").forward(req, resp);
	    }
	
	@EJB
	private InitialisationService is;
	
	// Fonction d'initialisation
	// Sert à créer les premiers éléments de la base
	// Faire abstraction de cette partie
	private void Initialize() {
		is.InitializeData();
	}
	
	// PROPS
	public static List<Article> articles = new ArrayList<Article>() {
		{
			add(new Article("Spoon", 3));
			add(new Article("Fork", 2));
			add(new Article("Knife", 5));
			add(new Article("Bowl", 8));
			add(new Article("Plate", 7));
		}
	};
	
	public static List<Client> clients = new ArrayList<Client>() {
		{
			add(new Client("Mickey MOUSE", "Avenue de la Paix"));
			add(new Client("Donald DUCK", "Gare de Lyon"));
			add(new Client("Dingo", "84520 Winterfell"));
		}
	};
	
	private static List<LigneFacture> lf1 = new ArrayList<LigneFacture>() {
		{
			add(new LigneFacture(articles.get(0), 2));
			add(new LigneFacture(articles.get(1), 4));
			add(new LigneFacture(articles.get(4), 3));
		}
	};
	private static List<LigneFacture> lf2 = new ArrayList<LigneFacture>() {
		{
			add(new LigneFacture(articles.get(1), 1));
			add(new LigneFacture(articles.get(3), 2));
		}
	};	
	private static List<LigneFacture> lf3 = new ArrayList<LigneFacture>() {
		{
			add(new LigneFacture(articles.get(4), 3));
			add(new LigneFacture(articles.get(0), 3));
		}
	};
	private static List<LigneFacture> lf4 = new ArrayList<LigneFacture>() {
		{
			add(new LigneFacture(articles.get(1), 2));
			add(new LigneFacture(articles.get(3), 4));
			add(new LigneFacture(articles.get(4), 5));
			add(new LigneFacture(articles.get(0), 2));
		}
	};
	private static List<LigneFacture> lf5 = new ArrayList<LigneFacture>() {
		{
			add(new LigneFacture(articles.get(2), 4));
			add(new LigneFacture(articles.get(4), 8));
			add(new LigneFacture(articles.get(3), 8));
		}
	};
	private static List<LigneFacture> lf6 = new ArrayList<LigneFacture>() {
		{
			add(new LigneFacture(articles.get(0), 4));
			add(new LigneFacture(articles.get(2), 5));
			add(new LigneFacture(articles.get(4), 3));
		}
	};
	
	public static List<Facture> factures = new ArrayList<Facture>() {
		{
			add(new Facture(clients.get(0), "FC-005", new Date(), lf1));
			add(new Facture(clients.get(0), "FC-083", new Date(), lf2));
			add(new Facture(clients.get(1),"FC-142", new Date(), lf3));
			add(new Facture(clients.get(2),"FC-99", new Date(), lf4));
			add(new Facture(clients.get(2),"FC-117", new Date(), lf5));
			add(new Facture(clients.get(2),"FC-118", new Date(), lf6));
		}
	};
	
	public static Facture getFactureByNumero(String numero) {
		for (Facture f : factures) {
			if(f.getNumero().equals(numero)) return f;
		}
		return null;
	}
}