package Ejercicios.ejercicio2_lab6;

import Actividades.actividad1_lab6.ExceptionIsEmpty;
import Actividades.actividad2_lab6.Queue;
import Actividades.actividad2_lab6.QueueLink;

public class JTest {
    public static void main(String[] args) {
        try {
            System.out.println("=== Usando QueueLink con Strings ===");
            Queue<String> q1 = new QueueLink<>();
            q1.enqueue("A");
            q1.enqueue("B");
            q1.enqueue("C");
            System.out.println("Cola: " + q1);
            System.out.println("Front: " + q1.front());
            System.out.println("Back: " + q1.back());
            System.out.println("Dequeue: " + q1.dequeue());
            System.out.println("Cola después de dequeue: " + q1);

            System.out.println("\n=== Usando QueueLink con enteros ===");
            Queue<Integer> q2 = new QueueLink<>();
            for (int i = 1; i <= 5; i++) {
                q2.enqueue(i);
            }
            System.out.println("Cola de enteros: " + q2);
            System.out.println("Front: " + q2.front());
            System.out.println("Back: " + q2.back());

            System.out.println("\n=== Usando QueueArray con Strings ===");
            Queue<String> qa1 = new QueueArray<>(5);
            qa1.enqueue("Uno");
            qa1.enqueue("Dos");
            qa1.enqueue("Tres");
            System.out.println("Cola: " + qa1);
            System.out.println("Front: " + qa1.front());
            System.out.println("Back: " + qa1.back());
            System.out.println("Dequeue: " + qa1.dequeue());
            System.out.println("Cola después de dequeue: " + qa1);

            System.out.println("\n=== Usando QueueArray con enteros ===");
            Queue<Integer> qa2 = new QueueArray<>(3);
            qa2.enqueue(10);
            qa2.enqueue(20);
            qa2.enqueue(30);
            System.out.println("Cola de enteros: " + qa2);
            System.out.println("Front: " + qa2.front());
            qa2.dequeue();
            qa2.enqueue(40); // Probando comportamiento circular
            System.out.println("Cola final: " + qa2);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error en tiempo de ejecución: " + e.getMessage());
        }
    }
}
