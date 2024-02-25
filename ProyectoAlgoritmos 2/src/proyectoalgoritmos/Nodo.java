
package proyectoalgoritmos;

/**
 *
 * @author Administrator
 */
public class Nodo {
    public int num;
    public int feromonas;
    public Nodo siguiente;
    public int distancia;
    
    public Nodo(int num, int d){
        this.num = num;
        this.feromonas = 0;
        this.siguiente = null;
        this.distancia = d;
    }
}

