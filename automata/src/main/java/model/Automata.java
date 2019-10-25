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
     * @param nodo nodo que se esta envaluando en ese instante de la funcion
     * @param allNodoSol todas las soluciones que son posibles encontrar y llegar en el grafo
     * @param transicion la transicion actual en la que se encuentra la funicon recursiva
     * @return retorna un true si llego del nodo inicial a la lista de nodos solucion,
     * de lo contrario reorna un false
     */
    public boolean generarSolucion(Nodo nodo,
            ArrayList<Nodo> allNodoSol, String transicion,
            Map<String, String> transiciones)
    {
        // inicializamos  las variables
        Nodo nodoAct = new Nodo(1);
        ArrayList<Nodo> allNodoSolAct;
        Map<String, String> allTransAct = this.transiciones;
        String transicionAct;
        boolean solucion = false;
        //actualizamos informacion y cambiamos de transicion
        do
        {
            //se actualiza la informacion del nodo con la posible transicion
            nodoAct = transicionDeNodo(nodo,transicion);
            transicionAct = nextTransicion(allTransAct);
            if(validoTransicion(nodoAct))
            {
                //marcamos como visitada el nodo y si se encuentra la solucion quitarla de la lista
                allNodoSolAct = esSolucion(nodoAct,allNodoSol);
                if( allNodoSolAct != null) // validamos si hay soluciones por hallar <recursivo>
                {
                    generarSolucion(nodoAct,allNodoSolAct,transicionAct,allTransAct);
                }
                if(solucion == false)
                {
                    //quitar el nodo del grafo
                    if(quitarNodo(nodoAct) == false)
                    {
                        System.out.println("error al intentar quitar el nodo");
                    }
                }
                else
                {
                    solucion = true;
                }
            }            
            //actualizamos el diccionario de transiciones y asignamos transicion actual
            allTransAct = updateTransicion(transicion, allTransAct);            
        }
        // mientras la solucion sea falsa o el mapa de transiciones no sea vacio
        while(solucion == false && !allTransAct.isEmpty());
        
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
     * @return un true si se logro hacer la insercion correctamente, de lo contrario 
     * retorna un false
     */
    public boolean validoTransicion(Nodo nodo)
    {
        return false;
    }
    /**
     * metodo se encarga de validar si el nodo ingresado es solucion final de los nodos
     * almacenados en la lista solucion, de ser asi lo saca de la lista de nodos 
     * solucion
     * @param nodo nodo a evaluar si es solucion
     * @param allNodoSol todos los nodos solucion ingresados
     * @return la lista de nodos si encontro el nodo en la solucion y lo quito de la lista 
     * solucion con exito, por lo contrario entrega un null
     */
    public ArrayList<Nodo> esSolucion(Nodo nodo, ArrayList<Nodo> allNodoSol)
    {
        return null;
    }
    /**
     * metodo encargado de quitar el nodo del grafo
     * @param nodo nodo a quitar del grafo
     * @return retorna un true si se logro quitar el nodo con exito, de lo contrario retorna un false
     */
    public boolean quitarNodo(Nodo nodo)
    {
        return false;
    }
    /**
     * metodo encargado de quitar la transicion ya realizada o transiciones imposibles de hacer en el nodo.
     * @param transicion nombre de la transicion que se va a quitar
     * @param allTransAct todas las transiciones disponibles por hacer en el nodo
     * @return retorna las transiciones disponibles despues de quitar la realizada, de lo contrario un null
     */
    public Map<String, String> updateTransicion(String transicion, Map<String, String> allTransAct)
    {
        return null;
    }
    /**
     * metodo encargado de pasar a la siguiente transicion en el diccionario de transiciones
     * @param allTransAct diccionario de transiciones
     * @return retorna la clave de la primera transicion, de lo contrario un null
     */
    public String nextTransicion(Map<String, String> allTransAct)
    {
        return "";
    }
}
