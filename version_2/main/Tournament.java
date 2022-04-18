package main;

import java.util.List;


/**
 * @author traorea
 *
 */
public class Tournament extends Competition{

    /**
     * Constructor for Tournament
     *
     * @param competitorList .
     */
    public Tournament(List<Competitor> competitorList) {
        super(competitorList);
    }

    /**
     * allow to play all the match according to type of competition
     *
     * @param competitors list of competitors
     * @throws EmptyCompetitorListException
     * @throws ListSizeIsNotPowerOfTwoException
     * @ throw new exception if competitor's list empty
     * throw new exception if competitor's list size should  not be power of 2
     */
    @Override
    public void play(List<Competitor> competitorList) throws EmptyCompetitorListException, ListSizeIsNotPowerOfTwoException{
        if(competitorList.isEmpty())
            throw new EmptyCompetitorListException("competitor's list should not be empty");
        if(isPowerOfTwo(competitorList)){
            boolean flag = true;
            int cpt = 0;
            while (flag){
                this.playMatch(competitorList.get(cpt), competitorList.get(cpt+1));
                if(competitorList.get(cpt).getPoints()>competitorList.get(cpt+1).getPoints())
                    competitorList.remove(competitorList.get(cpt+1));
                else
                    competitorList.remove(competitorList.get(cpt));
                cpt ++;
                if(cpt == competitorList.size())
                    cpt = 0;
                if(competitorList.size() == 1)
                    flag = false;
            }
            classification(competitorList);
        }else{
            throw new ListSizeIsNotPowerOfTwoException("competitor's list size should be power of 2");
        }
    }

    /**
     *
     * return true if list of competitors is power of 2, false else
     */
    public boolean isPowerOfTwo(List<Competitor>competitorList){
        if(competitorList.size() == 12 || competitorList.size() ==20 )
            return false;
        return (((float)competitorList.size()/2)%2)==0.0;
    }
    /**
     * classification
     */
    public void classification(List<Competitor>competitorList){
        competitorList.forEach(competitor -> {
            this.competitors.put(competitor, competitor.getPoints());
        });
    }
}
