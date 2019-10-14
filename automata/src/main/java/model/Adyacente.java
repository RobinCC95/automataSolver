/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *clase encargada de relacionar el nodo del grafo con otro nodo y con su peso 
 * @author Robin Cuayal
 */
class Adyacente {
    
    private int nodoAdy;
    private String peso;
    
    public Adyacente(int nodoAdy, String peso ){
        this.nodoAdy = nodoAdy;
        this.peso = peso;
    }
    /**
     * informacion del nodo al estado final y le peso de la arista
     * @return string con el numero de estado y su peso
     */
    public String toString (){
        return (nodoAdy + " "+peso);
    }
    public int getNodoAdy()
    {
        return this.nodoAdy;
    }
    public String getPeso()
    {
        return this.peso;
    }
            
    
    
    
}
