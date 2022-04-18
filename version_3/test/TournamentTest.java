package test;

import java.util.List;

import main.Competition;
import main.Competitor;
import main.Tournament;

public class TournamentTest extends CompetitionTest{
    @Override
    protected Competition createCompetition(List<Competitor> competitorsList) {
        return new Tournament(competitorsList);
    }

}
