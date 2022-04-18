package main;


/**
 * @author traorea_sharfeldin
 *
 *
 */
public class EmptyCompetitorListException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    /**
     * @param msg
     * detect error exception  EmptyCompetitorListException  when it's empty
      */
    public EmptyCompetitorListException(String msg){
        super(msg);
    }
}
