package main;

import java.util.*;

import static util.MapUtil.sortByDescendingValue;

/**
 * @author traorea
 *
 */
public abstract class Competition{
    protected Match match;
    protected List<Competitor>competitorList;
    protected Map<Competitor, Integer>competitors = new HashMap<>();

    
    public Competition(List<Competitor> competitorList) {
        this.competitorList = competitorList;
        this.match = new MatchRandom();
    }

    /**
     * start the competition
     * @throws competition.EmptyCompetitorListException -if competition's list size is empty
     */
    public void play() throws EmptyCompetitorListException, ListSizeIsNotPowerOfTwoException {
        play(this.competitorList);
    }

    /**
     * allow to play all the match according to type of competition
     *
     * @param competitors list of competitors
     * @throws
     * competition.EmptyCompetitorListException throws an exception when that list is empty
     * competition.ListSizeIsNotPowerOfTwoException throws an exception when list's size is not power of 2
     *
     */
    public abstract void play(List<Competitor>competitors)throws EmptyCompetitorListException, ListSizeIsNotPowerOfTwoException;

    /**
     * allow to play a Match
     *
     * @param competitor1 first competitor
     * @param competitor2 second competitor
     */
    protected void playMatch(Competitor competitor1, Competitor competitor2){
        Competitor winner = this.match.playMatch(competitor1, competitor2);
        displayWinner(competitor1, competitor2, winner);
    }

    /**
     * sort the competitors by their points
     *
     * @return a Map of the competitor sorted by their points
     */
    public Map<Competitor, Integer> ranking(){
        return sortByDescendingValue(this.competitors);
    }

    /**
     * display the winner
     * @param c1 competitor one
     * @param c2 competitor two
     */
    private void displayWinner(Competitor c1, Competitor c2, Competitor winner){
        System.out.println(c1.toString()+" vs "+c2.getPseudo()+ " ---> "+winner.getPseudo()+" wins !  🏆");
    }

    /**
     *classification.
     */
    public abstract void classification(List<Competitor>competitorList);


    /**
     * return true if competitor's list size is power of 2, false else
     *
     * @param competitorsList .
     * @return true or false
     */
    public abstract boolean isPowerOfTwo(List<Competitor>competitorsList);



}
