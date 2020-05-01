/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */
package circuits;

public class Vanne extends Composant {
	
	protected Composant in;
	public String name;

	public Vanne(String name){
		this.name = name;
	}

	public void setIn(Composant comp) {
		
		in = comp;
		
	}

    	public String description(){
		String Sin;
		if(in==null)Sin = "non connecte";
		else Sin = in.getId();
		return getId() + " in : " + Sin;
    	}

	public boolean getEtat() throws NonConnecteException {
		
		if (in == null) {
			
			throw new NonConnecteException();
			
		} else {
			
			return in.getEtat();
			
		}
	}
}
