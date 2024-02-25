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
        this.InicializarArreglo(this.Ciudades);
    }
    public void InicializarArreglo(Lista[] arreglo){
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = new Lista();
        }
    }
    
    public void InsertarCiudad(int num){
        if(nodos != tamano){
            for (int i = 0; i < tamano; i++){
                if(this.Ciudades[i].primero.num == -1){
                    this.Ciudades[i].primero.num = num;
                    nodos++;
                }
                
            }
        }else{
            this.AumentarArreglo();
            this.Ciudades[tamano].primero.num = num;
            tamano += 2;
            this.nodos++;
        }
    }
    
    public void AumentarArreglo(){
        Lista[] arreglo = new Lista[tamano + 2];
        this.InicializarArreglo(arreglo);
        for (int i = 0; i < tamano; i++) {
            arreglo[i].primero = this.Ciudades[i].primero;
        }
        this.Ciudades = arreglo;
    }
    
    public void InsertarArista(int num, int num2){
        boolean encontrado1 = false;
        boolean encontrado2 = false;
        for (int i = 0; i < tamano; i++) {
            if(this.Ciudades[i].primero.num == num){
                this.Ciudades[i].AgregarCiudades(num2);
                encontrado1 = true;
            }else if(this.Ciudades[i].primero.num == num2){
                this.Ciudades[i].AgregarCiudades(num);
                encontrado2 = true;
            }
            if(encontrado1 && encontrado2){
                break;
            }
        }
    }
}
