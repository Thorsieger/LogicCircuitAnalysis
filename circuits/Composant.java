/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */
package circuits;

public abstract class Composant implements Comparable<Composant>{
	
	public String getId() {
		
		return super.toString(); // class@numero renvoye par Object
		
	}

        public String description(){
	    return getId();
	}

	public abstract boolean getEtat() throws NonConnecteException;

	public String traceEtat(){
		try{
			return description() + " " + getEtat();
		}catch(NonConnecteException e){
			return description() + " Composant non connecte";
		}
			
	}

    public int compareTo(Composant other)
    {
	return this.getId().compareTo(other.getId());
    }
	
}
