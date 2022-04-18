package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author traorea
 *
 */
public class SixteenTeam extends SelectTeamMethod{
    public SixteenTeam(){}
    /**
     * allows to cut the competitor's list according to the type of method select
     *
     * @param groupStage     a map that contains for each key a list of competitor
     * @param competitorList competitor's list
     */
    @Override
    public void selectTeamMethod(Map<Integer, List<Competitor>> groupStage, List<Competitor> competitorList) throws NumberOfCompetitorsNotAchievedException{
        List<Competitor>competitors = new ArrayList<>();
        int cpt = 1;
        if(competitorList.size() != 16)
            throw new NumberOfCompetitorsNotAchievedException("number of competitors should be equal to 16");
        for(int i =0; i<competitorList.size(); i++){
            competitors.add(competitorList.get(i));
            if(competitors.size() == 4){
                groupStage.put(cpt, competitors);
                competitors = new ArrayList<>();
                cpt++;
            }
        }
    }

    /**
     * allows to select the teams according an certain criteria define by each class that implement the method
     *
     * @param hens  competitor's list those who just finish to play
     * @param teamForPhaseTwo competitor's list for next step
     */
    @Override
    public void selectTeamForPhaseTwo(List<Competitor> hens, List<Competitor> teamForPhaseTwo) {
        teamForPhaseTwo.addAll(this.bestCompetitors(hens));
    }

}
