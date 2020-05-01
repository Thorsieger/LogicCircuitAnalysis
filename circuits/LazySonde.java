package circuits;

public class LazySonde extends Sonde {

    protected boolean etat;
    protected boolean val;

    public LazySonde(Composant comp,String NomComp){
	super(comp,NomComp);
    }

    public boolean getEtat() throws NonConnecteException {
	if(val==false){
		System.out.println(NomComp + " de " + comp +", true ou false ?");
	        String ans = scan.nextLine();
	        if(ans.equals("false")) etat=false;
	        etat=true;
		val=true;
	}
	return etat;
    }
	
	public void reset(){
		val=false;	
	}

}
