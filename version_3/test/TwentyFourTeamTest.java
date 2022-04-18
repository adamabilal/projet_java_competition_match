package test;


import java.util.List;

import main.*;

public class TwentyFourTeamTest extends SelectTeamMethodTest{

    @Override
    protected SelectTeamMethodStrategy createSelectMethod(List<Competitor> competitorList) {
        return new TwentyFourTeamStrategy();
    }
}
