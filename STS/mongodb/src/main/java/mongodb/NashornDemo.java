package mongodb;
import java.io.FileReader;

import javax.script.*;
import java.util.*;
public class NashornDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ScriptEngineManager mgr = new ScriptEngineManager();
            List<ScriptEngineFactory> factories = mgr.getEngineFactories();
            factories.forEach((sef)-> System.out.println(sef.getEngineName()));
            
		}
		catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

		}
	}

}
