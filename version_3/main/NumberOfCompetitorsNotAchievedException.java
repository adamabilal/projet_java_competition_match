package main;

public class NumberOfCompetitorsNotAchievedException extends Exception{

	
  
	private static final long serialVersionUID = 1L;

	/**
	 *@param msg
     * detect error exception  NumberOfCompetitorsNotAchievedException  when Number Of Competitors Not Achieved
	 */
	public NumberOfCompetitorsNotAchievedException(String msg){
        super(msg);
    }
}
