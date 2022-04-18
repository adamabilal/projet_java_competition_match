package main;

import java.util.ArrayList;
import java.util.List;



/**
 * @author traorea_sharfeldin
 *  
 *
 */
public class League extends Competition{
	 protected static List<Journalists>journalistsList = new ArrayList<>();
	
    /**
     * @param competitorList
     */
    public League(List<Competitor>competitorList){
        super(competitorList);
    }

    
    @Override
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
            this.competitors.put(competitor, competitor.getCote());
        });
    }



}
