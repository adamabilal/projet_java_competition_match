package main;

/**
 * @author traorea
 *
 */
public interface Match {
    /**
     * allows to play a match
   
     * @param competitor1
     * @param competitor2
     * @return
     */
    Competitor playMatch(Competitor competitor1, Competitor competitor2);
}