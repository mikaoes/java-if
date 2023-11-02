package Tracer;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tracer {
    Class<?> parent;
    // make arraylist for every var in nVars, inside an array
    int[][] trace;
    ArrayList<String> namen = new ArrayList<String>();

    public Tracer(Class<?> parent, int nVars, int nWiederh, String methode) {
        System.out.println("Tracer imported");
        this.parent = parent;
        trace = new int[nVars][nWiederh];
    }

    public void stepByStep(String methodenName) {
        // run methodName of parent step by step and execute log() method at every step
        
        // create method object
        Class<?> m = parent.getMethod(methodenName, null);psto
    }

    public void log(String name, String... vars) {
        namen.add(name);
        for (int i = 0; i < vars.length; i++) {
            trace[i][0] = Integer.parseInt(vars[i]);
        }
    }
}
