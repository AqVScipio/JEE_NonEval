package fr.epsi.entite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	
	@OneToMany(mappedBy="utilisateur")
	private List<Note> notes = new ArrayList<Note>();
	
	@OneToMany(mappedBy="initiateur")
	private List<Idee> idees = new ArrayList<Idee>();
	
	public List<Idee> getIdees() {
		return idees;
	}
	public void setIdees(List<Idee> idees) {
		this.idees = idees;
	}
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
