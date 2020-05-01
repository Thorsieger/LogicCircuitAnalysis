/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */
package circuits;

public class Not extends Porte {
	
	protected Composant in;
	
	public void setIn(Composant comp) {
		
		in = comp;
		
	}

        public String description(){
	    String Sin;
	    if(in==null) Sin = "non connecte";
	    else Sin = in.getId();
	    return getId() + " in : " + Sin;
	}

	public boolean getEtat() throws NonConnecteException {
		
		if (in == null) {
			
			throw new NonConnecteException();
			
		} else {
			
			return !in.getEtat();
			
		}
	}

    public void probe(SondesTable tableSondes){

	if(in instanceof Interrupteur)
	{
		in = tableSondes.getSonde((Interrupteur)in,this,"in");
	}
    }

    public void unprobe(SondesTable tableSondes){
	if(in instanceof LazySonde){
			in = tableSondes.getInterrupteur((LazySonde)in);	
		}
    }
	
}
