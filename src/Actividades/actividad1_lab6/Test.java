package Actividades.actividad1_lab6;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> pila = new StackArray<>(5);

        try {
            System.out.println("¿Está vacía?: " + pila.isEmpty());

            pila.push(10);
            pila.push(20);
            pila.push(30);
            pila.push(40);
            pila.push(50);

            System.out.println(pila);
            System.out.println("Elemento en el tope: " + pila.top());

            pila.pop();
            pila.pop();

            System.out.println("Después de dos pops:");
            System.out.println(pila);

            pila.push(60);
            pila.push(70); // Debe mostrar mensaje de pila llena

            System.out.println(pila);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}