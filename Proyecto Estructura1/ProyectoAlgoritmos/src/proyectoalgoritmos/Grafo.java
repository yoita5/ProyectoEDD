/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

/**
 *
 * @author Administrator
 */
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
    
    
    
    
}
