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
    
    
    
    
}
