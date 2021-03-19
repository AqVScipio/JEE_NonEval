package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Idee;
import fr.epsi.entite.Note;
import fr.epsi.entite.Utilisateur;

public interface NoteService {
	void createNote(Note p);
	Note getNote(Utilisateur user, Idee idea);
    List<Note> getNotes();
}
