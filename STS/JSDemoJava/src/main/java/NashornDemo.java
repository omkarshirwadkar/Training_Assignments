import java.io.FileReader;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class NashornDemo {
    public static void main(String[] args) {
        
        try{
             ScriptEngineManager mgr = new ScriptEngineManager();
            List<ScriptEngineFactory> list= mgr.getEngineFactories();
            list.forEach((sef)->System.out.println(sef.getEngineName()));

            //  ScriptEngine engine = mgr.getEngineByName("Javascript");
            //  engine.eval("print('Hello Everybody')");
             
            ScriptEngine engine = mgr.getEngineByName("graal.js");
            engine.eval(new FileReader("C:\\Users\\Wissen\\Desktop\\Training_Assignments\\STS\\JSDemoJava\\src\\main\\java\\demo.js"));

            Invocable inv = (Invocable)engine;

            inv.invokeFunction("abc") ;
            inv.invokeFunction("add", 40,50) ;
            String cname = (String) inv.invokeFunction("greet","Wissen", " Technology") ;
            
            System.out.println("Welcome to "+cname);
             
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
