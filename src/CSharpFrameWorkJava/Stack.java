/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSharpFrameWorkJava;

/**
 *
 * @author Pingu
 */
public class Stack<T> {

    class Nodo {

        T info;
        Nodo sig;
    }

    Nodo raiz, fondo;

    Stack() {
        raiz = null;
        fondo = null;
    }

    public boolean IsEmpty() {
        return raiz == null;
    }

    public void Push(T info) {
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.info = info;
        nuevo.sig = null;
        if (IsEmpty()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }

    public T Pop() {
        T value = null;
        if (!IsEmpty()) {
            T informacion = raiz.info;
            if (raiz == fondo) {
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.sig;
            }
            value = informacion;
        }
        return value;
    }

    public T Peek() {
        T value = null;
        if (!IsEmpty()) {
            value = raiz.info;
        }
        return value;
    }

    public String ToString() {
        StringBuilder str = new StringBuilder();
        Nodo reco = raiz;
        System.out.println("Listado de todos los elementos de la cola.");
        while (reco != null) {
            str.append(reco.info.toString() + "-");
            reco = reco.sig;
        }
        return str.toString();
    }

    public int Count() {
        int cant = 0;
        Nodo reco = raiz;
        while (reco != null) {
            cant++;
            reco = reco.sig;
        }
        return cant;
    }
}
