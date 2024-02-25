
package proyectoalgoritmos;

/**
 *
 * @author Administrator
 */
public class Nodo {
    public int num;
    public double feromonas;
    public Nodo siguiente;
    public double distancia;
    public double aux;
    public Nodo(int num, double d){
        this.num = num;
        this.feromonas = 0;
        this.siguiente = null;
        this.distancia = d;
        this.aux = 0;
    }
}

