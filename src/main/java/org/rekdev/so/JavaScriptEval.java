package org.rekdev.so;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * JavaScript convert to int thing.
 * 
 * @see <a href="http://goo.gl/g8bH8t">stackoverflow: Java expressions and
 *      removing everything after DOT with eval</a>
 * 
 */
public class JavaScriptEval {
    public static void main( String[] args ) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName( "js" );
        String[] array = { "-1+3", "10-4" };

        for ( int i = 0; i < array.length; i++ ) {
            try {
                Object results = engine.eval( array[i] );
                // http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
                String resultsAsString = String.format( "%.0f", results );
                // Naked cast can get you in trouble
                int resultsAsint = ( (Number) results ).intValue();
                System.out.println( "results_as_string: " + resultsAsString + ", results_as_int: " + resultsAsint );
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }
    }

}
