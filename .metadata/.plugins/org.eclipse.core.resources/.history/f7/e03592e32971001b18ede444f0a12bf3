package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.ClientDao;
import fr.epsi.dao.ClientDaoImpl;
import fr.epsi.entite.Client;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientServiceImpl implements ClientService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource
    private UserTransaction utx;
	
	public void createClient(Client p) {
		ClientDao dao=new ClientDaoImpl(em, utx);
		dao.create(p);
	}
	
	public List<Client> getClients() {
		ClientDao dao=new ClientDaoImpl(em, utx);
		return dao.getClients();
	}

}
