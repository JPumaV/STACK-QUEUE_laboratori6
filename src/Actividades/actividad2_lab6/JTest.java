package Actividades.actividad2_lab6;

import Actividades.actividad1_lab6.ExceptionIsEmpty;

public class JTest {
    public static void main(String[] args) {
        try {
            Queue<String> q1 = new QueueArray<>(5);
            q1.enqueue("X");
            q1.enqueue("Y");
            q1.enqueue("Z");
            System.out.println("Cola: " + q1);
            System.out.println("Front: " + q1.front());
            System.out.println("Back: " + q1.back());
            System.out.println("Dequeue: " + q1.dequeue());
            System.out.println("Cola después de dequeue: " + q1);

            Queue<Integer> q2 = new QueueArray<>(3);
            q2.enqueue(10);
            q2.enqueue(20);
            q2.enqueue(30);
            System.out.println("Cola de enteros: " + q2);
            q2.dequeue();
            q2.enqueue(40); // Comprobando aritmética modular
            System.out.println("Cola después de operaciones: " + q2);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
