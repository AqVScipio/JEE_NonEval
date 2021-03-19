package fr.epsi.entite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Idee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String pitch;
	private Date datePublication;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="idee")
	private List<Note> notes = new ArrayList<Note>();
	
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur initiateur;
	
	public Utilisateur getInitiateur() {
		return initiateur;
	}
	public void setInitiateur(Utilisateur initiateur) {
		this.initiateur = initiateur;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getPitch() {
		return pitch;
	}
	public void setPitch(String pitch) {
		this.pitch = pitch;
	}
	public Date getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}
	
	public int getNbTops() {
		int sum = 0;
		for(Note n : this.getNotes()) {
			sum += n.getNote() == 1 ? 1 : 0;
		}
		return sum;
	}
	public int getNbFlops() {
		int sum = 0;
		for(Note n : this.getNotes()) {
			sum += n.getNote() == 0 ? 1 : 0;
		}
		return sum;
	}
	
	public boolean canVote(Long userID) {
		if(this.getInitiateur().getId() == userID) return false;
		
		for(Note n : this.getNotes()) {
			if (n.getUtilisateur().getId() == userID) return false;
		}
		
		long date1InMs = this.getDatePublication().getTime();
		long date2InMs = new Date().getTime();
		long timeDiff = date2InMs - date1InMs;
		int daysDiff = (int) (timeDiff / (1000 * 60 * 60* 24));

		if(daysDiff > 7) return false;
		
		return true;
	}
	
	public double getPercentTops() {
		if(this.getNotes().size() == 0) return 0;
		
		int nbTops = 0;
		
		for(Note n : this.getNotes()) {
			if (n.getNote() == 1) nbTops ++;
		}
		
		return (nbTops / this.getNotes().size()) * 100;
	}
}
