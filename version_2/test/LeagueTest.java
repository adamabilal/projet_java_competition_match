package test;

import java.util.List;

import main.*;


/**
 * @author traorea
 *
 */
public class LeagueTest extends CompetitionTest{

    @Override
    protected Competition createCompetition(List<Competitor>competitors) {
        return new League(competitors);
    }
}