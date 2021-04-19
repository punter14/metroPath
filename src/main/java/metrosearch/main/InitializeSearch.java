package metrosearch.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import metrosearch.model.Line;
import metrosearch.util.ReadConfigData;
import metrosearch.util.UtilMethods;

/**
 * @author SaiKiran
 * Reading config file and performing input validations
 * and then trigger algorithm to find shortest path for input parameters
 */
public class InitializeSearch {
	
	private static List<Line> lines ;
	private List<String> stations = new ArrayList<String>();
	

	public InitializeSearch(String frmStation, String destStation, String colorLine, String filepath) throws IOException {
		new ReadConfigData(filepath,lines, colorLine);
		lines = ReadConfigData.getMetroLines();
        validateInput(frmStation,destStation,colorLine);
        new FindShortestPath(frmStation, destStation, colorLine, lines, stations);
		
	}
	
	private void validateInput(String frmStation, String destStation, String colorLine) {
		
		if(UtilMethods.isNullOrEmpty(frmStation) || UtilMethods.isNullOrEmpty(destStation)) {
			System.out.println("Input recieved for Start or Destination cannot be empty");
			System.exit(0);
		}
		else if(!isStation(frmStation) || !isStation(destStation)){
			System.out.println("Input recieved for Start or Destination does not exist in metro map configuration");
			System.exit(0);
		}
		else if((!isStation(frmStation) || !isStation(destStation) ) && !UtilMethods.isNullOrEmpty(colorLine)){
			System.out.println("Input recieved for Start or Destination does not match with color configuratoin");
			System.exit(0);
		}
		 else if(frmStation.equals(destStation)) {
			System.out.println("Start and Destination stations cannot be same");
			System.exit(0);
		 }
	}

	public static boolean isStation(String s) {
		for(int i=0;i<ReadConfigData.linenum;i++) {
			if(lines.get(i).getStations().contains(s)) {
				return true;
			}
		}
		return false;
	}
}
