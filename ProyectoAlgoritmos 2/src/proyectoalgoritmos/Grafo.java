
package proyectoalgoritmos;

import java.util.Random;


public class Grafo {
    public int tamano;
    public int nodos;
    public Lista[] Ciudades;
    
    public Grafo(int tamano){
        this.tamano = tamano;
        this.nodos = 0;
        this.Ciudades = new Lista[tamano];
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
       return existe == null;
        
    }
    
    
    public String Recorrer(){
        
        boolean visitados [ ] = new boolean [this.tamano];


        for (int i = 0; i < this.tamano; i++){ //inicializar vector con campos false
            visitados [i] = false;
        }
        String recorrido = recorrerProfundidad(0, visitados, "");
        return recorrido;
}
    
    
    
    public String recorrerProfundidad (int v, boolean [ ] visitados, String recorrido) {
        //se marca el vértice v como visitado
        visitados [v] = true;
        //el tratamiento del vértice consiste únicamente en imprimirlo en pantalla
        System.out.println (v);
        recorrido += this.Ciudades[v].primero.num + ", ";
        //se examinan los vértices adyacentes a v para continuar el recorrido
        
        Random r = new Random();
        double random = r.nextDouble();
        int visitar = 0;
        for (int i = 0; i < tamano; i++) {
            if ((v != i) && (!visitados [i]) && (this.existeArista(this.Ciudades[v].primero.num, this.Ciudades[i].primero.num)) ){
                
                visitar +=calcularProb(v, this.Ciudades[i].primero.num, visitados);
                if(visitar > random){
                    recorrido = recorrerProfundidad ( i, visitados, recorrido);}
            }
        }
        return recorrido;
    
    }
    
        
    public int calcularProb(int v,int a, boolean [ ] visitados){
       int count = 1;
        for (int i = 0; i < tamano; i++) {
            if ((v != i) && (!visitados [i]) && this.Ciudades[i].primero != null &&(this.existeArista(this.Ciudades[v].primero.num, this.Ciudades[i].primero.num)) ){
               count ++ ;

            }}  
            
           int sumatoria = 0;
                      
       
        for (int i = 0; i < tamano; i++) {
            if ((v != i) && (!visitados [i]) && (this.existeArista(this.Ciudades[v].primero.num, this.Ciudades[i].primero.num)) ){
                int distancia = this.Ciudades[v].BuscarCiudades(this.Ciudades[i].primero.num).distancia;
               sumatoria += 1/count * 1/distancia;
            }
        
        }
        
        int resultado = (1/count * 1/this.Ciudades[v].BuscarCiudades(a).distancia)/sumatoria;
       return resultado;
}
}
