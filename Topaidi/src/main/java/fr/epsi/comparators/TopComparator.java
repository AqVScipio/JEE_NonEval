package fr.epsi.comparators;

import java.util.Comparator;
import java.util.Date;

import fr.epsi.entite.Idee;

public class TopComparator implements Comparator<Idee> {
	
    public int compare(Idee o1, Idee o2) {
    	if(o1.getPercentTops() < o2.getPercentTops())
    		return -1;
    	else if(o1.getPercentTops() > o2.getPercentTops())
    		return 1;
    	else {
    		if(o1.getNbTops() < o2.getNbTops())
        		return -1;
        	else if(o1.getNbTops() > o2.getNbTops())
        		return 1;
        	else {
        		if(least(o1.getDatePublication(), o2.getDatePublication()) == o2.getDatePublication())
            		return -1;
            	else 
            		return 1;
        	}
    	}

	}
    
    public static Date least(Date a, Date b) {
        return a == null ? b : (b == null ? a : (a.before(b) ? a : b));
    }
}
