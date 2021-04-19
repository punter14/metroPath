package metrosearch.main;

import java.util.ArrayList;
import java.util.List;

import metrosearch.model.Line;
import metrosearch.model.Map;
import metrosearch.model.Result;
import metrosearch.util.ReadConfigData;

/**
 * @author SaiKiran
 * Finding the shortest route for input parameters and 
 * prinitng the output along with transfer station, if any involved.
 */
public class FindShortestPath {
	
	private List<Line> lines2 = new ArrayList<>();
    private Result result;
    private Map map;
    private List<String> list1 = new ArrayList<>(); 
    private List<List<String>> lists = new ArrayList<>(); 
    private List<Integer> passStation = new ArrayList<>(); 
    public static String resultPath="";


	public FindShortestPath(String frmStation, String destStation, String lineColor, List<Line> lines, List<String> stations)  {
		lines2.addAll(lines);
		
		for(int i=0;i<ReadConfigData.linenum;i++) {
            stations.addAll(lines.get(i).getStations());
        }
        map = new Map(stations);
        
        
        for(int i=0;i<lines.size();i++) {
            for(int j=0;j<lines.get(i).getStations().size()-1;j++) {
                map.initDis(lines.get(i).getStations().get(j), lines.get(i).getStations().get(j+1));
            }
        }
        
        
        result = new Result(map.getSubwayline());
        
        findShortPath( frmStation,  destStation,  lineColor);
	}
	
	private void findShortPath(String frmStation, String destStation, String colorLine) {
		int i = map.getIndex(frmStation);
		int j = map.getIndex(destStation);
		int shortest = result.getMinDis(i,j);
		if(shortest == 999999) {
			System.out.println("Destination cannot be reached from starting station");
			System.exit(0);
		}
		shortest++;
		String path = "Below is the shortest path \n";
		
		passStation = result.indexToList(i,j);
		
		for(int k=0;k<passStation.size();k++) {
			List<String> list = new ArrayList<>();
			path+=(map.getName(passStation.get(k)));
			resultPath+=(map.getName(passStation.get(k)));
			for(Line l:lines2) {
				int flag=0;
				for(String name:l.getStations()) {
					
					if(map.getName(passStation.get(k)).equalsIgnoreCase(name)){
						
						list.add(l.getName());
						if(!list1.contains(name)) {
							list1.add(name);
							flag=1;
						}
						
					}
				}
				if(flag==1) lists.add(list);
			}
			if(k<passStation.size()-1) {
				path+="->";
				resultPath+="->";
			}
		}
		
		path+="\n";
		
		
		List<String> transfer = new ArrayList<>();
		
		for(int p=2;p<lists.size();p++) {
			int flag=0;
			for(int q=0;q<lists.get(p).size();q++) {
				for(int w=0;w<lists.get(p-2).size();w++)
					if(lists.get(p-2).get(w).equalsIgnoreCase(lists.get(p).get(q))) {
						flag=1;break;
					}
			}
			if(flag==0) {
				if(!transfer.contains(list1.get(p-1))); transfer.add(list1.get(p-1));
			}
		}
		
		path+="\n";
		
		path+="Need to change metro lines "+transfer.size()+" times ";
		for(int a=0;a<transfer.size();a++) {
			path+=(transfer.get(a)+" ");
		}
		path+="\n";
		System.out.println(path);

	}
	

}
