package circuits;
import java.util.*;

public class Circuit{

    protected List<Composant> composants=new ArrayList<Composant>();
    protected String nom;
    protected SondesTable tableSondes = new SondesTable();
    
    public Circuit(String nom, Composant[] cps){
	this.nom=nom;
	composants.addAll(Arrays.asList(cps));
	Collections.sort(composants);
    }

    public Circuit(){
    }

    public void add(Composant cp){
	composants.add(cp);
	Collections.sort(composants);
    }

    public List<String> nomenclature(){
	List<String> tmp = new ArrayList<String>();
	for(Composant cp : composants){
	    tmp.add(cp.getId());
	}
	return tmp;
    }

    public void description(){

	System.out.println(nom);
	for(Composant cp: composants){
	    System.out.println(cp.description());
	}
	
    }

        public void traceEtats(){

	System.out.println(nom);
	for(Composant cp: composants){
	    System.out.println(cp.traceEtat());
	}
	}
    
	public List<Interrupteur> getIns(){
	    List<Interrupteur> list_interrupteurs = new ArrayList<Interrupteur>();
	    for(Composant cp: composants){
		if(cp instanceof Interrupteur)list_interrupteurs.add((Interrupteur)cp);
	    }
	    return list_interrupteurs;
	   
	}

    	public List<Vanne> getOuts(){
	    List<Vanne> list_vanne = new ArrayList<Vanne>();
	    for(Composant cp: composants){
		if(cp instanceof Vanne)list_vanne.add((Vanne)cp);
	    }
	    return list_vanne;
	   
	}

    public void probe()
    {
	for(Composant cp: composants){
		if(cp instanceof Porte)((Porte)cp).probe(tableSondes);	
	}
    }

    public void resetSondes()
    {
	tableSondes.resetSondes();
    }

    public void unProbe()
    {
	for(Composant cp: composants){
		if(cp instanceof Porte)((Porte)cp).probe(tableSondes);	
	}
	tableSondes.clear();
    }
}
