/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoalgoritmos;

/**
 *
 * @author Administrator
 */
public class ProyectoEstructura {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo g = new Grafo(8);
        g.InsertarCiudad(1);
        g.InsertarCiudad(2);
        g.InsertarCiudad(3);
        g.InsertarCiudad(4);
        g.InsertarArista(1, 2, 11);
        g.InsertarArista(1, 3, 3);
        g.InsertarArista(1, 4, 4);
        g.InsertarArista(3, 2, 18);
        
        g.iniciarvalorFeromonas();
        for (int i = 0; i < g.tamano; i++) {
            System.out.println(g.Ciudades[i].verFeromonas());
        }
        Interfaz interfaz = new Interfaz(g);
        // TODO code application logic here
//        Lista nueva = new Lista();
//        nueva.AgregarCiudades(3, 2);
//        nueva.AgregarCiudades(4);
//        nueva.AgregarCiudades(5);
//        nueva.AgregarCiudades(5);
//        nueva.AgregarCiudades(2);
//        nueva.AgregarCiudades(1);
//        nueva.AgregarCiudades(6);
//        nueva.AgregarCiudades(7);
//        nueva.AgregarCiudades(1);
//        nueva.Eliminar(0);
//        nueva.BuscarCiudades(3);
//        System.out.println(nueva.ImprimirCiudades());
//        nueva.BuscarMayorValorArista();
        
    }
    
}
