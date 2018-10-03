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
public class Listas {
    
    public int start;

    private int nCantidadElementos = 0;

    public static ArrayList<Nodo> ListaLinealEnlazada;

    public void AumentarCantidadElementos() {
        this.nCantidadElementos++;
    }

    public static ArrayList<Nodo> DevuelveListaEnlazada(
            int nCantidadElementosIniciales,
            int nValorInicialDato,
            int nValorFinalDato,
            int nValorInicialEnlace,
            int nValorFinalEnlace) {
        ArrayList<Nodo> oLista = new ArrayList<Nodo>();

        //this.nCantidadElementos = nCantidadElementosIniciales;
        int enlace = 0;
        int dato = 0;
        int aux = 0;
        for (int i = 1; i <= nCantidadElementosIniciales; i++) {

            if (i == nCantidadElementosIniciales) {
                enlace = 0;
            } else {
                enlace = DevuleveNumeroAleatorio(nValorInicialEnlace, nValorFinalEnlace);

            }

            dato = DevuleveNumeroAleatorio(nValorInicialDato, nValorFinalDato);

            Nodo onodo = new Nodo(dato, enlace);

            if (i == 1) {
                onodo.setPosicion(1);
                onodo.setStart(true);
            } else {
                onodo.setPosicion(aux);
                onodo.setStart(false);
            }

            aux = enlace;
            oLista.add(onodo);
            onodo = null;

        }
        return oLista;
    }

    public static int DevuleveNumeroAleatorio(int p_al_vmin, int p_al_vmax) {
        int nNumeroAleatorio = 0;

        nNumeroAleatorio = (int) (Math.random() * (p_al_vmax - p_al_vmin));

        return nNumeroAleatorio;
    }

    public Listas(ArrayList<Nodo> oLista, int p_inicio,
            int p_nCantidadElementos) {
        this.ListaLinealEnlazada = oLista;
        this.start = p_inicio;
        this.nCantidadElementos = p_nCantidadElementos;
    }

    public void ImprimirListaLinealEnlazadaOrdenada(ArrayList<Nodo> Lista) {

    }

    public void ImprimirLlistaLinealEnlazada() {

        // JOptionPane.showMessageDialog(null, Lista);
        int ptr = this.start;
        int i = 1;
        while (ptr != 0) {
            int aux = LeerEnlacePuntero(ptr);

            System.out.println("( " + i + " ) ---- > " + "[ Posición : " + ptr + "" + " Dato : " + LeerDatoPuntero(ptr) + " Enlace : " + aux + " ]");
            ptr = aux;
            i++;
        }
        System.out.println("Numero de Elementos Lista Lineal Enlazada : " + this.nCantidadElementos);

        //JOptionPane.showMessageDialog(null, Lista2);
    }

    public int DevolverDatoListaEnlazada(int n_correlativo) {
        // n_correlativo : es el orden donde se encuentra el dato.
        int dato = 0;

        int ptr = 0;
        ptr = start;
        int i = 1;
        boolean bevaluacion = true;

        while (ptr != 0 && bevaluacion == true) {
            if (i == n_correlativo) {
                dato = LeerDatoPuntero(ptr);
                bevaluacion = false;
            }
            ptr = LeerEnlacePuntero(ptr);
            i++;
        }

        return dato;
    }

    public int LeerDatoPuntero(int ptr) {
        int dato = 0;
        for (Nodo onodo : ListaLinealEnlazada) {
            if (onodo.getPosicion() == ptr) {
                dato = onodo.getDato();
            }
        }
        return dato;
    }

    public int LeerEnlacePuntero(int ptr) {
        int enlace = 0;
        for (Nodo onodo : ListaLinealEnlazada) {

            if (onodo.getPosicion() == ptr) {
                enlace = onodo.getEnlace();
            }
        }
        return enlace;
    }

    public void test() {
        int[] datos = new int[ListaLinealEnlazada.size()];
        int c = 0;
        for (Nodo e : ListaLinealEnlazada) {
            datos[c] = e.getDato();
            c++;
        }

        datos = metodoBurbujita(datos);

        ArrayList<Nodo> listaOrdenadap = new ArrayList<>();
        int tmp = 0;
        int enlace = 0;
        int n = DevuleveNumeroAleatorio(1, 1000);
        for (int y = 0; y < datos.length; y++) {

            Nodo nodoActual = ListaLinealEnlazada.get(posNodo(datos[y]));
            if (y == datos.length - 1) {
                enlace = 0;
            } else {
                enlace = nodoActual.getEnlace();
                if (enlace == 0) {
                    enlace = n;
                }

            }
            Nodo nodoTmp = new Nodo(nodoActual.getDato(), enlace);
            if (y == 0) {
                nodoTmp.setPosicion(1);
                nodoTmp.setStart(true);
                tmp = nodoActual.getEnlace();
            } else {
                if (tmp == 0) {
                    nodoTmp.setPosicion(n);
                } else {
                    nodoTmp.setPosicion(tmp);
                }

                nodoTmp.setStart(false);
                tmp = nodoActual.getEnlace();
            }
            listaOrdenadap.add(nodoTmp);
        }

        System.out.println("Lista Datos Ordenada");
        int a = 1;
        for (Nodo e : listaOrdenadap) {
            System.out.println("( " + a + " ) ---- > " + "Posicion: " + e.getPosicion() + " Dato: " + e.getDato() + " Enlace: " + e.getEnlace());
        a++;
        }

    }

    int posNodo(int dato) {
        int p = 0;
        int posN = 0;
        for (Nodo onodo : ListaLinealEnlazada) {
            if (onodo.getDato() == dato) {
                posN = p;
            }
            p++;
        }
        return posN;
    }

    int[] metodoBurbujita(int[] vector) {
        int temp;
        for (int x = 0; x < vector.length; x++) {
            for (int j = 1; j < (vector.length - x); j++) {
                if (vector[j - 1] > vector[j]) {
                    temp = vector[j - 1];
                    vector[j - 1] = vector[j];
                    vector[j] = temp;
                }
            }
        }
        return vector;
    }
}
