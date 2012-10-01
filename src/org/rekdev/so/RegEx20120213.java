package org.rekdev.so;

import java.util.regex.*;

import junit.framework.*;

/**
 * Answer to Stack Overflow question
 * http://stackoverflow.com/questions/9272236/regex
 * -expression-for-finding-two-words-in-a-string
 * "Regex for finding two words in a string"
 * 
 * @author robertkuhar
 * 
 */
public class RegEx20120213 extends TestCase {

    static class TestData {
        final String data;
        final String expected;

        TestData( String data, String expected ) {
            this.data = data;
            this.expected = expected;
        }
    }

    public void testIsolateJohnDoe() throws Exception {
        TestData[] candidates =
                {
                        new TestData( "John\tDoe\t123", "John Doe" ),
                        new TestData( "John Doe 123", "John Doe" ),
                        new TestData( "John\t\tDoe\t\t123", "John Doe" ),
                        new TestData( "John \tDoe \t123", "John Doe" ),
                        new TestData( "Mary Jane Smokes", "" ) };

        for ( TestData candidate : candidates ) {
            String actual = isolateAndTrim( candidate.data );
            assertEquals( candidate.expected, actual );
        }
    }

    public String isolateAndTrim( String candidate ) {
        // This pattern isolates "John Doe" as a group...
        Pattern pattern = Pattern.compile( "(\\w+\\s+\\w+)\\s+\\d*" );
        Matcher matcher = pattern.matcher( candidate );
        String clean = "";
        if ( matcher.matches() ) {
            clean = matcher.group( 1 );
            // This replace all reduces away extraneous whitespace...
            clean = clean.replaceAll( "\\s+", " " );
        }
        return clean;
    }
}
