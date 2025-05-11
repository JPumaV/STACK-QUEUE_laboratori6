package Actividades.actividad2_lab6;

import Actividades.actividad1_lab6.ExceptionIsEmpty;

public class QueueArray<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    @Override
    public void enqueue(E x) {
        if (size == capacity) {
            throw new RuntimeException("Cola llena");
        }
        data[rear] = x;
        rear = (rear + 1) % capacity;
        size++;
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vacía");
        E value = data[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vacía");
        return data[front];
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vacía");
        int backIndex = (rear - 1 + capacity) % capacity;
        return data[backIndex];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % capacity]);
            if (i < size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
