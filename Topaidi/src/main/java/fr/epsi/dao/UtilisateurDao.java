package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Utilisateur;

public interface UtilisateurDao {
    void create(Utilisateur p);
    Utilisateur getUtilisateur(Long id);
    Utilisateur getUtilisateur(String name);
	List<Utilisateur> getUtilisateurs();
}
