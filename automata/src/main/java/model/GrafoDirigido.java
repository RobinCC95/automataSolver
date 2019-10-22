/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Map;

/**
 * Se encarga de generar las relaciones para un grafo dirigido, que tiene como estados
 * objetos de tipo Nodo 
 * @author Robin Cuayal
 */
public class GrafoDirigido implements Grafo{
    
    private int numNodosG;
    private int numTransicionsG;
    private ArrayList<Nodo> listAdyacencia;
    /**
     * contructor de clase encargado de crear el grafo
     * con un numero finito de nodos
     * @param numNodos numero de nodos a crear
     */
    public GrafoDirigido(int numNodos)
    {
        this.numNodosG = numNodos;
        this.numTransicionsG = 0;
        this.listAdyacencia = new ArrayList<Nodo>();
        
        for (int i = 1; i<=numNodos; i++)
        {
            this.listAdyacencia.add(crearNodo(i));
        }
    }
    /**
     * contructor de clase encargado de crear el grafo
     * sin nodos
     */
    public GrafoDirigido()
    {
        this.numNodosG = 0;
        this.numTransicionsG = 0;
        this.listAdyacencia = new ArrayList<Nodo>();
    }

    @Override
    public int numNodos() {
        if(!this.listAdyacencia.isEmpty())
        {
            this.numNodosG = this.listAdyacencia.size();
            return numNodosG;
        }
        return 0;
        
    }

    @Override
    public int numTransiciones() {
        return this.numTransicionsG;
    }

    @Override
    public boolean existeTransicion(int nodoIni, int nodoFin) {
        if(returnNodo(nodoIni).esAdyacente(nodoFin) != null)
        {
            return true;
        }
        return false;           
    }

    @Override
    public String pesoTransicion(int nodoIni, int nodoFin) {
        if(existeTransicion(nodoIni, nodoFin))
        {            
            return returnNodo(nodoIni).devolverPeso(nodoFin);
        }
        return null; 
    }

    @Override
    public boolean insertarTransicion(int nodoIni, int nodoFin) 
    {

        if (insertarTransicion(nodoIni, nodoFin, "1")) {
            return true;
        }

        return false;
    }

    @Override
    public boolean insertarTransicion(int nodoIni, int nodoFin, String peso) {
        if (existeNodo(nodoIni) && existeNodo(nodoFin)) {
            if (!existeTransicion(nodoIni, nodoFin)) {
                this.numTransicionsG++;
                return returnNodo(nodoIni).addAdyacencia(nodoFin, peso);
            }
        }

        return false;
    }
    /**
     * metodo encargado de crear el nodo del grafo
     * @param numIdent identificador del nodo
     * @return  la lista de adyacencia
     */
    private Nodo crearNodo(int numIdent)
    {
        Nodo lA = new Nodo(numIdent);
        return lA;
    }
    public String toString(){
        String salida = "";
        ArrayList<Adyacente> listaAdy;
        for (Nodo nodo : this.listAdyacencia)
        {
            salida += "Nodo: " +nodo.getIdentNodo();
            listaAdy = nodo.getAllAdyNodo();
            if (listaAdy != null)
            {
                salida += " con adycanetes: ";
                for (Adyacente ady : listaAdy)
                {
                    salida += ady.getNodoAdy() + " ";
                    salida += "\n";
                }
            }
            else
            {
                salida += " sin adycanetes \n";
            }                       
        }
        return salida;
    }

    @Override
    public Nodo returnNodo(int identNodo) 
    {        
        if(existeNodo(identNodo))
        {
            return this.listAdyacencia.get(identNodo-1);
        }
        return null;
        
    }
    @Override
    public boolean existeNodo(int identNodo)
    {
        if(numNodos() > 0)
        {
            for(Nodo nodo : this.listAdyacencia)
            {
                if(nodo.getIdentNodo() == identNodo)
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void addNodo() {
        int identNodo = numNodos()+1;
        this.listAdyacencia.add(crearNodo(identNodo));
    }
    
    /**
     * metodo encargado de devolver el almacenamiento del nodo
     * @param identNodo identificador del nodo
     * @return retorna el diccionario de almacenamiento, de lo contrario
     * retorna un null
     */
    public Map<String, Integer> returnAlmacenado(int identNodo)
    {
        Nodo nodo =returnNodo(identNodo);
        if(nodo != null)
        {
            return nodo.devolverAlmacenado();
        }
        return null;
        
    }
    /**
     * metodo encargado de hacer la asignacion del almacenamieto
     * @param identNodo identificador del nodo de tipo int
     * @param almacenar dato a almacenar en el nodo de tipo map
     * @return devuleve un true si adiciono correctamente el nodo,
     * de lo contrario un false
     */
    public boolean addAlmacenado(int identNodo, Map<String, Integer> almacenar)
    {
        Nodo nodo =returnNodo(identNodo);
        if(nodo != null)
        {
            return nodo.addAlmacenado(almacenar);
        }
        return false;
        
    }
    
    
    
}
