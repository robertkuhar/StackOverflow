package org.rekdev.so;

import java.math.*;

public class BigDecimalStuff {
    public static void main( String[] args ) {
        double a = 1.23;
        double b = 2.34;
        double c = 3.45;
        double d = 4.56;

        a = b - c * d;

        System.out.println( String.format( "%f = %f - %f * %f", a, b, c, d ) );
        BigDecimal bdA = new BigDecimal( a );
        BigDecimal bdB = new BigDecimal( b );
        BigDecimal bdC = new BigDecimal( c );
        BigDecimal bdD = new BigDecimal( d );

        bdA = bdB.subtract( bdC.multiply( bdD ) );
        System.out.println( String.format( "%f = %f - %f * %f", bdA, bdB, bdC, bdD ) );
        
        BigDecimal bdAA = new BigDecimal( a );
        System.out.println( String.format( "new BigDecimal( %f ) = %f", a, bdAA ) );
    }

}
