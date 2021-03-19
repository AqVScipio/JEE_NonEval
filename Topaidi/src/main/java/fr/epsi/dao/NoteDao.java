package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Idee;
import fr.epsi.entite.Note;
import fr.epsi.entite.Utilisateur;

public interface NoteDao {
    void create(Note p);
	List<Note> getNotes();
	Note getNote(Utilisateur user, Idee idea);
}
