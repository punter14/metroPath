package metrosearch.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import metrosearch.model.Line;

public class ReadConfigData {
	/**
	 * To line no. while reading input file
	 */
	public static int linenum = 0;
	/**
	 * List of metro lines from input file
	 */
	public static List<Line> metroLines;

	/**
	 * @param pathname
	 * @param lines
	 * @param colorLine
	 * @throws IOException
	 */
	public ReadConfigData(String pathname, List<Line> lines, String colorLine) throws IOException{
		
		lines = new ArrayList<>(); 
		//Reading input file data.txt where lines and stations are defined
		File file = new File(pathname);
		InputStreamReader rdr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(rdr);
		try {
			String content=null;
			String upper_station_name;
			while((content=br.readLine())!=null) {
				linenum++;
				Line newline = new Line();
				List<String> line = new ArrayList<String>();
				String[] station_single = content.split("\\|");
				String linename = station_single[0];//Line name, first position
				for(int i=1;i<station_single.length;i++) {//Adding all stations in a particular line
					if(i==station_single.length-1 && station_single[i].equals(station_single[1]))
						continue;
					String[] station_and_color = station_single[i].split("_");
					
					if(UtilMethods.isNullOrEmpty(colorLine) || !station_single[i].contains("_")) {
						if(!UtilMethods.isNullOrEmpty(station_and_color[0])) {
						upper_station_name = station_and_color[0].toUpperCase();
						line.add(upper_station_name);
						}
					}
					
					else if(colorLine.equalsIgnoreCase(station_and_color[1])){
						if(!UtilMethods.isNullOrEmpty(station_and_color[0])) {
							upper_station_name = station_and_color[0].toUpperCase();
							line.add(upper_station_name);
							}
					}
				}
				newline.setName(linename);
				newline.setStations(line);
				lines.add(newline);
			}
			metroLines = lines;
			br.close();
		} catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br == null)
                try {
                	br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
	}
	
	public static void setMetroLines(List<Line> metroLines) {
		ReadConfigData.metroLines = metroLines;
	}
	
	public static List<Line> getMetroLines() {
		return metroLines;
	}
	
	public static void setLinenum(int linenum) {
		ReadConfigData.linenum = linenum;
	}

	
}