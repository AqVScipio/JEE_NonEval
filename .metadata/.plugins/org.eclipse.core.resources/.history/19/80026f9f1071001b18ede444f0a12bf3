package fr.epsi.service;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.controller.HomeServlet;
import fr.epsi.entite.Article;
import fr.epsi.entite.Client;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class InitialisationService {
	@PersistenceContext
	private EntityManager em;
	@Resource
    private UserTransaction utx;
	
	@EJB
	private ClientService cs;
	@EJB
	private ArticleService as;	
	
	public void InitializeData() {
		try {
			utx.begin();
			Client client = em.find(Client.class, 1l);
			utx.commit();
			if(client == null) this.generateData();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void generateData() {
		for (Article a : HomeServlet.articles) {
			as.createArticle(a);
		}
		for (Client c : HomeServlet.clients) {
			cs.createClient(c);
		}
	}
}
