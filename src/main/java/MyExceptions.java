import java.util.*;

public class MyExceptions {
    public static class ArrayOutOfBoundsException extends Exception {
        private static final long serialVersionUID = 1L;
    }

    public static int min( int[] array ) throws ArrayIndexOutOfBoundsException {
        if ( array == null || array.length == 0 ) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Arrays.sort( array );
        int minValue = array[0];
        return minValue;
    }

    public static void main( String[] args ) throws ArrayOutOfBoundsException {
        int result = 0;
        int[] array = { 16, 14, 15, 12, 102, 88, 64, 1, -3 };

        try {
            result = MyExceptions.min( array );
            System.out.print( result );
        } catch ( ArrayIndexOutOfBoundsException noElements ) {
            System.out.print( "There are no elements in this array: " + noElements.getMessage() );
        }
    }

}
