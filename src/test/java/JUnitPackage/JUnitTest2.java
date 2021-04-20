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
		InputStream inputStream = InitiateMetroSearch.class.getResourceAsStream("test_input.txt");
		System.out.println("Executing second test of shortest path between A and F with line color Red");
		try {
			new InitializeSearch("A","F","Red",inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(FindShortestPath.resultPath, "A->B->C->H->F");
	}

}
