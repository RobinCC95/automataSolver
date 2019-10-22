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
public interface Grafo {
    
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
     * retorna el nodo del grafo al cual se le ingreso el valor de su identificador
     * @param identNodo identificador del nodo al que se quiere acceder
     * @return retorna el nodo al que se quiere acceder de lo contrario se devuelve
     * un null
     */
    public abstract Nodo returnNodo(int identNodo);
    /**
     * verifica si existe el nodo en la lista de adyacencia con el identificador
     * del nodo
     * @param identNodo identificador del nodo al que se quiere acceder
     * @return retorna un true si existe el nodo, de lo contrario devuelve un false
     */
    public abstract boolean existeNodo(int identNodo);
    /**
     * metodo encargado de adicionar un nodo a la lista de adyacencia con el 
     * identificador de nodo equivalente a numero de nodos +1
     */
    public abstract void addNodo();
    /**
     * metoodo encargado de imprimir los nodos con sus nodos adyacentes
     * en el grafo
     * @return un String con las adyacencias de cada nodo del grafo
     */
    public abstract String toString();
    
    
}
