package test;

import main.*;


import java.util.List;


/**
 * @author traorea
 *
 */
public class SixteenTeamTest extends SelectTeamMethodTest{

    @Override
    protected SelectTeamMethodStrategy createSelectMethod(List<Competitor> competitorList) {
        return new SixteenTeamStrategy();
    }
}
