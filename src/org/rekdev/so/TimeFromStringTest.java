package org.rekdev.so;

import static org.junit.Assert.*;

import java.text.*;
import java.util.*;

import org.junit.*;

public class TimeFromStringTest {

    @Test
    public void simpleTest() {
        try {
            doTest( "10:00", 10, 0 );
            doTest( "10:10", 10, 10 );
            doTest( "23:58", 23, 58 );
            doTest( "1:01", 1, 1 );
            doTest( "24:61", 1, 1 );
        } catch ( ParseException e ) {
            fail( String.format( "unexpected exception %s", e ) );
        }
    }

    private void doTest( String candidate, int expectedHours, int expectedMins ) throws ParseException {
        DateFormat df = new SimpleDateFormat( "HH:mm" );
        Date result = df.parse( candidate );
        Calendar cal = Calendar.getInstance();
        cal.setTime( result );
        assertEquals( expectedHours, cal.get( Calendar.HOUR_OF_DAY ) );
        assertEquals( expectedMins, cal.get( Calendar.MINUTE ) );
    }

}
