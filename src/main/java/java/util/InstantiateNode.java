package java.util;

import java.util.HashMap;
import java.util.Map;
import org.rekdev.so.p1.AClass;

public class InstantiateNode {
  static class Bob {
    Bob(String s) {
    }
  }
  public static void main(String[] args) {
    Map<String,String> m = new HashMap<String,String>();
    // The type HashMap.Node is not visible
    HashMap.Node<String,String> mapNode = new HashMap.Node<String, String>(1, "hey", "you", null);
    Bob b = new Bob("shell");
    
  }
}
