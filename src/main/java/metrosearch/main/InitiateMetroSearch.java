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
		String frmStation,destStation,colorLine = null;
		if(args.length==0) {
		Scanner in = new Scanner(System.in);	
		System.out.println("Please enter Start Station");
        frmStation = in.nextLine().toUpperCase();
        System.out.println("Please enter Destination");
        destStation = in.nextLine().toUpperCase();
        System.out.println("Please enter Color of the line (Optional)");
        colorLine = in.nextLine().toUpperCase();
        in.close();
		}
		else {
			frmStation = args[0].toUpperCase();
			destStation = args[1].toUpperCase();
			if(args.length>2)
				colorLine = args[2].toUpperCase();		
		}
        String filepath = InitiateMetroSearch.class.getResource("data.txt").getPath();
		new InitializeSearch(frmStation,destStation,colorLine,filepath);
	}
}
