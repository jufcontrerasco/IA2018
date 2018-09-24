package unalcol.math.function;

import java.lang.reflect.ParameterizedType;
import java.util.Iterator;

import unalcol.tracer.Traceable;
import unalcol.types.collection.Collection;
import unalcol.types.collection.GrowCollection;
import unalcol.types.object.tagged.Tagged;
import unalcol.types.object.tagged.TaggedManager;

/**
 * <p>Abstract definition of a function</p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * @author Jonatan Gomez Perdomo
 * @version 1.0
 * @param <S> Codomain of the function
 * @param <T> Domain of the function
 */
public interface Function<S, T> extends Traceable, TaggedManager<S>{
	/**
	 * Determines if the fitness function is deterministic or not, i.e.,
	 * if the value of the function for a given value can change in time (non-stationary) 
	 * or not (stationary)
	 * @return <i>true</i> if the fitness function does not changes with time, <i>false</i> otherwise
	 */
	default boolean deterministic(){ return true; }

	/**
	 * Computes the function
	 * @param x Parameter of the function
	 * @return Computed value of the function
	 */
	public T apply(S x);	    
 
	default T[] set_apply( S[] x ){
		@SuppressWarnings("unchecked")
		T[] r = (T[])new Object[x.length];
		for( int i=0; i<x.length; i++) r[i] = apply(x[i]);
		return r;
	}
	
	/**
	 * Computes the function for a given collection of objects
	 * @param Objects to be computed
	 * @return Values of the function, associated to the given collection of objects
	 */	
	default Collection<T> set_apply( Collection<?> set ){
		ParameterizedType parameterizedType = (ParameterizedType)set.getClass().getGenericSuperclass();
    	Class<?> cl = (Class<?>)parameterizedType.getActualTypeArguments()[0];	
    	if( Tagged.class.isAssignableFrom(cl) ){
    		return new Collection<T>() {
				@Override
				public Iterator<T> iterator() {
					@SuppressWarnings("unchecked")
					Iterator<Tagged<S>> iter = (Iterator<Tagged<S>>)set.iterator(); 
					return new Iterator<T>(){
						@Override
						public boolean hasNext(){ return iter.hasNext(); }

						@Override
						public T next() { return apply(iter.next()); }
					};
				}

				@Override
				public boolean isEmpty(){ return set.isEmpty(); }
			};
    	}else{
    		return new Collection<T>() {
				@Override
				public Iterator<T> iterator() {
					@SuppressWarnings("unchecked")
					Iterator<S> iter = (Iterator<S>)set.iterator(); 
					return new Iterator<T>(){
						@Override
						public boolean hasNext(){ return iter.hasNext(); }

						@Override
						public T next() { return apply(iter.next()); }
					};
				}

				@Override
				public boolean isEmpty(){ return set.isEmpty(); }
			};
    	}
	}

	/**
	 * Gets the function values for a given collection of objects
	 * @param Objects to be evaluated
	 * @return Function values associated to the given collection of objects
	 */
	@SuppressWarnings("unchecked")
	default void set_apply( Collection<?> set, GrowCollection<T> target ){
		ParameterizedType parameterizedType = (ParameterizedType)set.getClass().getGenericSuperclass();
    	Class<?> cl = (Class<?>)parameterizedType.getActualTypeArguments()[0];	
    	if( Tagged.class.isAssignableFrom(cl) )	for( Object x : set ) target.add(apply((Tagged<S>)x)); 
    	else for( Object x : set ) target.add(apply((S)x));
	}

	// Tagged methods
	
	/**
	 * Computes the function
	 * @param x Parameter of the function
	 * @return Computed value of the function
	 */
	@SuppressWarnings("unchecked")
	default T apply(Tagged<S> x){
		S xo = x.unwrap();
		if( deterministic() ){
			T y = (T)x.getTag(this);
			if( y!=null ) return y;
			y = apply(xo);
			x.setTag(this, y);
			return y;
		}else return apply(xo);
	}

	default T[] set_apply( Tagged<S>[] x ){
		@SuppressWarnings("unchecked")
		T[] r = (T[])new Object[x.length];
		for( int i=0; i<x.length; i++) r[i] = apply(x[i]);
		return r;
	}
}