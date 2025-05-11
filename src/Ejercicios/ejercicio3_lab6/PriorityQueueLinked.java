package Ejercicios.ejercicio3_lab6;

import Actividades.actividad1_lab6.ExceptionIsEmpty;
import Actividades.actividad2_lab6.Queue;
import Actividades.actividad2_lab6.QueueLink;
import Actividades.actividad3_lab6.PriorityQueue;

public class PriorityQueueLinked<E> implements PriorityQueue<E, Integer> {
    private Queue<E>[] queues;
    private int numPriorities;

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int numPriorities) {
        this.numPriorities = numPriorities;
        queues = new Queue[numPriorities];
        for (int i = 0; i < numPriorities; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    @Override
    public void enqueue(E x, Integer pr) {
        if (pr < 0 || pr >= numPriorities) {
            throw new IllegalArgumentException("Prioridad fuera de rango");
        }
        queues[pr].enqueue(x);
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = numPriorities - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Todas las colas están vacías");
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        for (int i = numPriorities - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].front();
            }
        }
        throw new ExceptionIsEmpty("Todas las colas están vacías");
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].back();
            }
        }
        throw new ExceptionIsEmpty("Todas las colas están vacías");
    }

    @Override
    public boolean isEmpty() {
        for (Queue<E> q : queues) {
            if (!q.isEmpty())
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = numPriorities - 1; i >= 0; i--) {
            sb.append("Prioridad ").append(i).append(": ").append(queues[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
