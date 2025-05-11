package Ejercicios.ejercicio_lab6;

import Actividades.actividad1_lab6.ExceptionIsEmpty;
import Actividades.actividad1_lab6.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> pila1 = new StackLink<>();
        Stack<String> pila2 = new StackLink<>();

        try {
            System.out.println("Pila de enteros vacía: " + pila1.isEmpty());
            pila1.push(100);
            pila1.push(200);
            pila1.push(300);
            System.out.println(pila1);
            System.out.println("Elemento en el tope: " + pila1.top());
            pila1.pop();
            System.out.println("Después de un pop: " + pila1);

            System.out.println("\nPila de cadenas vacía: " + pila2.isEmpty());
            pila2.push("Hola");
            pila2.push("Mundo");
            System.out.println(pila2);
            pila2.pop();
            System.out.println("Después de un pop: " + pila2);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}