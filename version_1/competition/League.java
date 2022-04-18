package competition;

import java.util.List;


/**
 * @author traorea
 * 
 * League class
 *
 */
public class League extends Competition{
    /**
     * Constructor for League
     * @param competitorList
     */
    public League(List<Competitor>competitorList){
        super(competitorList);
    }

    @Override
    protected void play(final List<Competitor> competitors) throws EmptyCompetitorListException {
        if(competitors.isEmpty())
            throw new EmptyCompetitorListException("competitor's list should not be empty");

        this.competitorList.forEach(competitor -> this.competitorList.forEach(competitor2 ->{
            if(!competitor.equals(competitor2)){
                this.playMatch(competitor, competitor2);
            }
        }));
        classification();
    }
    /***
     * return true if competitor's list size is power of 2, false else
     */

    @Override
    public boolean isPowerOfTwo(List<Competitor> competitorsList) {
        return (((float)competitorList.size()/2)%2)==0.0;
    }

    /**
     * put the competitor in the Map
     */
    public void classification(){
        this.competitorList.forEach(competitor -> {
            this.competitors.put(competitor, competitor.getPoints());
        });
    }
}
