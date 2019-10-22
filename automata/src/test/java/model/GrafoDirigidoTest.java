/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
     * creacion del grafo dirigido y validacion de sus estados inciales que son 
     * ceros y adicionar nodos para ver su comportamiento con el constructor vacio
     */
    @Test
    public void testGrafoDirCreacionSiNodos() {
        GrafoDirigido gd = new GrafoDirigido();
        gd.addNodo();
        gd.addNodo();
        boolean siTran = gd.insertarTransicion(1, 2);
        boolean noTran = gd.insertarTransicion(1, 4);
        
        assertAll(
                ()->assertEquals(gd.numNodos(),2),
                ()->assertEquals(gd.numTransiciones(),1),
                () -> assertTrue(siTran),
                () -> assertFalse(noTran)
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
     * valida que exita la transicion que se inserto en el grafo
     */
    @Test
    public void testExisteTransicion() {
        int nNodos = 6;
        GrafoDirigido gd = new GrafoDirigido(nNodos);
        boolean siTran = gd.insertarTransicion(1, 2);
        boolean exisTran = gd.existeTransicion(1, 2);
        boolean noTran = gd.insertarTransicion(1, 10);
        gd.addNodo();
        boolean siTranAdd = gd.insertarTransicion(1, 7);
        
        assertAll(() -> assertTrue(exisTran),
                () -> assertTrue(siTran),
                () -> assertFalse(noTran),
                () -> assertTrue(siTranAdd)
        );
        
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
    
    /**
     * valida que el metodo de almacenamieto de los datos funcione correctamente
     */
    @Test
    public void testAlmacenar() {
        int nNodos = 6;
        GrafoDirigido gd = new GrafoDirigido(nNodos);
        String peso = "x>5";
        boolean sitran = gd.insertarTransicion(1, 2,peso);
        Map<String, Integer> alm = new HashMap<String, Integer>();
        alm.put("A", 2);
        alm.put("B", 3);
        alm.put("B", 0);
        boolean addAlm = gd.addAlmacenado(2, alm);
        boolean addAlmNo = gd.addAlmacenado(2, alm);
        boolean addAlmNo2 = gd.addAlmacenado(7, alm);
        int valor = gd.returnAlmacenado(2).get("A");
       //int 
        assertAll(
            ()-> assertEquals(gd.pesoTransicion(1, 2),peso),
            () -> assertTrue(sitran),
            () -> assertTrue(addAlm),
            ()-> assertEquals(valor,2),
            () -> assertFalse(addAlmNo),
            () -> assertFalse(addAlmNo2)
        );        
           
    }
    
    
       
    
}
