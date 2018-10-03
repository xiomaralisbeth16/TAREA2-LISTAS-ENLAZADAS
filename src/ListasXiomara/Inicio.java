/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasXiomara;

import java.util.ArrayList;

/**
 *
 * @author Lisbeth
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int nCantidadElementosIniciales = 15;
        int nValorInicialDato = 1;
        int nValorFinalDato = 10000;
        int nValorInicialEnlace = 1;
        int nValorFinalEnlace = 20000;

        ArrayList<Nodo> oLista = new ArrayList<Nodo>();

        oLista = Listas.DevuelveListaEnlazada(nCantidadElementosIniciales, nValorInicialDato, nValorFinalDato, nValorInicialEnlace, nValorFinalEnlace);
        //Instanciar la clase Nodo//

        Listas ListaLinealEnlazada = new Listas(oLista, 1, nCantidadElementosIniciales);
        ListaLinealEnlazada.ImprimirLlistaLinealEnlazada();
        System.out.println("Posicion 5 : " + ListaLinealEnlazada.DevolverDatoListaEnlazada(5));

        ListaLinealEnlazada.test();
        
        
        
        
        
        
    }
    
}
