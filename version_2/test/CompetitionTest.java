package test;


import org.junit.Before;
import org.junit.Test;

import main.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author traorea
 *
 */
public abstract class CompetitionTest {
    protected   Match match;
    protected   List<Competitor> competitorsList;
    protected Competition competition;

    protected abstract Competition createCompetition(List<Competitor>competitorsList);

    @Before
    public void init(){
        this.competitorsList = new ArrayList<>();
        this.match = new MatchRandom();
        this.competition = this.createCompetition(this.competitorsList);
    }

    @Test(expected = EmptyCompetitorListException.class)
    public void throwsEmptyCompetitorExceptionWhenPlayIsCallOnWithEmptyList() throws EmptyCompetitorListException, ListSizeIsNotPowerOfTwoException {
        this.competition.play(this.competitorsList);
    }
    @Test
    public void falseWhenCompetitorsListSizeIsNotPowerOfTwo(){
        Competitor c1 = new Competitor("Team1");
        Competitor c2 = new Competitor("Team2");
        Competitor c3 = new Competitor("Team3");
        competitorsList.add(c1);
        competitorsList.add(c2);
        competitorsList.add(c3);
        assertFalse(this.competition.isPowerOfTwo(this.competitorsList));
    }

    @Test
    public void trueWhenCompetitorsListSizeIsPowerOfTwo(){
        Competitor c1 = new Competitor("Team1");
        Competitor c2 = new Competitor("Team2");
        Competitor c3 = new Competitor("Team3");
        Competitor c4 = new Competitor("Team4");
        competitorsList.add(c1);
        competitorsList.add(c2);
        competitorsList.add(c3);
        competitorsList.add(c4);
        assertTrue(this.competition.isPowerOfTwo(this.competitorsList));
    }
}
