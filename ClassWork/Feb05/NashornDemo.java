import java.io.FileReader;

import javax.script.*;
import java.util.*;
// Contents of demo.js
/*
    function abc(){
        print("abc function is called");
    }

    function add( a, b ){
        print(a + b);
    }

    function greet(fname, lname){
        return "Hello, " + fname + " " + lname;
    }

 */

// This doesn't work because the JavaScript engine is not initialized
public class NashornDemo {
    public static void main(String[] args) {
        try{
            // ScriptEngineManager manager = (javax.script.ScriptEngineManager) Class.forName("javax.script.ScriptEngineManager").newInstance();
            // ScriptEngine engine = manager.getEngineByName("nashorn");

            // engine.eval(new FileReader("demo.js"));
            // Invocable invocable = (Invocable) engine;
            // invocable.invokeFunction("abc");
            // invocable.invokeFunction("add", 20, 30);
            // String name = (String) invocable.invokeFunction("greet", "Omkar", "Shirwadkar");

            // engine.eval("King felt true fear for the first time");

            ScriptEngineManager mgr = new ScriptEngineManager();
            List<ScriptEngineFactory> factories = mgr.getEngineFactories();
            factories.forEach((sef)-> System.out.println(sef.getEngineName()));
        }
        catch( Exception e ){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
