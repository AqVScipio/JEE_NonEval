package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.ArticleDao;
import fr.epsi.dao.ArticleDaoImpl;
import fr.epsi.entite.Article;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ArticleServiceImpl implements ArticleService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource
    private UserTransaction utx;
	
	public void createArticle(Article p) {
		ArticleDao dao=new ArticleDaoImpl(em, utx);
		dao.create(p);
	}

	public List<Article> getArticles() {
		ArticleDao dao=new ArticleDaoImpl(em, utx);
		return dao.getArticles();
	}

}
