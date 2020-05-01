package circuits;
public abstract class Porte2Entrees extends Porte{

    protected Composant in1;
    protected Composant in2;

    public void setIn1(Composant comp) {
		
	in1 = comp;		
    }

    public void setIn2(Composant comp) {
		
	in2 = comp;		
    }

     public String description(){
	 String Sin1,Sin2;
	if(in1==null) Sin1 = "non connecte";
	else Sin1 = in1.getId();
	if(in2==null) Sin2 = "non connecte";
	else Sin2 = in2.getId();
	return getId() + " in : " + Sin1 + " in2 : " + Sin2;
    }

	public boolean getEtat() throws NonConnecteException{
	if(in1 == null || in2 == null)
	{
		throw new NonConnecteException();
	}else{
	
	return eval();	

	}
	}
	
	public abstract boolean eval() throws NonConnecteException;

	public void probe(SondesTable tableSondes){
		if(in1 instanceof Interrupteur)
		{
			in1 = tableSondes.getSonde((Interrupteur)in1,this,"in1");
		}
		if(in2 instanceof Interrupteur)
		{
			in2 = tableSondes.getSonde((Interrupteur)in2,this,"in2");
		}
	}

	public void unprobe(SondesTable tableSondes){
		if(in1 instanceof LazySonde){
			in1 = tableSondes.getInterrupteur((LazySonde)in1);
		}
		if(in2 instanceof LazySonde){
			in2 = tableSondes.getInterrupteur((LazySonde)in2);	
		}
	}
}
