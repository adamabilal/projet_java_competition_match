package main;
/*
 * @author traorea_sharfeldin
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TwoFirstPlusTwoSecondStrategy extends SelectTeamMethodStrategy{
    private final int NBCOMPETITOR = 32;
    private List<Competitor>bestSecond = new ArrayList<>();

    /**
     * allows to cut the competitor's list according to the type of method select
     *
     * @param groupStage     a map that contains for each key a list of competitor
     * @param competitorList competitor's list
     */
    @Override
    public void selectTeamMethod(Map<Integer, List<Competitor>> groupStage, List<Competitor> competitorList) throws NumberOfCompetitorsNotAchievedException {
        List<Competitor>competitors = new ArrayList<>();
        int cpt = 1;
        if(competitorList.size() != NBCOMPETITOR)
            throw new NumberOfCompetitorsNotAchievedException("number of competitors should be equal to "+NBCOMPETITOR);
        for (Competitor competitor : competitorList) {
            competitors.add(competitor);
            if (competitors.size() == 8) {
                groupStage.put(cpt, competitors);
                competitors = new ArrayList<>();
                cpt++;
            }
        }
    }

    
    /**
     * allows to select the teams according an certain criteria define by each class that implement the method
     * select the two first of each group and then select the two second
     * @param hens            competitor's list those who just finish to play
     * @param teamForPhaseTwo competitor's list for next step
     */
    @Override
    void selectTeamForPhaseTwo(List<Competitor> hens, List<Competitor> teamForPhaseTwo) {
        teamForPhaseTwo.addAll(this.bestCompetitors(hens));
        this.bestSecond.addAll(this.bestCompetitors(hens));
        if(this.bestSecond.size() == 8){
            teamForPhaseTwo.addAll(this.bestSecond);
        }
    }
}
