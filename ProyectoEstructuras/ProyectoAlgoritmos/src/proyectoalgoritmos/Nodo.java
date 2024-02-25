/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

/**
 *
 * @author Administrator
 */
public class Nodo {
    public int num;
    public int feromonas;
    public Nodo siguiente;
    public Nodo(int num){
        this.num = num;
        this.feromonas = 0;
        this.siguiente = null;
    }
}

