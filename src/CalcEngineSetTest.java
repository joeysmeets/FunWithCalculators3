import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		String setAString = "1, 4, 6, 8";
		assertEquals(1, 4, 6, 8, engine.parseStringToSet(setAString));
	}

}
