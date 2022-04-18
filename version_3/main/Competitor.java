package main;

/**
 * @author traorea sharfeldin
 *
 */
public class Competitor {
	
	
	    private String pseudo;
	    private int cote;

	    /**
	     * @param pseudo
	     * 
	     */
	    
	    public Competitor(String pseudo) {
	        this.pseudo = pseudo;
	        this.cote = 0;
	    }

	   
	    /**
	     * @return pseudo
	     */
	    public String getPseudo() {
	        return pseudo;
	    }


	    /**
	     *
	     * @return a cote.
	     */
	    public int getCote() {
	        return cote;
	    }

	    /**
	     * Set a competitor cote
	     */
	    public void setCote() {
	        this.cote += 1;
	    }

	    /**
	     * reset the cote to zero
	     */
	    /**
	     * 
	     */
	    public void resetCote(){
	        this.cote = 0;
	    }
	  
	    /**
	     *tostring
	     */
	    public String toString() {
	        return this.getPseudo() + "";
	    }

	 
	    /**
	     *return boolean
	     */
	    public boolean equals(Object object){
	        if(object instanceof Competitor){
	            Competitor other = (Competitor)object;
	            return this == other;
	        }
	        return false;
	    }



	}

