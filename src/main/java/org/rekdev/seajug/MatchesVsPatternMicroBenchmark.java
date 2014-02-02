package org.rekdev.seajug;

import java.util.*;
import java.util.regex.*;

public class MatchesVsPatternMicroBenchmark {
    static class TestCase {
        final String npa;
        final String nxx;
        final String line;

        public TestCase( String npa, String nxx, String line ) {
            this.npa = npa;
            this.nxx = nxx;
            this.line = line;
        }

        public String toString() {
            String toString = String.format( "%s( npa: %s, nxx: %s, line: %s )", getClass().getSimpleName(), npa, nxx, line );
            return toString;
        }
    }

    interface Test {
        long execute( TestCase testCase );
    }

    static class StringDotMatches implements Test {

        @Override
        public long execute( TestCase testCase ) {
            long startTime = System.currentTimeMillis();
            if ( testCase.npa.matches( "\\d{3}" ) && testCase.nxx.matches( "\\d{3}" ) && testCase.line.matches( "\\d{4}" ) ) {
                ; // noop
            }
            long endTime = System.currentTimeMillis();
            return endTime - startTime;
        }

    }

    static class MatcherDotMatches implements Test {
        Pattern npaPattern = Pattern.compile( "\\d{3}" );
        Pattern nxxPattern = Pattern.compile( "\\d{3}" );
        Pattern linePattern = Pattern.compile( "\\d{4}" );

        @Override
        public long execute( TestCase testCase ) {
            long startTime = System.currentTimeMillis();
            if ( npaPattern.matcher( testCase.npa ).matches()
                    && nxxPattern.matcher( testCase.nxx ).matches()
                    && linePattern.matcher( testCase.line ).matches() ) {
                ; // noop
            }
            long endTime = System.currentTimeMillis();
            return endTime - startTime;
        }

    }

    public static void main( String[] args ) {
        TestCase[] testCases = {
                new TestCase( "123", "456", "7890" ),
                new TestCase( "123", "456", "abc" ),
                new TestCase( "123", "abc", "7890" ),
                new TestCase( "abc", "456", "7890" ),
                new TestCase( "789", "012", "1234" ) };
        List<String> summaries = new ArrayList<String>();
        summaries.add( execBenchmark( testCases, 100 ) );
        summaries.add( execBenchmark( testCases, 1000 ) );
        summaries.add( execBenchmark( testCases, 10000 ) );
        summaries.add( execBenchmark( testCases, 100000 ) );
        for ( String summary : summaries ) {
            System.out.println( "summary: " + summary );
        }
    }

    private static String execBenchmark( TestCase[] testCases, int iterations ) {
        long totalForMatcherMatches = 0l;
        long totalForStringMatches = 0l;

        Test matcherMatches = new MatcherDotMatches();
        Test stringMatches = new StringDotMatches();

        Random rand = new Random( (long) iterations );
        for ( int i = 0; i < iterations; i++ ) {
            int testCaseIx = Math.abs( rand.nextInt() % testCases.length );
            if ( rand.nextInt() % 2 == 0 ) {
                totalForMatcherMatches += matcherMatches.execute( testCases[testCaseIx] );
                totalForStringMatches += stringMatches.execute( testCases[testCaseIx] );
            } else {
                totalForStringMatches += stringMatches.execute( testCases[testCaseIx] );
                totalForMatcherMatches += matcherMatches.execute( testCases[testCaseIx] );
            }
        }
        
        long absDifference = Math.abs( totalForMatcherMatches - totalForStringMatches );
        double average = ( totalForMatcherMatches + totalForStringMatches ) / 2.0;
        double pctDifference = ( absDifference / average ) * 100.0;
        String winner;
        if ( totalForMatcherMatches < totalForStringMatches ) {
            winner = MatcherDotMatches.class.getSimpleName();
        } else if ( totalForMatcherMatches > totalForStringMatches ) {
            winner = StringDotMatches.class.getSimpleName();
        } else {
            winner = "none";
        }
        String summary = String.format(
                "iterations: %6d, MatcherDotMatches: %3d, StringDotMatches: %3d, %s wins by %3dms or %6.2f%%",
                iterations,
                totalForMatcherMatches,
                totalForStringMatches,
                winner,
                absDifference,
                pctDifference );
        return summary;
    }
}
