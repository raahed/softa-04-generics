package ohm.softa.a04;

import java.util.function.Function;

public interface SimpleList<T> extends Iterable<T> {
	/**
	 * Add a given object to the back of the list.
	 */
	void add(T o);

	/**
	 * @return current size of the list
	 */
	int size();

	/**
	 * Generate a new list using the given filter instance.
	 * @return a new, filtered list
	 */
	default SimpleList<T> filter(SimpleFilter<T> filter){
		SimpleList<T> result = new SimpleListImpl<T>();
		for(T o : this){
			if(filter.include(o)){
				result.add(o);
			}
		}
		return result;
	}

	/**
	 * Convert the given list into a new one by
	 * @return a new, transformed list
	 */
	default <R> SimpleList<R> map(Function<T, R> transform) {
		SimpleList<R> list = new SimpleListImpl<R>();
		for(T o : this) {
			list.add(transform.apply(o));
		}
		return list;
	}

	/**
	 * Add a default value to the list
	 */
	default void addDefault(T o) {
		this.add(o);
	}
}
