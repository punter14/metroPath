/**
 * 
 */
package JUnitPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import metrosearch.main.FindShortestPath;
import metrosearch.main.InitializeSearch;
import metrosearch.main.InitiateMetroSearch;
import metrosearch.util.ReadConfigData;

/**
 * @author SaiKiran
 * TC for checking if config file for metro configuration exists or not
 *
 */
public class JUnitTest1 {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ReadConfigData.setMetroLines(null);
		ReadConfigData.setLinenum(0);
		FindShortestPath.setResultPath("");
		InitializeSearch.setLines(null);
	}

	@Test
	public void test_configuration_file_exists() {
		String filepath = InitiateMetroSearch.class.getResource("data.txt").getPath();
		File file = new File(filepath);
		assertTrue(file.exists());
	}
	/**
	 * Reading default metro config file and performing search
	 */
	@Test
	public void test_config_file_Data() {
		String filepath = InitiateMetroSearch.class.getResource("test_input.txt").getPath();
		try {
			new InitializeSearch("A","F","",filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(FindShortestPath.resultPath, "A->B->C->D->E->F");
	}
	

}
