package JUnitPackage;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import metrosearch.main.FindShortestPath;
import metrosearch.main.InitializeSearch;
import metrosearch.main.InitiateMetroSearch;
import metrosearch.util.ReadConfigData;

public class JUnitTest3 {

	@Before
	public void setUp() throws Exception {
		ReadConfigData.setMetroLines(null);
		ReadConfigData.setLinenum(0);
		FindShortestPath.setResultPath("");
		InitializeSearch.setLines(null);
	}

	@Test
	public void test_config_file_Color_Data_Green() {
		InputStream inputStream = InitiateMetroSearch.class.getResourceAsStream("test_input.txt");
		try {
			new InitializeSearch("A","F","Green",inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Executing third test of shortest path between A and F with line color Green");
		assertTrue(FindShortestPath.resultPath.equals("A->B->C->G->I->F") || FindShortestPath.resultPath.equals("A->B->C->D->E->F"));
	}

}
