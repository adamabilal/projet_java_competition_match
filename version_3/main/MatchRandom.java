package main;

import java.util.Random;


public class MatchRandom implements Match{
    /**
     * Constructor for MatchRandom
     */
    public MatchRandom(){}

    
    /**
     *@param competitor1
     *@param competitor2
     *return Competitor winner
     */
    public Competitor playMatch(Competitor competitor1, Competitor competitor2) {
        Competitor winner;
        int random = new Random().nextInt(2);
        if(random > 0){
            competitor1.setCote();
            winner = competitor1;
        }
        else {
            competitor2.setCote();
            winner = competitor2;
        }
        return winner;
    }
}