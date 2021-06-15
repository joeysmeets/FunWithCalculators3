

public interface Set<E> {
	
//	abstract Set<E> of (Collection<? extends E> coll);
	
	abstract Set<E> union(Set<E> setB);
	
	abstract Set<E> intersection(Set<E> setB);
	
	abstract Set<E> subtraction(Set<E> setB);
	
	abstract Set<E> power(Set<E> setB);
	
//	abstract void add(Collection<? extends E> coll);
	abstract void add(E element);
	
//	abstract void remove(Collection<? extends E> coll);
	abstract void remove(E element);
}
