package test;


import org.junit.Before;
import org.junit.Test;

import main.*;

import static org.junit.Assert.assertEquals;

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
        int sumPointBeforePlayMatch = this.competitor1.getCote() + this.competitor2.getCote();
        this.matchRandom.playMatch(competitor1, competitor2);
        assertEquals(sumPointBeforePlayMatch+1, competitor1.getCote()+competitor2.getCote());
    }
}
