
import java.util.HashSet;

public class CalcEngineSet<E> extends CalcEngine implements Set<E>{
	
	Set<E> setA = new HashSet<>();
	Set<E> setB = new HashSet<>();
	Set<E> setResult = new HashSet<>();

	public CalcEngineSet() {
		super();
	}
	
	private Set<String> parseStringToSet(String input){
		
	}
	
	public void setSet (String input, String setName) throws IllegalArgumentException{
		
	}
	
	public int sizeOfSet(String setName) {
		
	}
	
	public void clear() {
		
	}

	@Override
	public Set<E> union(Set<E> setB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<E> intersection(Set<E> setB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<E> subtraction(Set<E> setB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<E> power(Set<E> setB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(E element) {
		// TODO Auto-generated method stub
		
	}
	
	
}
