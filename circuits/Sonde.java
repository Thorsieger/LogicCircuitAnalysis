package circuits;
import java.util.Scanner;


public class Sonde extends Composant {

    protected Composant comp;
    protected String NomComp;
    static Scanner scan = new Scanner(System.in);

    
    public Sonde(Composant comp,String NomComp){
	this.NomComp = NomComp;
	this.comp = comp;
    }
    
    public boolean getEtat() throws NonConnecteException {

	    System.out.println(NomComp + " de " + comp +", true ou false ?");
	    String ans = scan.nextLine();
	    if(ans.equals("false")) return false;
	    return true;		
	}
}
