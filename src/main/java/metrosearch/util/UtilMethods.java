package metrosearch.util;

/**
 * @author SaiKiran
 * Utility class methods
 */
public class UtilMethods {
	
	/**
	 * @param string
	 * @return true/false
	 * Perform null check
	 */
	public static boolean isNullOrEmpty(String str) {
		if(str != null && !str.isEmpty() && !"null".equalsIgnoreCase(str) && !str.trim().isEmpty())
            return false;
        return true;
    }

}
