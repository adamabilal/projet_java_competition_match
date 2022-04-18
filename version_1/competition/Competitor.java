package competition;


/**
 * @author traorea
 *
 */

public class Competitor {
    private String pseudo;
    private int points;
    

    
    /**
     * 
     *  Constructor for  Competitor
     *  @param pseudo
     *
     */
    public Competitor(String pseudo) {
        this.pseudo = pseudo;
        this.points = 0;
    }

    
    /**
     * Getter for the field
     * @return pseudo
     */
   
    public String getPseudo() {
        return pseudo;
    }


   
    /**
     * Getter for the field
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * setter for the field
     */
    public void setPoints() {
        this.points += 1;
    }

    


    @Override
	public String toString() {
		return  pseudo ;
	}

	/**
     * @param object
     * @return boolean
     */
    public boolean equals(Object object){
        if(object instanceof Competitor){
            Competitor other = (Competitor)object;
            return this == other;
        }
        return false;
    }

}
