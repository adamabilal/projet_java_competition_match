package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * @author traorea
 *
 */
public class Master  extends Competition {
    private Map<Integer, List<Competitor>>groupStage;
    private List<Competitor>competitorsForPhaseTwo;
    private SelectTeamMethodStrategy selectTeamMethod;
    /**
     * Constructor for Competition
     *
     * @param competitorList 
     * @param selectTeamMethod
     */
    public Master(List<Competitor> competitorList, SelectTeamMethodStrategy selectTeamMethod) {
        super(competitorList);
        this.groupStage = new HashMap<>();
        this.competitorsForPhaseTwo = new ArrayList<>();
        this.selectTeamMethod = selectTeamMethod;
    }
    private void speaker(String msg){
        System.out.println("*********** "+ msg + " ************");
    }
    /**
     * allows all the hens in the competition to play
     * @throws EmptyCompetitorListException
     * @throws NumberOfCompetitorsNotAchievedException
     */
    private void groupStage() throws EmptyCompetitorListException, NumberOfCompetitorsNotAchievedException {
        this.speaker("Phase de poule");
        this.selectTeamMethod.selectTeamMethod(this.groupStage, this.competitorList);
        League league;
        List<Competitor> competitorList;
        Set<Map.Entry<Integer, List<Competitor>>> competitorListEntry = this.groupStage.entrySet();
        Iterator<Map.Entry<Integer, List<Competitor>>> iterator = competitorListEntry.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, List<Competitor>> entry = iterator.next();
            competitorList = entry.getValue();
            league = new League(competitorList);
            this.speaker(" Matchs poule N° "+entry.getKey()+ " ");
            league.play(competitorList);
            this.selectTeamMethod.selectTeamForPhaseTwo(competitorList, this.competitorsForPhaseTwo);
        }
    }

    /**
     * final phase
     * @throws ListSizeIsNotPowerOfTwoException
     * @throws EmptyCompetitorListException
     */
    private void finaleStage() throws ListSizeIsNotPowerOfTwoException, EmptyCompetitorListException {
        this.speaker("Phase  finale");
        Tournament tournament = new Tournament(this.competitorsForPhaseTwo);
        this.resetCompetitorsPoint(this.competitorsForPhaseTwo);
        tournament.play(this.competitorsForPhaseTwo);
        classification(this.competitorsForPhaseTwo);
    }

    /**
     * reset the competitor's point to zero
     * @param competitorList a list of competitor
     */
    private void resetCompetitorsPoint(List<Competitor>competitorList){
        competitorList.forEach(Competitor::resetPoint);
    }
    /**
     * allows to play all the match according to type of competition
     * @param competitors list of competitors
     * @throws EmptyCompetitorListException throws an exception when that list is empty
     * @throws ListSizeIsNotPowerOfTwoException throws an exception when list's size is not power of 2
     */
    @Override
    public void play(List<Competitor> competitors) throws EmptyCompetitorListException, ListSizeIsNotPowerOfTwoException {
        try{
            this.groupStage();
            this.finaleStage();

        }catch (NumberOfCompetitorsNotAchievedException e){
            e.printStackTrace();
        }

    }

    /**
     * classification
     * @param competitorList a list of competitor
     */
    @Override
    public void classification(List<Competitor>competitorList) {
        competitorList.forEach(competitor -> {
            this.competitors.put(competitor, competitor.getPoints());
        });
    }

    /**
     * return true if competitor's list size is power of 2, false else
     *
     * @param competitorsList .
     * @return true or false
     */
    @Override
    public boolean isPowerOfTwo(List<Competitor> competitorsList) {
        return false;
    }

}
