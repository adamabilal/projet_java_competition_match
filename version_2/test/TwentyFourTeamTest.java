package test;

 
import main.*;

import java.util.List;

/**
 * @author traorea
 *
 */
public class TwentyFourTeamTest extends SelectTeamMethodTest{

    @Override
    protected SelectTeamMethodStrategy createSelectMethod(List<Competitor> competitorList) {
        return new TwentyFourTeamStrategy();
    }
}
