package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 * @author traorea
 *
 */
public class TwentyFourTeamStrategy extends SelectTeamMethodStrategy {
    private final int NBCOMPETITOR = 24;

    private List<Competitor>bestThird = new ArrayList<>();
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
     * select the two first of each hens and then select the best second of each hens, then select the 2 best second in the of 3
     * @param hens competitor's list those who just finish to play
     * @param teamForPhaseTwo competitor's list for next step
     */
    @Override
    public void selectTeamForPhaseTwo(List<Competitor> hens, List<Competitor> teamForPhaseTwo) {
        teamForPhaseTwo.addAll(this.bestCompetitors(hens));
        this.bestThird.add(this.bestCompetitor(hens));
        if(this.bestThird.size() == 3){
            while (this.bestThird.size() != 1) {
                Competitor best = this.bestCompetitor(this.bestThird);
                teamForPhaseTwo.add(best);
                this.bestThird.remove(best);
            }
        }
    }
}
