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
     * se prueba si el nodo no es adyacente retornando un false
     * tambien se valida si si adiciona una adyacencia
     */
    @Test
    public void testEsAdyacenteNo() {
        Nodo n = new Nodo(1);
        assertTrue(n.addAdyacencia(2, "20"));
        assertEquals(n.esAdyacente(3),null);        
    }
    
    @Test
    public void testEsAdyacente() {
        Nodo n = new Nodo(1);
        Nodo n2 = new Nodo(3);
        n2.addAdyacencia(5, "50");
        assertFalse(n.addAdyacencia(2, "20"));
        assertEquals(n.esAdyacente(3),null);
    }

    @Test
    public void testAddAdyacencia() {
        Nodo n = new Nodo(1);
        Nodo n2 = new Nodo(2);
        n2.addAdyacencia(2, "50");
        assertTrue(n.addAdyacencia(2, "20"));
        assertEquals(n.esAdyacente(2).getNodoAdy(),n2.getNodo()); 
    }

    @Test
    public void testDevolverPeso() {
    }
    
}
