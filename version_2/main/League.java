package main;

import java.util.List;
/**
 * @author traorea
 *
 */

public  class League extends Competition {

    /**
     * Constructor for League
     *
     * 
     */
    public League(List<Competitor>competitorList){
        super(competitorList);
    }

  
   
  
   
  
    /**
     * allow to play all the match according to type of competition
     *
     * @param competitors list of competitors
     * @throws EmptyCompetitorListException
     * @ throw new exception if competitor's list empty
     */
   
    public void play(List<Competitor> competitors) throws EmptyCompetitorListException {
        if(competitors.isEmpty())
            throw new EmptyCompetitorListException("competitor's list should not be empty");

        competitors.forEach(competitor -> competitors.forEach(competitor2 ->{
            if(!competitor.equals(competitor2)){
                this.playMatch(competitor, competitor2);
            }
        }));
        classification(competitors);
    }

    /**
     *
     *
     * return true if competitor's list size is power of 2, false else
     */
    @Override
    public boolean isPowerOfTwo(List<Competitor> competitorsList) {
        return (((float)competitorList.size()/2)%2)==0.0;
    }

    /**
     * put the competitor in the Map
     */
    public void classification(List<Competitor>competitorList){
        competitorList.forEach(competitor -> {
            this.competitors.put(competitor, competitor.getPoints());
        });
    }
}
