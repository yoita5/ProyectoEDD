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
        // TODO code application logic here
        Lista nueva = new Lista();
        nueva.AgregarCiudades(3, 1);
        nueva.AgregarCiudades(4, 2);
        nueva.AgregarCiudades(5, 4);
        nueva.AgregarCiudades(5, 5);
        nueva.AgregarCiudades(2, 1);
        nueva.AgregarCiudades(1, 1);
        nueva.AgregarCiudades(6, 6);
        nueva.AgregarCiudades(7, 7);
        nueva.AgregarCiudades(1, 7);
//        nueva.Eliminar(0);
        nueva.BuscarCiudades(3);
        System.out.println(nueva.ImprimirCiudades());
        nueva.BuscarMayorValorArista();
        
    }
    
}
