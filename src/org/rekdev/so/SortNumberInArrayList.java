package org.rekdev.so;

import java.util.*;

/**
 * Alternative implementation for http://stackoverflow.com/questions/8690832
 * 
 * @author robertkuhar
 *
 */
public class SortNumberInArrayList {
    public static void main( String[] args ) {
        Map<Integer , String> map = new TreeMap<Integer , String>();
        map.put( 1, "name1" );
        map.put( 1000, "name2" );
        map.put( 1004, "name4" );
        map.put( 1002, "name3" );
        map.put( 10000, "name5" );
        map.put( 2000, "name5" );
        
        for ( Integer key : map.keySet() ) {
            System.out.println( String.format( "key: %d, value: %s", key, map.get( key ) ) );
        }
    }
}
