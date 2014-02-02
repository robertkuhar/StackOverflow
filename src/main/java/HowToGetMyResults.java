public class HowToGetMyResults {
    public static void main( String[] args ) {
        // TODO: Fill in your test cases here
    }

    public static int determineValue( int year, boolean isGoodCondition, boolean isHardback ) {
        int value = 0;
        value += valueForYear( year );
        value += valueForHardback( isHardback );
        value += valueForCondition( isGoodCondition );
        return value;
    }

    public static int valueForYear( int year ) {
        if ( year == 2014 ) {
            return 12;
        } else if ( year == 2013 ) {
            return 8;
        }
        return 4;
    }

    public static int valueForHardback( boolean isHardback ) {
        if ( isHardback ) {
            return 5;
        }
        return 0;
    }

    public static int valueForCondition( boolean isGoodCondition ) {
        if ( isGoodCondition ) {
            return 0;
        }
        return -3;
    }

}
