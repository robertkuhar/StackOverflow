package org.rekdev.so;

import static org.junit.Assert.*;

import java.util.*;
import java.util.regex.*;

import org.junit.*;

/**
 * Develop RegEx to extract integer values from a string.
 * 
 * http://stackoverflow.com/questions/8919786/matcher-find-matches-too-much
 * 
 * @author bobk
 * 
 */
public class JustTheDigits {

    @Test
    public void testJustTheDigits() {
        doTest( "DV_APLCN: 563 ,DV_DHR_APLCN: 5632, PIC_NOTE: 6254", new ArrayList<Integer>( Arrays.asList( 563, 5632, 6254 ) ) );
        doTest( "563 ,DV_DHR_APLCN: 5632, PIC_NOTE", new ArrayList<Integer>( Arrays.asList( 563, 5632 ) ) );
        doTest( "hello 563 jello", new ArrayList<Integer>( Arrays.asList( 563 ) ) );
        doTest( "Hello World", new ArrayList<Integer>() );
    }

    private void doTest( String candidate, List<Integer> expected ) {
        List<Integer> actual = justTheDigits( candidate );
        assertEquals( expected, actual );
    }

    private static Pattern pattern = Pattern.compile( "(\\d+)" );

    public List<Integer> justTheDigits( String input ) {
        List<Integer> listOfDigits = new ArrayList<Integer>();
        Matcher matcher = pattern.matcher( input );
        while ( matcher.find() ) {
            String s = matcher.group( 1 );
            listOfDigits.add( Integer.parseInt( s ) );
        }
        return listOfDigits;
    }
}
