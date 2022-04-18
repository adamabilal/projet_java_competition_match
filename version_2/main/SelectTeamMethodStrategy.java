package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * @author traorea
 *
 */
public abstract class SelectTeamMethodStrategy {
    /**
     * allows to cut the competitor's list according to the type of method select
     * @param groupStage a map that contains for each key a list of competitor
     * @param competitorList competitor's list
     */
    public abstract void selectTeamMethod(Map<Integer, List<Competitor>> groupStage, List<Competitor> competitorList) throws NumberOfCompetitorsNotAchievedException;
    /**
     * allows to select the teams according an certain criteria define by each class that implement the method
     * @param hens competitor's list those who just finish to play
     * @param teamForPhaseTwo competitor's list for next step
     */
    abstract void selectTeamForPhaseTwo(List<Competitor>hens, List<Competitor>teamForPhaseTwo);

    /**
     * return the two best competitors in the group
     * @param hens group of the competitors
     * @return ArrayList
     */
    public List<Competitor> bestCompetitors(List<Competitor>hens){
        List<Competitor>best = new ArrayList<>();
        while (best.size() < 2){
            Competitor bestComp = bestCompetitor(hens);
            best.add(bestComp);
            hens.remove(bestComp);
        }
        return best;
    }

    /**
     * return the best competitor in the group
     * @param group the group of competitors
     * @return ArrayList
     */
    public Competitor bestCompetitor(List<Competitor>group){
        Competitor bestComp = group.get(0);
        for(int i = 1; i<group.size(); i++){
            if(bestComp.getPoints() < group.get(i).getPoints()){
                bestComp = group.get(i);
            }else if(bestComp.getPoints() == group.get(i).getPoints()){
                int random = new Random().nextInt(2);
                bestComp = group.get(random);
            }
        }
        return bestComp;
    }
}
