package test;



import org.junit.Before;
import org.junit.Test;

import main.*;

import static org.junit.Assert.assertEquals;

/**
 * @author traorea
 *
 */
public class MatchRandomTest {
    private Competitor competitor1;
    private Competitor competitor2;
    private MatchRandom matchRandom;

    @Before
    public void init(){
        this.competitor1 = new Competitor("Team 1");
        this.competitor2 = new Competitor("Team 2");
        this.matchRandom = new MatchRandom();
    }

    @Test
    public void ifWinnerPointChangeAfterCallPlayMatch(){
        int sumPointBeforePlayMatch = this.competitor1.getPoints() + this.competitor2.getPoints();
        this.matchRandom.playMatch(competitor1, competitor2);
        assertEquals(sumPointBeforePlayMatch+1, competitor1.getPoints()+competitor2.getPoints());
    }
}
