package main;

public class ListSizeIsNotPowerOfTwoException extends Exception{
    /**
     * @author traorea_sharfeldin
     * 
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

    /**
     * @param msg
     * detect error exception  ListSizeIsNotPowerOfTwoException  when is not power of two
      */
	public ListSizeIsNotPowerOfTwoException(String msg){
        super(msg);
    }
}
