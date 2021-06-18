import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

	@Test
	void test1() {
		String setAString = "1,4,6,8"; 
//		assertEquals(new HashSet<>(Arrays.asList(1,4,6,8)), engine.parseStringToSet(setAString));
		setA = engine.parseStringToSet(setAString);
		assertEquals("1, 4, 6, 8", setA.toString().replace("[","").replace("]",""));
	} 
	
	void test2() {
		
	}

}
