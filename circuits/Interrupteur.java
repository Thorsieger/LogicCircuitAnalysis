/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */
package circuits;

public class Interrupteur extends Composant {

	protected boolean etat;
	public String name;
	
	public Interrupteur(String name){
	this.name = name;
	}

	public void on() {
		
		etat = true;
		
	}    
	
	public void off() {
		
		etat = false;
		
	}
	
	public boolean getEtat() throws NonConnecteException {
		
		return etat;
		
	}
}
