package main;

import java.util.List;

/**
 * @author traorea sharfeldin
 *
 */

/*
 * interface CompetitionObserver
 * @param Competitor c1
 * @param Competitor c2
 * @param Competitor winner
 */
public interface CompetitionObserver {
    void watchMatch(Competitor c1, Competitor c2, Competitor winner);

	void watchPoule(List<Competitor> competitorList);
	void watchCote(List<Competitor> competitorList);
	void watchTeam(List<Competitor> competitorList);

}
