import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Joey Smeets and Ruth Wenzel
 * @version 18.06.2021
 */

class CalcEngineSetTest {
	
	private CalcEngineSet engine;
	Set<String> setA;
	Set<String> setB;
	Set<String> setResult;
	
	@BeforeEach
	void setUp() throws Exception {
    	
    	engine = new CalcEngineSet();
    	setA = new HashSet<>();
    	setB = new HashSet<>(); 
    	setResult = new HashSet<>();
	}
	
	@AfterEach
	void tearDown() {
		setA.clear();
		setB.clear();
	}
	
	//does not work
	//assertEquals(new HashSet<>(Arrays.asList(1,4,6,8)), engine.parseStringToSet(setAString));

	// this test works
	@Test
	void test1() {
		String setAString = "1,5,7,8,9,11"; 
		setA = engine.parseStringToSet(setAString);
		assertEquals("11,1,5,7,8,9", setA.toString().replace("[","").replace("]",""));
	} 
	
	// does not work... 
	void test2() throws EmptySetException {
		String setAString = "1,5,7,8,9,11"; 
		String setBString = "3,5,8,12,13,11"; 
		setA = engine.parseStringToSet(setAString); 
		setB = engine.parseStringToSet(setBString);
		assertEquals("11,1,12,13,3,5,7,8,9", engine.union().toString().replace("[","").replace("]",""));
	}

}
