
package proyectoalgoritmos;

import java.util.Random;


public class Grafo {
    public int tamano;
    public int nodos;
    public Lista[] Ciudades;
    int pFirst;
    int pLast;
    
    public Grafo(int tamano){
        this.tamano = tamano;
        this.nodos = 0;
        this.Ciudades = new Lista[tamano];
        this.pFirst = 0;
        this.pLast = 3;
        this.InicializarArreglo(this.Ciudades, tamano);
    }
    public void InicializarArreglo(Lista[] arreglo, int tamano){
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = new Lista();
        }
    }
    
    public void InsertarCiudad(int num){
        if(nodos < tamano){
            for (int i = 0; i < tamano; i++){
                if(this.Ciudades[i].primero == null){
                    this.Ciudades[i].primero = new Nodo(num, 0);
                    nodos++;
                    break;
                }
                
            }
        }else{
            this.AumentarArreglo();
            this.Ciudades[tamano].primero = new Nodo(num, 0);
            tamano += 2;
            this.nodos++;
        }
    }
    
    public void AumentarArreglo(){
        Lista[] arreglo = new Lista[tamano + 2];
        this.InicializarArreglo(arreglo, tamano +2);
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = this.Ciudades[i];
        }
        this.Ciudades = arreglo;
    }
    
    public void InsertarArista(int num, int num2, int d){
        boolean encontrado1 = false;
        boolean encontrado2 = false;
        for (int i = 0; i < tamano; i++) {
            if(this.Ciudades[i].primero != null && this.Ciudades[i].primero.num == num){
                this.Ciudades[i].AgregarCiudades(num2, d);
                encontrado1 = true;
            }else if(this.Ciudades[i].primero != null && this.Ciudades[i].primero.num == num2){
                this.Ciudades[i].AgregarCiudades(num, d);
                encontrado2 = true;
            }
            if(encontrado1 && encontrado2){
                break;
            }
        }
    }
    public void EliminarArista(int num){
        for (int i = 0; i < tamano; i++){
            if(this.Ciudades[i].primero != null &&  num == this.Ciudades[i].primero.num){
                this.Ciudades[i].primero = null;
                }else{
                this.Ciudades[i].EliminarCiudades(num);    
            }
            
        }
    }
    public void BuscarAristas(int num){
        String y = "";
        for (int i = 0; i < tamano; i++){
            if(this.Ciudades[i].primero != null &&  this.Ciudades[i].primero.num == num){
                y += this.Ciudades[i].ImprimirCiudades();
            }else{
                System.out.println("No se encontro");
            }
        }
    }
    public String Imprimir(){
        String y = "";
        for (int i = 0; i < tamano; i++) {
            y += this.Ciudades[i].ImprimirCiudades() + "\n";
        }
        return y;
    }
    public boolean existeArista(int ciudad1, int ciudad2){
        Nodo existe = null;
       for (int i = 0; i < tamano; i++) {
            if (this.Ciudades[i].primero != null && this.Ciudades[i].primero.num == ciudad1){
            existe = this.Ciudades[i].BuscarCiudades(ciudad2); 
            
            }else if (this.Ciudades[i].primero != null && this.Ciudades[i].primero.num == ciudad2){
            existe = this.Ciudades[i].BuscarCiudades(ciudad1);
                
            } 
    }
       return existe != null;
        
    }
 
    public Nodo buscarArista(int ciudad1, int ciudad2){
        Nodo existe = null;
       for (int i = 0; i < tamano; i++) {
            if (this.Ciudades[i].primero != null && this.Ciudades[i].primero.num == ciudad1){
             return this.Ciudades[i].BuscarCiudades(ciudad2); 
            
            }
    }
       return existe;
        
    }
    
    public Hormiga Recorrer(){
        
        boolean visitados [ ] = new boolean [this.tamano];
        Hormiga h = new Hormiga();

        for (int i = 0; i < this.tamano; i++){ //inicializar vector con campos false
            visitados [i] = false;
        }
        h.recorrido = recorrerProfundidad(0, visitados, "", h);
        this.actualizarFeromonas(h);
       return h;
}
    
    
    
    public String recorrerProfundidad (int v, boolean [ ] visitados, String recorrido, Hormiga h) {
        //se marca el vértice v como visitado
        visitados [v] = true;
        //el tratamiento del vértice consiste únicamente en imprimirlo en pantalla
//        System.out.println (v);
        recorrido += this.Ciudades[v].primero.num + ",";
        if(v != pLast){
        //se examinan los vértices adyacentes a v para continuar el recorrido

            Random r = new Random();
            double random = r.nextDouble();
            double visitar = 0;
            for (int i = 0; i < tamano; i++) {
                if ((v != i) && (!visitados [i]) && this.Ciudades[i].primero != null && (this.existeArista(this.Ciudades[v].primero.num, this.Ciudades[i].primero.num)) ){
                    visitar +=calcularProb(v, i, visitados);
                    if(visitar > random){
//                        System.out.println(this.Ciudades[v].primero.num+" tiene arista con " + this.Ciudades[i].primero.num);
                        h.distancia += this.buscarArista(this.Ciudades[v].primero.num, this.Ciudades[i].primero.num).distancia;
//                        System.out.println("Visita a " + this.Ciudades[i].primero.num);
                        recorrido = recorrerProfundidad ( i, visitados, recorrido, h);
                        break;
                    }
                }
            }}
        return recorrido;
    
    }
    
    
    public void iniciarvalorFeromonas(){
        for (int i = 0; i < this.tamano; i++) {
            
            this.Ciudades[i].iniciarFeromonas((double)this.nodos);
        }
    }
        
    public double calcularProb(int v,int a, boolean [ ] visitados){
       double sumatoria = 0;
                      
       
        for (int i = 0; i < tamano; i++) {
            if ((v != i) && (!visitados [i]) && this.Ciudades[i].primero != null &&(this.existeArista(this.Ciudades[v].primero.num, this.Ciudades[i].primero.num)) ){
                double distancia = this.buscarArista(this.Ciudades[v].primero.num, this.Ciudades[i].primero.num).distancia;
                
//                System.out.println(this.buscarArista(this.Ciudades[v].primero.num, this.Ciudades[i].primero.num).feromonas);
               sumatoria += this.buscarArista(this.Ciudades[v].primero.num, this.Ciudades[i].primero.num).feromonas * 1/distancia;
            }
        
        }
//        System.out.println(sumatoria);
        double resultado = ((this.buscarArista(this.Ciudades[v].primero.num, this.Ciudades[a].primero.num).feromonas* 1/this.buscarArista(this.Ciudades[v].primero.num, this.Ciudades[a].primero.num).distancia))/sumatoria;
       return resultado;
}
    
    public void actualizarFeromonas(Hormiga h){
        String[] recorrido = h.recorrido.split(",");
        
        for (int i = 0; i < recorrido.length; i++) {
            if(i + 1 < recorrido.length){
                
            this.buscarArista(Integer.parseInt(recorrido[i]), Integer.parseInt(recorrido[i+1])).aux += 1 /h.distancia;
            this.buscarArista(Integer.parseInt(recorrido[i + 1]), Integer.parseInt(recorrido[i])).aux += 1 /h.distancia;
        }}

            
        
        
    }
    
    public void calcularFeromonas(double a){
        for (int i = 0; i < this.tamano; i++) {
            Nodo aux = this.Ciudades[i].primero;
            if(aux!= null){
                aux = aux.siguiente;
                while(aux != null){
                    System.out.println(aux.feromonas + ", " + aux.aux);
                    aux.feromonas = aux.feromonas* (1-a) + aux.aux;
                    aux = aux.siguiente;
                }
        }}
    }
    
   
}
