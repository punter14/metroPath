package metrosearch.main;


import java.io.IOException;
import java.util.Scanner;

/**
 * @author SaiKiran
 * Main class to accept the input search parameters and initiate the search against
 * config file data.txt where the metro configuration is loaded
 */
public class InitiateMetroSearch{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException  {
		Scanner in = new Scanner(System.in);	
		System.out.println("Please enter Start Station");
        String frmStation = in.nextLine().toUpperCase();
        System.out.println("Please enter Destination");
        String destStation = in.nextLine().toUpperCase();
        System.out.println("Please enter Color of the line (Optional)");
        String colorLine = in.nextLine().toUpperCase();
        in.close();
        String filepath = InitiateMetroSearch.class.getResource("data.txt").getPath();
		new InitializeSearch(frmStation,destStation,colorLine,filepath);
	}
}
