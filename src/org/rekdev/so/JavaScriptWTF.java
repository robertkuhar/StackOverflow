package org.rekdev.so;

import java.util.*;

import javax.script.*;

public class JavaScriptWTF {
    public static void main( String[] args ) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        List<ScriptEngineFactory> factories = mgr.getEngineFactories();
        for ( ScriptEngineFactory factory : factories ) {
            System.out.println( String.format(
                    "engineName: %s, THREADING: %s",
                    factory.getEngineName(),
                    factory.getParameter( "THREADING" ) ) );
        }
    }
}
