package Ejercicios.ejercicio3_lab6;

import Actividades.actividad1_lab6.ExceptionIsEmpty;

import Actividades.actividad3_lab6.PriorityQueue;

public class JTest {
    public static void main(String[] args) {
        PriorityQueue<String, Integer> cola = new PriorityQueueLinked<>(5); // prioridades de 0 a 4

        cola.enqueue("Tarea normal", 1);
        cola.enqueue("Tarea urgente", 4);
        cola.enqueue("Tarea media", 2);
        cola.enqueue("Tarea baja", 0);
        cola.enqueue("Tarea alta", 3);

        System.out.println("Cola con múltiples niveles de prioridad:");
        System.out.println(cola);

        try {
            System.out.println("Front: " + cola.front());
            System.out.println("Back: " + cola.back());
            System.out.println("Dequeue: " + cola.dequeue());
            System.out.println("Cola luego del dequeue:");
            System.out.println(cola);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}