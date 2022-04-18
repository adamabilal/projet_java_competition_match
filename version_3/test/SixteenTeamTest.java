package test;



import java.util.List;

import main.*;

public class SixteenTeamTest extends SelectTeamMethodTest{

    @Override
    protected SelectTeamMethodStrategy createSelectMethod(List<Competitor> competitorList) {
        return new SixteenTeamStrategy();
    }
}
