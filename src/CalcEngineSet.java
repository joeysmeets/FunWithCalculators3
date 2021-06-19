
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author Joey Smeets and Ruth Wenzel
 * @version 18.06.2021 
 */
public class CalcEngineSet extends CalcEngine {
	
	public Set<String> setA = new HashSet<>();
	public Set<String> setB = new HashSet<>(); 
	public Set<String> setResult = new HashSet<>(); 
	
//	public static void main(String[] args) throws EmptySetException {
//		CalcEngineSet calc = new CalcEngineSet();
//		setA = calc.parseStringToSet("1,5,7,8,9,11");
//		System.out.println(setA.toString());
//		setB = calc.parseStringToSet("3,5,8,12,13,11");
//		System.out.println(setB.toString()); 
//		System.out.println("union" + calc.union());
//		System.out.println("intersection" + calc.intersection());
//		System.out.println("subtraction" + calc.subtraction());
//		System.out.println("Size A: " + calc.sizeOfSet(setA));
//	}
	
	// Constructor
	public CalcEngineSet() {
		super();
	}
	
	/**
	 * setter
	 * @param A set 
	 */
	public void setSetA(Set<String> setA) {
		this.setA = setA;
	} 
	
	/**
	 * setter
	 * @param A set
	 */
	public void setSetB(Set<String> setB) {
		this.setB = setB;
	}
	
	/**
	 * setter
	 * @param A set
	 */
	public void setResult(Set<String> setResult) {
		this.setResult = setResult;
	}
	
	/**
	 * getter
	 * @return setA
	 */
	public Set<String> getSetA() {
        return setA;
    }
	
	/**
	 * getter
	 * @return setB
	 */
	public Set<String> getSetB() {
        return setB;
    }
	
	
	/**
	 * getter
	 * @return setResult
	 */
	public Set<String> getSetResult() {
        return setResult;
    }
	
	/**
	 * Converts a String into elements by dividing them at commas.
	 * @param String 
	 */
	public Set<String> parseStringToSet(String input){
		String[] inputArray = input.split(Pattern.quote(","));
		Set<String> inputSet = new HashSet<>();
		
		for (String element : inputArray) {
			inputSet.add(element);
		}
		
		return inputSet;
	}
	
//	/**
//	 * Returns the elements inside of a set.
//	 * @param a Set
//	 * @return the amount of elements in a set as a String.
//	 */
//	public String sizeOfSet(Set<String> input) throws EmptySetException {
//		setResult = null;
//		if (input != null) {
//			return String.valueOf(input.size());
//		} else {
//			throw new EmptySetException("This set is empty.");
//		}
//	}
	
	/**
	 * Returns the size of set A.
	 * @throws EmptySetException 
	 */
	 public void GetSizeSetA() throws EmptySetException {
		 setResult.clear();
		 
		 if(setA != null) {
		    setResult.clear();
		    setResult.add(String.valueOf(setA.size()));
		 } else throw new EmptySetException("Set A is empty."); 
	 }
	 
	 /**
	  * Returns the size of set B.
	  * @throws EmptySetException 
	  */
	 public void GetSizeSetB() throws EmptySetException {
		 setResult.clear();
		 
		 if(setA != null) {
		    setResult.clear();
		    setResult.add(String.valueOf(setB.size()));
		 } else throw new EmptySetException("Set B is empty."); 
	 }
	
	/**
	 * Clears set A.
	 * @throws EmptySetException 
	 */
	public void clearA() throws EmptySetException {
		setResult.clear();
		
		if (setA != null) {
			setA.clear();
		} else {
			throw new EmptySetException("Set A is empty.");
		}
	}
	
	/**
	 * Clears set B.
	 * @throws EmptySetException 
	 */
	public void clearB() throws EmptySetException {
		setResult.clear();
		
		if (setB != null) {
			setB.clear();
		} else {
			throw new EmptySetException("Set B is empty."); 
		}
	}
	
	/**
	 * Clears all text fields in the interface.
	 * @throws EmptySetException 
	 */
	public void clearAll() throws EmptySetException {
		clearA();
		clearB();
		if (setResult != null) {
			setResult.clear();
		}
		else {
			throw new EmptySetException("All sets are empty, nothing to be emptied.");
		}
	}

	/**
	 * Combines the elements of two Sets in the result set.
	 * @return setResult
	 * @throws EmptySetException 
	 */
	public Set<String> union() throws EmptySetException {
		setResult.clear();
		
		if (setA != null) {
			setResult.addAll(setA);
		}
		if (setB != null) {
			setResult.addAll(setB);
		}
		else {
			throw new EmptySetException("All or one of the sets is still empty, nothing to unite.");
		}
		
		return setResult; 
	}


	/**
	 * Takes away the matching elements from set B off set A.
	 * @return setResult
	 * @throws EmptySetException 
	 */
	public Set<String> subtraction() throws EmptySetException {
		setResult.clear();
		
		if (setA != null) {
			setResult.addAll(setA);
		} else throw new EmptySetException("SetA is still empty. Both sets need to be filled.");
		
		if (setB != null) {
			for (String element : setB) {
				setResult.remove(element);
			}
		} else throw new EmptySetException("SetB is still empty. Both sets need to be filled");
		
		return setResult;
	}
	
	/**
	 * Checks for the matching values and puts them in the return set. 
	 * @return setResult
	 * @throws EmptySetException 
	 */
	public Set<String> intersection() throws EmptySetException {
		setResult.clear();
		
		if (setA != null) {
			for (String element : setA){
				if(setB != null) {
					if (setB.contains(element)) {
						setResult.add(element);
					}
				} else throw new EmptySetException("SetB is still empty. Both sets need to be filled");
			}
		} else throw new EmptySetException("SetA is still empty. Both sets need to be filled.");
		
		return setResult;
	}	
}