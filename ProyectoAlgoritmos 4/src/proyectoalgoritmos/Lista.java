
package proyectoalgoritmos;

/**
 *
 * @author Administrator
 */
public class Lista{
    Nodo primero;
    public int tamano;
    public Lista(){
        this.tamano = 0;
        this.primero = null;
    }
    public void AgregarCiudades(int num, int d){
        Nodo ciudad = new Nodo(num, d);
        Nodo aux = primero;
        if(primero == null){
            primero = ciudad;
            tamano++;
        }else{
        while(aux.siguiente != null){
            aux = aux.siguiente;
        }
        aux.siguiente = ciudad;
        tamano ++;
    }
    }
    public void EliminarCiudades(int num){
        if(primero == null){
            System.out.println("No hay Ciudades");
        }
        else if(primero.num == num){
            primero = primero.siguiente;
            tamano--;

        }else{
            Nodo aux = primero;
            while(aux.siguiente != null && aux.siguiente.num != num ){
                aux = aux.siguiente;                
            }
            if(aux.siguiente!= null){
                aux.siguiente = aux.siguiente.siguiente;}
        }
        
    }
    public Nodo BuscarCiudades(int num){
        Nodo aux = primero;
        while(aux != null && aux.num != num){
            aux = aux.siguiente;
        }
        return aux;
        
    }
    public String ImprimirCiudades(){
        Nodo aux = primero;
        String lista  = "";
        if(aux != null){
             lista = "Las cuidades adyacentes a " + aux.num + " son: ";  
            aux = aux.siguiente;
            while(aux != null){   
                if(aux.siguiente != null){
                    lista += aux.num + ", ";}
                else{
                    lista += aux.num;
                }
                aux = aux.siguiente;

            }}
        return lista;
    }
    
    public void BuscarMayorValorArista(){
        Nodo aux = primero.siguiente;
        Nodo valor = aux;
        while(aux != null){
            if(aux.feromonas > valor.feromonas){
                valor = aux;
            }
            aux = aux.siguiente;
        }
        System.out.println(valor.feromonas);
    }
    
    public void iniciarFeromonas(double nodo){
        Nodo aux = this.primero;
        if(this.primero != null){
            aux = aux.siguiente;
            while(aux!= null){
                System.out.println("aaaaaaa");
                aux.feromonas = 1/nodo;
                aux = aux.siguiente;
            }
        }
    }
    
    public String verFeromonas(){
        Nodo aux = this.primero;
        String a = "";
        if(this.primero != null){
            aux = aux.siguiente;
            while(aux!= null){
                a+= aux.feromonas + ", ";
                aux = aux.siguiente;
            }
        }
        
        return a;
    }
}
