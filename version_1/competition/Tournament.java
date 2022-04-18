package competition;

import java.util.List;


/**
 * 
 * Tournament class
 * 
 * 
 * @author traorea
 *
 */
public class Tournament extends Competition{
	/**
	 * Constructor for Tournament
	 * @param competitorList
	 */

    public Tournament(List<Competitor> competitorList) {
        super(competitorList);
        
    }

    @Override
    protected void play(List<Competitor> competitorList) throws EmptyCompetitorListException, ListSizeIsNotPowerOfTwoException{
        if(competitorList.isEmpty())
            throw new EmptyCompetitorListException("competitor's list should not be empty");
        if(isPowerOfTwo(competitorList)){
            boolean flag = true;
            int cpt = 0;
            while (flag){
                this.playMatch(this.competitorList.get(cpt), this.competitorList.get(cpt+1));
                if(this.competitorList.get(cpt).getPoints()>this.competitorList.get(cpt+1).getPoints())
                    this.competitorList.remove(this.competitorList.get(cpt+1));
                else
                    this.competitorList.remove(this.competitorList.get(cpt));
                cpt ++;
                if(cpt == this.competitorList.size())
                    cpt = 0;
                if(this.competitorList.size() == 1)
                    flag = false;
            }
            classification();
        }else{
            throw new ListSizeIsNotPowerOfTwoException("competitor's list size should be power of 2");
        }
    }
/**
 * return true if list of competitors is power of 2, false else
 * 
 */
   
    public boolean isPowerOfTwo(List<Competitor>competitorList){
        return (((float)competitorList.size()/2)%2)==0.0;
    }
   /**
    * 
    * classification
    */
    public void classification(){
        this.competitorList.forEach(competitor -> {
            this.competitors.put(competitor, competitor.getPoints());
        });
    }
}
