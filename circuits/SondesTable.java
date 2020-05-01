package circuits;
import java.util.*;

public class SondesTable {

    protected Map<LazySonde,Interrupteur> sondesToInterrupteurs = new TreeMap<LazySonde,Interrupteur>();
    protected Map<Interrupteur,LazySonde> interrupteursToSondes = new TreeMap<Interrupteur,LazySonde>();
    
    Interrupteur getInterrupteur(LazySonde sonde)
    {
	return sondesToInterrupteurs.get(sonde);
    }

    LazySonde getSonde(Interrupteur interrupteur, Composant cible, String entree)
    {
	if(!interrupteursToSondes.containsKey(interrupteur))
	{
	    LazySonde newSonde = new LazySonde(cible,entree);
	    interrupteursToSondes.put(interrupteur,newSonde);
	    sondesToInterrupteurs.put(newSonde,interrupteur);
	    return newSonde;
	}
	return interrupteursToSondes.get(interrupteur);
    }

    void resetSondes()
    {
	for(Map.Entry<LazySonde,Interrupteur> entry : sondesToInterrupteurs.entrySet())
	{
	    entry.getKey().reset();
	}
    }

    void clear()
    {
	sondesToInterrupteurs.clear();
	interrupteursToSondes.clear();
    }

}
