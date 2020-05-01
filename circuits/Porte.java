/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */
package circuits;

public abstract class Porte extends Composant {

    public abstract void probe(SondesTable tableSondes);
    public abstract void unprobe(SondesTable tableSondes);
}
