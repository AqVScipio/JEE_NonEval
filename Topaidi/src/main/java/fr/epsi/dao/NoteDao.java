package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Note;
import fr.epsi.entite.NoteId;

public interface NoteDao {
    void create(Note p);
	List<Note> getNotes();
	Note getNote(NoteId id);
}
