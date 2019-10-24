/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Automata {
    private GrafoDirigido grafo;
    private Nodo estadoInicial;
    private ArrayList<Nodo> estaodosAceptacion;
    private Map<String, String> transiciones;
    private String path;
    
    public Automata(String path)
    {
        this.path = path;
    }
    /**
     * metodo recursivo encargado de buscar la solucion del grafo con las condiciones
     * iniciales. Del nodo inicial se intenta llegar a la lista de nods solucion y formar
     * el grafo solucion con los posibles caminos a los nodos hojas
     * @param g grafo que  se crea y se modifica oon la funcion recursiva
     * @param nodo nodo que se esta envaluando en ese instante de la funcion
     * @param allNodoSol todas las soluciones que son posibles encontrar y llegar en el grafo
     * @param transicion la transicion actual en la que se encuentra la funicon recursiva
     * @return retorna un true si llego del nodo inicial a la lista de nodos solucion,
     * de lo contrario reorna un false
     */
    public boolean generarSolucion(GrafoDirigido g, Nodo nodo, ArrayList<Nodo> allNodoSol, String transicion)
    {
        // inicializamos  las variables
        Nodo nodoAct = new Nodo(1);
        String transicionAct = transicion;
        boolean solucion = false;
        //actualizamos informacion y cambiamos de transicion
        do
        {
            //se actualiza la informacion del nodo con la posible transicion
            nodoAct = transicionDeNodo(nodo,transicion);
            if(validoTransicion(nodoAct,g))
            {
                //FALTA         marcamos como visitada el nodo y si se encuentra la solucion quitarla de la lista  
                if(!allNodoSol.isEmpty()) // validamos si hay soluciones por hallar 
                {
                    generarSolucion(g,nodoAct,allNodoSol,transicion);
                }
                if(solucion == false)
                {
                    //FALTA   quitar el nodo del grafo
                }
                else
                {
                    solucion = true;
                }
            }
            // FALTA   se pasa a la siguiente transicion 
        }
        while(solucion == false && transicion == "ultima transicion");
        
       return false; 
    }
    /**
     * metodo encargado de generar las transiciones de nodo actual a un nodo futuro
     * con la clave de la transicion 
     * @param nodo nodo al que se le anexara la transicion en su lista de adyacencia
     * @param transicion clave de la transicion que se va hacer al nodo
     * @return retorna el nuevo nodo adyacente al nodo ingresado con su rescpectivo 
     * almacenamiento, de lo contrario retorna null si no puede hacer la trnsicion y ni
     * crear el nodo
     */
    public Nodo transicionDeNodo(Nodo nodo, String transicion)
    {
        return null;
    }
    /**
     * metodo encargado validar si la transicion entre el nodo y el grafo es valida.
     * Despues la anexa al grafo
     * al grafo
     * @param nodo nodo que se quiere agregar al grafo
     * @param g grafo al que se le va a hacer la insercion del nodo
     * @return un true si se logro hacer la insercion correctamente, de lo contrario 
     * retorna un false
     */
    public boolean validoTransicion(Nodo nodo, GrafoDirigido g)
    {
        return false;
    }
}
