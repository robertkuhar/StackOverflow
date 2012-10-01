package org.rekdev.so

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

/**
 * Mapping between JSON formats in Java.
 * 
 * http://stackoverflow.com/questions/12645837/mapping-between-json-formats-in-java
 *
 * @author bobk
 * 
 */
def originals = [
    '{ "name": { "common": "Tiger", "latin": "Panthera tigris" }, "legs": 4 }',
    '{ "name": { "common": "Gecko", "latin": "Gek-onero" }, "legs": 4, "arms": 0 }',
    '{ "name": { "common": "Liger" }, "legs": 4, "wings": 2 }',
    '{ "name": { "common": "Human", "latin": "Homo Sapien" }, "legs": 2, "arms": 2 }'
    ]
originals.each { orig ->
    
    def slurper = new JsonSlurper()
    def parsed = slurper.parseText( orig )

    def builder = new JsonBuilder()
    builder { 
        common_name parsed.name.common
        latin_name parsed.name.latin
        limbs {
            legs parsed.legs ?: 0
            arms parsed.arms ?: 0
        }
    }

    def normalized = builder.toString()
    println "$normalized"
}
