import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Joey Smeets and Ruth Wenzel
 * @version 
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

	@Test
	void test1() {
		String setAString = "1,4,6,8"; 
		setA = engine.parseStringToSet(setAString);
		assertEquals("1, 4, 6, 8", setA.toString().replace("[","").replace("]",""));
	} 
	
	void test2() throws EmptySetException {
		String setAString = "1,4,6,8"; 
		String setBString = "1,7,9,12"; 
		setA = engine.parseStringToSet(setAString);
		setB = engine.parseStringToSet(setBString);
		assertEquals("1, 12, 4, 6, 7, 8, 9", engine.union().toString().replace("[","").replace("]",""));
	}

}
