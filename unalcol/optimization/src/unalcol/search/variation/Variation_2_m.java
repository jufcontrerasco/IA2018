package unalcol.search.variation;

import unalcol.types.object.tagged.Tagged;

/**
 * <p>Title:ArityTwo</p>
 * <p>Description: A binary operator </p>
 * <p>Copyright:    Copyright (c) 2010</p>
 * @author Jonatan Gomez
 * @version 1.0
 */

public interface Variation_2_m<T> extends Variation<T> {
	@SuppressWarnings("unchecked")
	public default Tagged<T>[] apply( Tagged<T> one, Tagged<T> two ){
    		T[] next = apply( one.unwrap(), two.unwrap() );    	
    		Tagged<T>[] s = new Tagged[next.length];
    		for( int i=0; i<s.length; i++ ){
    			s[i] = wrap(next[i]);
    		}	
    		return s;
	}   

	@SuppressWarnings("unchecked")
	public default T[] apply( T one, T two ){
    		Tagged<T>[] next = apply( wrap(one), wrap(two) );    	
    		T[] s = (T[])new Object[next.length];
    		for( int i=0; i<s.length; i++ ){
    			s[i] = next[i].unwrap();
    		}	
    		return s;
	}   

	/**
	 * Return the genetic operator arity
	 * @return the genetic operator arity
	 */
	@Override
	public default int arity() { return 2; }
}