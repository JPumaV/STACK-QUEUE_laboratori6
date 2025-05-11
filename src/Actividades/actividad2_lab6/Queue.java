package Actividades.actividad2_lab6;

import Actividades.actividad1_lab6.ExceptionIsEmpty;

public interface Queue<E> {
    void enqueue(E x);

    E dequeue() throws ExceptionIsEmpty;

    E front() throws ExceptionIsEmpty;

    E back() throws ExceptionIsEmpty;

    boolean isEmpty();
}
