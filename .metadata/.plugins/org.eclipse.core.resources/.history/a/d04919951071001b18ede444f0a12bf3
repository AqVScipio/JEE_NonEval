package fr.epsi.entite;

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
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Numero;
	private double prix;
	private Date date;

	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@OneToMany(mappedBy="facture")
	private List<LigneFacture> ligneFactures;
	
	public Facture() {}
	public Facture(Client client, String numero, Date date, List<LigneFacture> ligneFactures) {
		this.setClient(client);
		this.setNumero(numero);
		this.setDate(date);
		this.setLigneFactures(ligneFactures);
		
		for (LigneFacture lf : ligneFactures) {
			this.prix += lf.getPrix();
		}
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public List<LigneFacture> getLigneFactures() {
		return ligneFactures;
	}
	public void setLigneFactures(List<LigneFacture> ligneFactures) {
		this.ligneFactures = ligneFactures;
	}
	
	
}
