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

    @Test
    public void testEsAdyacente() {
        Nodo n = new Nodo(1);        
        assertTrue(n.addAdyacencia(2, "20"));
        assertEquals(n.esAdyacente(2),null);
    }

    @Test
    public void testAddAdyacencia() {
    }

    @Test
    public void testDevolverPeso() {
    }
    
}
