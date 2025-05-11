package Actividades.actividad2_lab6;

import Actividades.actividad1_lab6.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x) {
        Node<E> aux = new Node<>(x);
        if (isEmpty()) {
            first = aux;
        } else {
            last.setNext(aux);
        }
        last = aux;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vacía");
        E val = first.getData();
        first = first.getNext();
        if (first == null)
            last = null;
        return val;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vacía");
        return first.getData();
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vacía");
        return last.getData();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> aux = first;
        while (aux != null) {
            sb.append(aux.getData());
            if (aux.getNext() != null)
                sb.append(", ");
            aux = aux.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
