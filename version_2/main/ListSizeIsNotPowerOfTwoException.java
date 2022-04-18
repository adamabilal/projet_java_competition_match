package main;


/**
 * @author traorea
 *
 */
@SuppressWarnings("serial")
public class ListSizeIsNotPowerOfTwoException extends Exception{
   

	/**
	 * Constructor for ListSizeIsNotPowerOfTwoException
	 * @param msg
	 */
	public ListSizeIsNotPowerOfTwoException(String msg){
        super(msg);
    }
}