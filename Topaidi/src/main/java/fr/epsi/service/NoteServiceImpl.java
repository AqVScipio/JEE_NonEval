package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.NoteDao;
import fr.epsi.dao.NoteDaoImpl;
import fr.epsi.entite.Idee;
import fr.epsi.entite.Note;
import fr.epsi.entite.Utilisateur;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class NoteServiceImpl implements NoteService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;

	public void createNote(Note p) {
		NoteDao dao = new NoteDaoImpl(em, utx);
		dao.create(p);
	}

	public List<Note> getNotes() {
		NoteDao dao = new NoteDaoImpl(em, utx);
		return dao.getNotes();
	}

	public Note getNote(Utilisateur user, Idee idea) {
		NoteDao dao = new NoteDaoImpl(em, utx);
		Note note = dao.getNote(user, idea);
		return note;
	}

}
