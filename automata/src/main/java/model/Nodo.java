/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * clase encargada de generara las adyacencias del nodo 
 * @author Robin  Cuayal
 */
public class Nodo {
    
    private int nodo;
    private ArrayList<Adyacente> allAdyNodo;
    
    public Nodo(int nodo)
    {
        this.nodo = nodo;
        allAdyNodo = new ArrayList<Adyacente>();
    }
    public int getNodo()
    {
        return this.nodo;
    }
    /**
     * metodo encargado de validar si el nodo ingresado es adyacente al nodo actual
     * @param nodoAdy nodo adyacente
     * @return retorna el nodo si son adyacentes, de lo contrario un null
     */
    public Adyacente esAdyacente(int nodoAdy)
    {
        if(!this.allAdyNodo.isEmpty())
        {
            for (Adyacente ady : this.allAdyNodo)
            {
                if(ady.getNodoAdy() == nodoAdy)
                {
                    return ady;
                }    
            }
        }
        return null;
    }
    /**
     * metodo encargado de adicionar la adyacencia del nodo a la lista con su peso
     * respectivo
     * @param nodoAdy nodo a agregar la adyacencia
     * @param peso de la transicion
     * @return un true si adiciona al adyacencia, de lo contrario un false
     */
    public boolean addAdyacencia(int nodoAdy, String peso)
    {
        if(esAdyacente(nodoAdy) == null)
        {
            Adyacente ady = new Adyacente(nodoAdy, peso);
            this.allAdyNodo.add(ady);
            return true;
        }
        return false;
    }
    /**
     * devuleve el peso de la transicion del nodo actual al nodo adyacnete
     * @param nodoAdy es el nodo final
     * @return un String con el peso del nodo de lo contrarion un null
     */
    public String devolverPeso(int nodoAdy)
    {
        Adyacente ady = esAdyacente(nodoAdy);
        if (ady != null)
        {
            return ady.getPeso();
        }
        return null;
    }
    
}
