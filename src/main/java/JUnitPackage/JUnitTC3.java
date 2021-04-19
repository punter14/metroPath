package JUnitPackage;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import metrosearch.main.FindShortestPath;
import metrosearch.main.InitializeSearch;
import metrosearch.main.InitiateMetroSearch;
import metrosearch.util.ReadConfigData;

public class JUnitTC3 {

	@Before
	public void setUp() throws Exception {
		ReadConfigData.setMetroLines(null);
		ReadConfigData.setLinenum(0);
	}

	@Test
	public void test_config_file_Color_Data_Green() {
		String filepath = InitiateMetroSearch.class.getResource("test_input.txt").getPath();
		try {
			new InitializeSearch("A","F","Green",filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(FindShortestPath.resultPath.equals("A->B->C->G->I->F") || FindShortestPath.resultPath.equals("A->B->C->D->E->F"));
	}

}
