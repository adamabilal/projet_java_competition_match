package main;


import java.util.*;
import java.util.Map.Entry;



public class Master  extends Competition {
	private Map<Integer, List<Competitor>>groupStage;
    private List<Competitor>competitorsForPhaseTwo;
    private SelectTeamMethodStrategy selectTeamMethod;
    
 
    /**
     * constructor Master
     * @param competitorList
     * @param selectTeamMethod
     */
    public Master(List<Competitor> competitorList, SelectTeamMethodStrategy selectTeamMethod) {
        super(competitorList);
        this.groupStage = new HashMap<>();
        this.competitorsForPhaseTwo = new ArrayList<>();
        this.selectTeamMethod = selectTeamMethod;
    }
    
    /**
     * @param msg
     * display message
     */
    private void speaker(String msg){
        System.out.println("*********** "+ msg + " ************");
    }
    
    /**
     * allows all the hens in the competition to play
     * @throws EmptyCompetitorListException
     * @throws ListSizeIsNotPowerOfTwoException 
     */
    private void groupStage() throws EmptyCompetitorListException, NumberOfCompetitorsNotAchievedException, ListSizeIsNotPowerOfTwoException {
       
        this.selectTeamMethod.selectTeamMethod(this.groupStage, this.competitorList);
        System.out.println("       Les poules :");
        System.out.println("----------");
       
        for(Entry<Integer, List<Competitor>> entry : this.groupStage.entrySet()) {
        	System.out.format("              Poule %d \n", entry.getKey());
        	System.out.println("===================================");
        	for(Competitor c : entry.getValue()) {
        		System.out.println("       "+c.getPseudo());
        	}
        	System.out.println("======================================");
        }
        System.out.println("======================================");
        League league;
        Tournament tournament;
        List<Competitor> competitorList;
        
        for(Entry<Integer, List<Competitor>> entry : this.groupStage.entrySet()) {
        	competitorList = entry.getValue();
            league = new League(competitorList);
            
            System.out.println("-----------------------------");
            this.speaker(" Poule N°"+entry.getKey()+ " -  Matchs");
            System.out.println("-----------------------------");
            
            league.play(competitorList);
            
            System.out.println("-----------------------------");
            this.speaker(" Poule N°"+entry.getKey()+ " -  Cotes");
            System.out.println("-----------------------------");
            this.watchPoule(competitorList);
            System.out.println("----------------------");
        }
        this.speaker(" Équipes Sélectionnées ");
        System.out.println("-----------------------------");
        for(Entry<Integer, List<Competitor>> entry : this.groupStage.entrySet()) {
        	System.out.println("-----------------------------");
        	System.out.format("              Poule %d \n", entry.getKey());
        	System.out.println("-----------------------------");
        	competitorList = entry.getValue();
            this.watchCote(competitorList);
            System.out.println();

        }
        System.out.println("===================================");
    	System.out.println("        Le tournoi ! ");
    	System.out.println(" ");
    	System.out.println("        Les équipes");
    	System.out.println("------------------------");
    	System.out.println(" ");
    for(Entry<Integer, List<Competitor>> entry : this.groupStage.entrySet()) {
    	competitorList = entry.getValue();
    	this.watchTeam(competitorList);
    	 
       }
    
          System.out.println();
          System.out.println("===================================");
		  System.out.println("        Les Matchs");
		  System.out.println("------------------------");
		  System.out.println("        1/4 finales");
		  System.out.println();
		  for(Entry<Integer, List<Competitor>> entry : this.groupStage.entrySet()) {
		  competitorList = entry.getValue();
		  tournament = new Tournament(competitorList);
		  tournament.play(competitorList);
          
		  
		  } 
		
		
		  System.out.println(" "); 
		  System.out.println("------------------------");
		  System.out.println("        1/2 finales"); 
		  System.out.println(" ");
		  for(Entry<Integer, List<Competitor>> entry : this.groupStage.entrySet()) {
		  competitorList = entry.getValue();
		  
		  tournament = new Tournament(competitorList);
		  tournament.play(competitorList); }
		  
		  System.out.println(" "); 
		  System.out.println("------------------------");
		  System.out.println("         finale"); 
		  for(Entry<Integer, List<Competitor>> entry : this.groupStage.entrySet()) { 
		  competitorList = entry.getValue();
		  tournament = new Tournament(competitorList); 
		  tournament.play(competitorList);
		  
		  }
		 
		 
		 
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
            

        }catch (NumberOfCompetitorsNotAchievedException e){
            e.printStackTrace();
        }
    }

    /**
     * <p>classification.</p>
     */
    @Override
    public void classification(List<Competitor> competitorList) {
        competitorList.forEach(competitor -> {
            this.competitors.put(competitor, competitor.getCote());
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
