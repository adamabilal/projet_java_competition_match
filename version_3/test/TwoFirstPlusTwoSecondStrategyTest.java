package test;


import java.util.List;

import main.Competitor;
import main.SelectTeamMethodStrategy;
import main.TwoFirstPlusTwoSecondStrategy;

public class TwoFirstPlusTwoSecondStrategyTest extends SelectTeamMethodTest {

    @Override
    protected SelectTeamMethodStrategy createSelectMethod(List<Competitor> competitorList) {
        return new TwoFirstPlusTwoSecondStrategy();
    }
}
