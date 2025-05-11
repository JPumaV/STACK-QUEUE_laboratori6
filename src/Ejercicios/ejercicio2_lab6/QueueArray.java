package Ejercicios.ejercicio2_lab6;

import Actividades.actividad1_lab6.ExceptionIsEmpty;
import Actividades.actividad2_lab6.Queue;

public class QueueArray<E> implements Queue<E> {
    private E[] data;
    private int first;
    private int last;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
        this.first = 0;
        this.last = 0;
        this.size = 0;
    }

    @Override
    public void enqueue(E x) {
        if (size == capacity) {
            throw new RuntimeException("Cola llena");
        }
        data[last] = x;
        last = (last + 1) % capacity;
        size++;
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        E value = data[first];
        data[first] = null;
        first = (first + 1) % capacity;
        size--;
        return value;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        return data[first];
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        int lastIndex = (last - 1 + capacity) % capacity;
        return data[lastIndex];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(first + i) % capacity]);
            if (i < size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}