package main;

import static util.MapUtil.sortByDescendingValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Competition {
    protected Match match;
    protected List<Competitor>competitorList;
    protected Map<Competitor, Integer>competitors = new HashMap<>();
    protected static List<CompetitionObserver>observerList = new ArrayList<>();
    /**
     * constructor Competition
     * @param competitorList
     */
    public Competition(List<Competitor> competitorList) {
        this.competitorList = competitorList;
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
        this.match = new MatchRandom();
        Competitor winner = this.match.playMatch(competitor1, competitor2);

        displayWinner(competitor1, competitor2, winner);
        this.watchMatch(competitor1, competitor2, winner);
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
        System.out.println("   "+c1.getPseudo()+" vs "+c2.getPseudo()+ " => "+winner.getPseudo());
    }

    /**
     * classification
     */
    public abstract void classification(List<Competitor> competitorList);


   
    public abstract boolean isPowerOfTwo(List<Competitor> competitorsList);

    /**
     * add observer to the list of observers
     * @param observer
     */
    public void addObserver(CompetitionObserver observer){
        observerList.add(observer);
    }

    /**
     * remove observer from list of observers
     * @param observer
     */
    public void removeObserver(CompetitionObserver observer){
        observerList.remove(observer);
    }

    /**
     * loop over the list of observer then apply the specific method watchMatch
     * @param c1 Competitor
     * @param c2 Competitor
     * @param winner Competitor "the winner between c1 and c2"
     */
    public void watchMatch(Competitor c1, Competitor c2, Competitor winner){
        observerList.forEach(observer -> {
            observer.watchMatch(c1, c2, winner);
        });
    }
    
    /**
     * loop over the list of observer then apply the specific method watchPoule
     * @param competitorList
     * @return winner competitor list
     */
    public void watchPoule(List<Competitor> competitorList){
        observerList.forEach(observer -> {
            observer.watchPoule(competitorList);
        });
    }

    /**
     * 
     * @param journalists
     * @return true if it has at list one journalists  
     */
	public boolean contains(Journalists journalists) {
			return true;
			
	}
	 
	public void watchCote(List<Competitor> competitorList) {
		 observerList.forEach(observer -> {
	            observer.watchCote(competitorList);
	        });
	         
	}
	public void watchTeam(List<Competitor> competitorList) {
		 observerList.forEach(observer -> {
	            observer.watchTeam(competitorList);
	        });
	         
	}

    }