package JUnitPackage;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import metrosearch.main.FindShortestPath;
import metrosearch.main.InitializeSearch;
import metrosearch.main.InitiateMetroSearch;
import metrosearch.util.ReadConfigData;

public class JUnitTest2 {

	@Before
	public void setUp() throws Exception {
		ReadConfigData.setMetroLines(null);
		ReadConfigData.setLinenum(0);
		FindShortestPath.setResultPath("");
		InitializeSearch.setLines(null);
	}

	@Test
	public void test_config_file_Color_Data_Red() {
		String filepath = InitiateMetroSearch.class.getResource("test_input.txt").getPath();
		try {
			new InitializeSearch("A","F","Red",filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(FindShortestPath.resultPath, "A->B->C->H->F");
	}

}
