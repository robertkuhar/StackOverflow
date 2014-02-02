import java.util.*;


public class SortStrings {
    public static final void main( String[] args ) {
        String s = "zero apple watchdog hammer";
        String[] splits = s.split( " " );
        Arrays.sort( splits );
        System.out.println( String.format( "splits: %s", Arrays.toString( splits ) ) );
    }

}
