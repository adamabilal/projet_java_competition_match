package main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author traorea  sharfeldin
 *
 */

public class Journalists implements CompetitionObserver{
    private String mediaName;
    protected static List<CompetitionObserver>observerList = new ArrayList<>();

    /**
     * @param mediaName
     */
    public Journalists(String mediaName){
        this.mediaName = mediaName;
    }
    
    /**
     * @param c1
     * @param c2
     * @param winner
     * display information of the match
     */
    @Override
    public void watchMatch(Competitor c1, Competitor c2, Competitor winner) {
		
    }

	@Override
	public void watchPoule(List<Competitor> competitorList) {
		
	}

	public String getMediaName() {
		return mediaName;
	}

	@Override
	public void watchCote(List<Competitor> competitorList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void watchTeam(List<Competitor> competitorList) {
		// TODO Auto-generated method stub
		
	}

	
}
