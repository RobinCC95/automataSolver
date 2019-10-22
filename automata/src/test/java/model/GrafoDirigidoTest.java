/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class GrafoDirigidoTest {
    
    public GrafoDirigidoTest() {
        
    }
    /**
     * creacion del grafo dirigido y validacion de sus estados inciales
     */
    @Test
    public void testGrafoDirCreacion() {
        int nNodos = 6;
        GrafoDirigido gd = new GrafoDirigido(nNodos);
        assertAll(
                ()->assertEquals(gd.numNodos(),nNodos),
                ()->assertEquals(gd.numTransiciones(),0)
        );
        
    }
    /**
     * inserta las transiciones al automata y validar que se creen bien
     */
    @Test
    public void testInsertarTransicion() {
        int nNodos = 6;
        GrafoDirigido gd = new GrafoDirigido(nNodos);
        boolean addTran = gd.insertarTransicion(1, 2);
        gd.insertarTransicion(3, 4);
        assertAll(
                () -> assertTrue(addTran),
                () -> assertEquals(gd.numNodos(),nNodos),
                () -> assertEquals(gd.numTransiciones(),2)
        );
        
    }
    /**
     * inserta las transiciones al automata y validar que se creen bien
     * tambien que se valide que su valor de automata sea la misma
     */
    @Test
    public void testInsertarTransVal() {
        int nNodos = 6;
        GrafoDirigido gd = new GrafoDirigido(nNodos);
        boolean addTran = gd.insertarTransicion(1, 2);
        boolean addTran2 = gd.insertarTransicion(3, 4);       
        boolean addTran3 =gd.insertarTransicion(1, 2);
        boolean exisNodo = gd.existeNodo(1);        
        int numNodo = gd.returnNodo(1).getIdentNodo();
        System.out.println(gd.toString());             
        assertAll(
                () -> assertTrue(addTran),
                () -> assertTrue(exisNodo),
                () -> assertEquals(numNodo,1),
                () ->assertTrue(addTran2),
                () -> assertFalse(addTran3)
        );
        
    }
    /**
     * valido que exita la transicion que se inserto en el grafo
     */
    @Test
    public void testExisteTransicion() {
        int nNodos = 6;
        GrafoDirigido gd = new GrafoDirigido(nNodos);
        gd.insertarTransicion(1, 2);
        boolean addTran = gd.existeTransicion(1, 2);
        assertTrue(addTran);
    }
    /**
     * valido el metodo que devuelva un false con una transicion en el grafo que
     * no existe
     */
    @Test
    public void testExisteTransicionNo() {
        int nNodos = 6;
        GrafoDirigido gd = new GrafoDirigido(nNodos);
        gd.insertarTransicion(1, 2);
        boolean addTran = gd.existeTransicion(1, 4);
        assertFalse(addTran);
    }
    /**
     * retorna el peso de la transicion desde el nodo inicial al final
     */
    @Test
    public void testPesoTransicion() {
        int nNodos = 6;
        GrafoDirigido gd = new GrafoDirigido(nNodos);
        String peso = "x>5";
        gd.insertarTransicion(1, 2,peso);
        assertEquals(gd.pesoTransicion(1, 2),peso);
           
    }
    
    
       
    
}
