package main;

/**
 * @author traorea
 *
 */
public class Competitor{
    private String pseudo;
    private int points;

    /**
     * @param pseudo
     */
    
    public Competitor(String pseudo) {
        this.pseudo = pseudo;
        this.points = 0;
    }

   
    /**
     * @return pseudo
     */
    public String getPseudo() {
        return pseudo;
    }


    /**
     *
     * @return a points.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Set a competitor  points
     */
    public void setPoints() {
        this.points += 1;
    }

    /**
     * reset the point to zero
     */
    /**
     * 
     */
    public void resetPoint(){
        this.points = 0;
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
