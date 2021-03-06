package fr.epsi.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Note {
	private byte note;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="utilisateur")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="idee")
	private Idee idee;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Idee getIdee() {
		return idee;
	}

	public void setIdee(Idee idee) {
		this.idee = idee;
	}

	public byte getNote() {
		return note;
	}

	public void setNote(byte note) {
		this.note = note;
	}
	
	public void display() {
		System.out.println(this.getIdee().getId());
		System.out.println(this.getIdee().getTitre());
		System.out.println(this.getUtilisateur().getId());
		System.out.println(this.getUtilisateur().getUsername());
	}
}
