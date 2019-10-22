/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class NodoTest {
    
    public NodoTest() {
    }
    /**
     * valido si se genera la adyacencia y se valida por el metodo esAdyacente()
     * que no es adyacente con el identificador de nodo
     */
    @Test
    public void testEsAdyacenteNo() {
        Nodo n = new Nodo(1);        
        assertTrue(n.addAdyacencia(2, "20"));
        assertEquals(n.esAdyacente(3),null);
    }
    /**
     * valido si se genera la adyacencia y se valida por el metodo esAdyacente()
     * que si es adyacente con el identificador de nodo
     */
    @Test
    public void testEsAdyacenteSi() {
        Nodo n = new Nodo(1);       
        Adyacente ady = new Adyacente(2,"20");
        assertTrue(n.addAdyacencia(2, "20"));
        assertEquals(n.esAdyacente(2).getNodoAdy(),ady.getNodoAdy());
        assertEquals(n.esAdyacente(2).getPeso(),ady.getPeso());
    }
    
    
    @Test
    public void testAddAdyacencia() {
        
    }

    @Test
    public void testDevolverPeso() {
    }
    
}
