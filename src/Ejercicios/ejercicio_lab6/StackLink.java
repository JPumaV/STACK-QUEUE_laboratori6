package Ejercicios.ejercicio_lab6;

import Actividades.actividad1_lab6.ExceptionIsEmpty;
import Actividades.actividad1_lab6.Stack;

public class StackLink<E> implements Stack<E> {
    private Node<E> top;

    public StackLink() {
        top = null;
    }

    public void push(E x) {
        top = new Node<>(x, top);
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía. No se puede eliminar.");
        }
        E val = top.data;
        top = top.next;
        return val;
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía. No hay elemento superior.");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String toString() {
        if (isEmpty())
            return "Pila vacía.";
        StringBuilder sb = new StringBuilder("Pila (tope → fondo): ");
        Node<E> current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null)
                sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
}