package org.rekdev.so.tsob

/**
 * http://stackoverflow.com/questions/8719482/force-tostring-implementation-in-subclasses
 * 
 * @author bobk
 *
 */
abstract class SuperClass {
    protected abstract String doToString()
    
    public final String toString() {
        return doToString()
    }
}

class FirstImpl extends SuperClass {
    @Override
    protected String doToString() {
        return "${getClass().name}()"
    }
}

class SecondImpl extends SuperClass {
    @Override
    protected String doToString() {
        return "${getClass().name}"
    }
}

fi = new FirstImpl()
si = new SecondImpl()

println "fi is $fi"
println "si is $si"
