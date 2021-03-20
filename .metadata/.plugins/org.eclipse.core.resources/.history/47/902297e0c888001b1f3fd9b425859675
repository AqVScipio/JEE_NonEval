package fr.epsi.entite;

import java.io.Serializable;

public class NoteId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long utilisateur;
	private Long idee;
	
	public NoteId() {
		
	}
	
	public NoteId(Long utilisateur, Long idee) {
		this.utilisateur = utilisateur;
		this.idee = idee;
	}

	public Long getUtilisateur_id() {
		return utilisateur;
	}

	public void setUtilisateur_id(Long utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Long getIdee_id() {
		return idee;
	}

	public void setIdee_id(Long idee) {
		this.idee = idee;
	}
	
	public int hashCode() {
        return (int)this.utilisateur.hashCode();
    }
	
	public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof NoteId)) return false;
        NoteId pk = (NoteId) obj;
        return pk.idee.equals(this.idee) && pk.utilisateur.equals(this.utilisateur);
    }
}
