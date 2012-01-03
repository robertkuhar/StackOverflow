class Person {
    private String name
    private String location
    private String id
    
    String toString() {
        "Person( name: $name, location: $location, id: $id )"
    }

}

def bob = new Person()
bob.name = "bob";
bob.location = "seattle"

def robert = new Person( name: "robert", location: "seattle" )

println "bob is $bob, robert is $robert"