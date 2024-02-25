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
    public int distancia;
    public Nodo(int num, int d){
        this.num = num;
        this.feromonas = 0;
        this.siguiente = null;
        this.distancia = d;
    }
}

