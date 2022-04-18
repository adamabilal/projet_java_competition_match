package competition;


/**
 * @author traorea
 * 
 * 
 * Match interface
 *
 */
public interface Match {
    /**
     * allows to play a match
     * @param competitor1
     * @param competitor2
     * @return a Competitor
     * 
     */
    Competitor playMatch(Competitor competitor1, Competitor competitor2);
}
