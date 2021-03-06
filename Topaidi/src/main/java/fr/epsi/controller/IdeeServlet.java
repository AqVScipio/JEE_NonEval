package fr.epsi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.comparators.BrainsComparator;
import fr.epsi.comparators.BuzzComparator;
import fr.epsi.comparators.TopComparator;
import fr.epsi.entite.Idee;
import fr.epsi.entite.Utilisateur;
import fr.epsi.service.IdeeService;
import fr.epsi.service.UtilisateurService;

@WebServlet("/idees")
public class IdeeServlet extends HttpServlet {

	@EJB
	private IdeeService iService;

	@EJB
	private UtilisateurService uService;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Alerte !");
		HttpSession sess = req.getSession();
		if (sess.getAttribute("userID") != null) {
			req.setAttribute("username", uService.getUtilisateur((Long) sess.getAttribute("userID")).getUsername());
			req.setAttribute("userID", (Long) sess.getAttribute("userID"));

			// Returns Create Idea Form
			if (req.getParameter("action").equals("create"))
				this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/ideeCreate.jsp").forward(req, resp);

			// Returns Buzz page
			else if (req.getParameter("action").equals("buzz")) {
				List<Idee> idees = iService.getIdees();
				List<Idee> buzz = new ArrayList<Idee>();
				if (!idees.isEmpty()) {
					Collections.sort(idees, new BuzzComparator());
					if (idees.size() > 3) {
						for (int i = 0; i < 3; i++) {
							buzz.add(idees.get(i));
						}
					} else
						buzz = idees;

					req.setAttribute("idees", buzz);
				}
				this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/classementNotes.jsp").forward(req,
						resp);
			}

			// Returns Tops Page
			else if (req.getParameter("action").equals("tops")) {
				List<Idee> idees = iService.getIdees();
				List<Idee> tops = new ArrayList<Idee>();
				if (!idees.isEmpty()) {
					Collections.sort(idees, new TopComparator());
					if (idees.size() > 3) {
						for (int i = 0; i < 3; i++) {
							tops.add(idees.get(i));
						}
					} else
						tops = idees;

					req.setAttribute("idees", tops);
				}
				this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/classementTops.jsp").forward(req, resp);
			}

			// Returns Brains page
			else if (req.getParameter("action").equals("brains")) {
				List<Utilisateur> users = uService.getUtilisateurs();
				List<Utilisateur> brains = new ArrayList<Utilisateur>();
				if (!users.isEmpty()) {
					Collections.sort(users, new BrainsComparator());
					if (users.size() > 3) {
						for (int i = 0; i < 3; i++) {
							brains.add(users.get(i));
						}
					} else
						brains = users;

					req.setAttribute("brains", brains);
				}
				this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/classementBrains.jsp").forward(req,
						resp);
			}

			// Returns list of Ideas
			else {
				List<Idee> idees = iService.getIdees();
				req.setAttribute("idees", idees);
				this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/ideeList.jsp").forward(req, resp);
			}
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/home.jsp").forward(req, resp);
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		Idee p = new Idee();
		Utilisateur u = new Utilisateur();

		u.setId((Long) sess.getAttribute("userID"));
		p.setTitre(req.getParameter("titre"));
		p.setPitch(req.getParameter("pitch"));
		p.setDatePublication(new Date());
		p.setInitiateur(u);
		iService.createIdee(p);
		// this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/ideeList.jsp").forward(req,
		// resp);
		resp.sendRedirect(req.getContextPath() + "/idees?action=list");
	}
}
