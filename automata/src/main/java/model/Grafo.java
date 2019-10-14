/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *clase abstracta encargada de crear los metodos nesesarios para el grafo
 * @author Robin Cuayal
 */
public abstract class Grafo {
    
    public Grafo(){}
    /**
     * metodo encargado de dar el numero de vertices del grafo
     * @return el numero de vertices del automata
     */
    public abstract int numNodos();
    /**
     * metodo encargado de dar el numero de aristas del grafo
     * @return el numero de aristas 
     */
    public abstract int numTransiciones();
    /**
     * metodo encargado de validar si exite la arista entre los dos nodos 
     * @param nodoIni nodo inicial
     * @param nodoFin nodo final
     * @return un true si existe la arista, de lo contrario un false
     */
    public abstract boolean existeTransicion(int nodoIni, int nodoFin);
    /**
     * metodo encargado de devolver el peso de la arista de los dos nodos
     * @param nodoIni nodo inicial
     * @param nodoFin nodo final
     * @return el peso que tiene la arista
     */
    public abstract String pesoTransicion(int nodoIni, int nodoFin);
    /**
     * metodo encargado de insertar una transicion entre los nodos con peso de 1
     * @param nodoIni nodo inicial
     * @param nodoFin  nodo final
     * @return retorna un true si inserto la transicion, de lo contrario un false
     */
    public abstract boolean insertarTransicion(int nodoIni, int nodoFin);
    /**
     * metoso encargado de insertar una transicion entre nodos con peso establecido
     * en el parametro
     * @param nodoIni nodo inicial
     * @param nodoFin nodo final
     * @param peso de la transicion
     * @return retorna un true si inserto la transicion, de lo contrario un false
     */
    public abstract boolean insertarTransicion(int nodoIni, int nodoFin, String peso);
    /**
     * metodo encargado de devolver los nodos adyacentes o relacionados del nodo
     * ingresado
     * @param nodo del grafo
     * @return lista de nodos adyacentes
     */
    public abstract ArrayList<Adyacente> adyacentesDe(int nodo);
    /**
     * metoodo encargado de imprimir los nodos con sus nodos adyacentes
     * en el grafo
     * @return un String con las adyacencias de cada nodo del grafo
     */
    public String toString(){
        String salida = "";
        ArrayList<Adyacente> listaAdy;
        for(int i=0; i<=numNodos();i++)
        {
            salida += "vertice" +i;
            listaAdy = adyacentesDe(i);
            if (!listaAdy.isEmpty())
            {
                salida += "con adycanetes";
                for (Adyacente nodo : listaAdy)
                {
                    salida += nodo.getNodoAdy() + " ";
                    salida += "\n";
                }
            }
            else
            {
                salida += "sin adycanetes";
            }                       
        }
        return salida;
    }
    
    
}
