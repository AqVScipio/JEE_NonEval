package fr.epsi.comparators;

import java.util.Comparator;

import fr.epsi.entite.Utilisateur;

public class BrainsComparator implements Comparator<Utilisateur> {
	
    public int compare(Utilisateur o1, Utilisateur o2) {
    	if(o1.getIdees().size() < o2.getIdees().size())
    		return -1;
    	else 
    		return 1;
	}
}
