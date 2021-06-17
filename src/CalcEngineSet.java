
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/*
 * @author joeysmeets, ruthwenzel
 */
public class CalcEngineSet extends CalcEngine {
	
	Set<String> setA = new HashSet<>();
	Set<String> setB = new HashSet<>();
	Set<String> setResult = new HashSet<>();
	
	public CalcEngineSet() {
		super();
	}
	
	/*
	 * setter
	 * @param A set 
	 */
	public void setSetA(Set<String> setA) {
		this.setA = setA;
	}
	
	/*
	 * setter
	 * @param A set
	 */
	public void setSetB(Set<String> setB) {
		this.setB = setB;
	}
	
	/*
	 * setter
	 * @param A set
	 */
	public void setResult(Set<String> setResult) {
		this.setResult = setResult;
	}
	
	/*
	 * getter
	 * @return setA
	 */
	public Set<String> getSetA() {
        return setA;
    }
	
	/*
	 * getter
	 * @return setB
	 */
	public Set<String> getSetB() {
        return setB;
    }
	
	
	/*
	 * getter
	 * @return setResult
	 */
	public Set<String> getSetResult() {
        return setResult;
    }
	
	/*
	 * 
	 */
	public Set<String> parseStringToSet(String input){
		String[] inputArray = input.split(Pattern.quote(","));
		Set<String> inputSet = new HashSet<>();
		
		for (String element : inputArray) {
			inputSet.add(element);
		}
		
		return inputSet;
	}
	
	/*
	 * 
	 */
	public String sizeOfSet(Set<String> input) throws EmptySetException {
		setResult = null;
		if (input != null) {
			return String.valueOf(input.size());
		} else {
			throw new EmptySetException("This set is empty.");
		}
	}
	
	/*
	 * 
	 */
	public void clearA() throws EmptySetException {
		if (setA != null) {
			setA.clear();
		} else {
			throw new EmptySetException("All sets are empty, nothing to be emptied.");
		}
	}
	
	/*
	 * 
	 */
	public void clearB() throws EmptySetException {
		if (setB != null) {
			setB.clear();
		} else {
			throw new EmptySetException("All sets are empty, nothing to be emptied.");
		}
	}
	
	/*
	 * 
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

	/*
	 * 
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


	/*
	 * 
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
	
	/*
	 * 
	 */
	public Set<String> intersection() throws EmptySetException {
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

//	/*
//	 * 
//	 */
//	public Set<E> power(Set<E> setB) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
}
