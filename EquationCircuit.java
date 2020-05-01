import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import circuits.*;

public class EquationCircuit extends Circuit {
    LinkedHashMap<String,Interrupteur> inputs;
    LinkedHashMap<String,Vanne> outputs;

    public EquationCircuit() {
        super();
        inputs=new LinkedHashMap<String,Interrupteur>();
        outputs=new LinkedHashMap<String,Vanne>();
    }

    /** Adds an input for each name in list 'names'. */
    public void setInputs(List<String> names) {
        for(String n:names) {
            Interrupteur it = new Interrupteur(n);
            inputs.put(n,it);
            composants.add(it);
        }
    }

    /** Adds an output for each name in list 'names'. */
    public void setOutputs(List<String> names) {
        for(String n:names) {
            Vanne v=new Vanne(n);
            outputs.put(n,v);
            composants.add(v);
        }
    }

    /** Returns the Interrupteur named 'name' */
    public Interrupteur getInput(String name) {
        return inputs.get(name);
    }

    /** Returns the Vanne named 'name' */
    public Vanne getOutput(String name) {
        return outputs.get(name);
    }

    /** Evaluates and prints the output values of the circuit. Input
     * values are determined by 'vs' */
    public void eval(List<Boolean> vs) {
        List<Interrupteur> ins=new ArrayList<Interrupteur>(inputs.values());
        for (int i=0; i<vs.size(); i++) {
            Interrupteur it=ins.get(i);
            if(vs.get(i))
                it.on();
            else  it.off();
        }
        
        for(Map.Entry<String,Vanne> out:outputs.entrySet()) {
            System.out.println(out.getKey()+": "+out.getValue().traceEtat());
        }
    }

    /** Prints the circuit description */
    public void descr() {
        description();
    }
}
