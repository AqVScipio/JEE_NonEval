package fr.epsi.comparators;

import java.util.Comparator;
import java.util.Date;

import fr.epsi.entite.Idee;

public class BuzzComparator implements Comparator<Idee> {
	
    public int compare(Idee o1, Idee o2) {
    	if(o1.getNotes().size() < o2.getNotes().size())
    		return -1;
    	else 
    		return 1;
	}
}
