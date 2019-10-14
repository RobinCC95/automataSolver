/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GrafoDirigido extends Grafo{
    
    private int numNodos;
    private int numTransicions;
    private ArrayList<Nodo> listAdyacencia;
    
    public GrafoDirigido(int numNodos)
    {
        this.numNodos = numNodos;        
        this.numTransicions = 0;
        this.listAdyacencia = new ArrayList<Nodo>();
        
        for (int i = 1; i<=numNodos; i++)
        {
            this.listAdyacencia.add(crearLista(i));
        }
    }

    @Override
    public int numNodos() {
        return numNodos;
    }

    @Override
    public int numTransiciones() {
        return this.numTransicions;
    }

    @Override
    public boolean existeTransicion(int nodoIni, int nodoFin) {
        if(this.listAdyacencia.get(nodoIni).esAdyacente(nodoFin) != null)
        {
            return true;
        }
        return false;           
    }

    @Override
    public String pesoTransicion(int nodoIni, int nodoFin) {
        if(existeTransicion(nodoIni, nodoFin))
        {
            return this.listAdyacencia.get(nodoIni).devolverPeso(nodoFin);
        }
        return null; 
    }

    @Override
    public boolean insertarTransicion(int nodoIni, int nodoFin) {
        if(insertarTransicion(nodoIni, nodoFin,"1"))
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean insertarTransicion(int nodoIni, int nodoFin, String peso) {
        if (!existeTransicion(nodoIni,nodoFin))
        {
            return this.listAdyacencia.get(nodoIni).addAdyacencia(nodoFin, peso);
        }
        return false;
    }

    @Override
    public ArrayList<Adyacente> adyacentesDe(int nodo) {
        return null;
    }
    /**
     * metodo encargado de crear listas de adyacencias por cada nodo
     * @param numIdent identificador del nodo
     * @return  la lista de adyacencia
     */
    private Nodo crearLista(int numIdent)
    {
        Nodo lA = new Nodo(numIdent);
        return lA;
    }
    
    
    
}
