package main;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookMakers implements CompetitionObserver{
    private Map<Competitor, Integer>rateMap;
    protected static List<CompetitionObserver>observerList = new ArrayList<>();

    /**
     * constructor BookMakers
     * @param bookMakerName
     * @param competitorList
     */
    public BookMakers(String bookMakerName, List<Competitor>competitorList){
        this.rateMap = new HashMap<>();
        competitorList.forEach(competitor -> {
            this.rateMap.put(competitor, 1);
            
        });
    }
    @Override
    public void watchMatch(Competitor c1, Competitor c2, Competitor winner) {
        this.rateUpdate(c1, c2, winner);
        
        
    }
    
    
    public void watchPoule(List<Competitor> competitorList){
       this.displayTheCompetitorsRate(competitorList);
    }
    public void watchCote(List<Competitor> competitorList){
        this.displayTeamSelect(competitorList);
     }
    /**
     * update the competitor's rate
     * @param c1 Competitor "team 1"
     * @param c2 Competitor "team 2"
     * @param winner Competitor "the winner between the two"
     */
    public void rateUpdate(Competitor c1, Competitor c2, Competitor winner){
        int winnerRate = competitorRate(winner)-1;
        if(winnerRate <= 0)
            this.rateMap.put(winner, 1);
        else
            this.rateMap.put(winner, winnerRate);
        this.rateMap.put(looser(c1, c2, winner), competitorRate(looser(c1, c2, winner))+1);
        
    }

    /**
     * return the looser between the two
     * @param c1 Competitor "team 1"
     * @param c2 Competitor "team 2"
     * @param winner Competitor "the winner between the two"
     * @return Competitor
     */
    public Competitor looser(Competitor c1, Competitor c2, Competitor winner){
        if(!c1.equals(winner))
            return c1;
        return c2;
    }
    /**
     * return the competitor's rate
     * @param competitor "a competitor"
     * @return int
     */
    public int competitorRate(Competitor competitor){
        return this.rateMap.get(competitor);
    }

    /**
     * display the competitor's rate
     */
	

    public void displayTheCompetitorsRate(List<Competitor> competitorList){  
    for (Competitor c:competitorList) {
	  System.out.println(c.getPseudo() + " Cote : " + competitorRate(c));
	  
	  }
    }
    /*
     * display team select
     */
    public void displayTeamSelect(List<Competitor> competitorList) {
    	for (Competitor c:competitorList) {
    		if (competitorRate(c)==1 ) {
    			System.out.println("         "+c.getPseudo() +"*");
    		}
    		else if (competitorRate(c)==2 ) {
    			System.out.println("         "+c.getPseudo() +"*");
    		}
    		else System.out.println("         "+c.getPseudo());
    	}
    }	 
	public void displayTeam(List<Competitor> competitorList) {
		for (Competitor c:competitorList) {
    		if (competitorRate(c)==1 ) {
    			System.out.println("         "+c.getPseudo());
    		}
    		else if (competitorRate(c)==2 ) {
    			System.out.println("         "+c.getPseudo() );
    		}
    		else;
	}
	}
	@Override
	public void watchTeam(List<Competitor> competitorList) {
		this.displayTeam(competitorList);
		
	}
}