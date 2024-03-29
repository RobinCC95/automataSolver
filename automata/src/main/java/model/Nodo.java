/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * clase encargada de generara las adyacencias del identNodo por medio de un arraylist
 con objetos adyacentes
 * @author Robin  Cuayal
 */
public class Nodo {
    
    private int identNodo;
    private ArrayList<Adyacente> allAdyNodo;
    private Map<String, Integer> almacenado;
    
    public Nodo(int identNodo)
    {
        this.identNodo = identNodo;
        allAdyNodo = new ArrayList<Adyacente>();        
        this.almacenado = new HashMap<String, Integer>();
    }
    public int getIdentNodo()
    {
        return this.identNodo;
    }
    /**
     * metodo encargado de validar si el identNodo ingresado es adyacente al identNodo actual
     * @param nodoAdy identNodo adyacente
     * @return retorna el identNodo si son adyacentes, de lo contrario un null
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
     * metodo encargado de adicionar la adyacencia del identNodo a la lista con su peso
 respectivo
     * @param nodoAdy identNodo a agregar la adyacencia
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
     * devuleve el peso de la transicion del identNodo actual al identNodo adyacnete
     * @param nodoAdy es el identNodo final
     * @return un String con el peso del identNodo de lo contrarion un null
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
    /**
     * devueve todas las adyacencias que tiene el nodo en una lista de tipo
     * Adyacente
     * @return una lista Adyacente de lo contrario un null
     */
    public ArrayList<Adyacente> getAllAdyNodo()
    {
        if (!this.allAdyNodo.isEmpty())
        {
            return this.allAdyNodo;
        }
        return null;
        
    }
    /**
     * retorna el almacenamiento del nodo
     * @return retorna el diccioario de almacenamiento si tiene valores, de lo contrario
     * retorna un null
     */
    public Map<String, Integer> devolverAlmacenado()
    {
        if(!almacenado.isEmpty())
        {
            return this.almacenado; 
        }
        return null;               
    }
    /**
     * metodo encargado de modificar el almacenamiento del nodo
     * @param alamcenado de tipo hashMap para ser modificado
     * @return retorna un true si se modifico correctamente, de lo ocntrario
     * devuelve un false
     */
    public boolean addAlmacenado(Map<String, Integer> almacenado)
    {
        if(devolverAlmacenado() == null)
        {            
            this.almacenado = almacenado;
            return true;
        }
        return false;
    }
    
}
