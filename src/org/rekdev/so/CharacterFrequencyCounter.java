package org.rekdev.so;

import java.util.*;

public class CharacterFrequencyCounter {
    public static void main( String[] args ) {
        String str = "loool";

        Map<Character,Integer> charFreq = new HashMap<Character,Integer>();
        for ( char c : str.toCharArray() ) {
            Character cc = new Character( c );
            Integer i = charFreq.get( cc );
            if ( i == null ) {
                i = new Integer( 1 );
            } else {
                i = new Integer( i.intValue() + 1 );
            }
            charFreq.put( cc, i );
        }
        System.out.println( String.format( "charFreq: %s", charFreq ) );
    }

}
