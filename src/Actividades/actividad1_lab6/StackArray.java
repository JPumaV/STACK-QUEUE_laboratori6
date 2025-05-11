package Actividades.actividad1_lab6;

public class StackArray<E> implements Stack<E> {
    private E[] array;
    private int tope;

    @SuppressWarnings("unchecked")
    public StackArray(int n) {
        this.array = (E[]) new Object[n];
        this.tope = -1;
    }

    public void push(E x) {
        if (isFull()) {
            System.out.println("La pila está llena. No se puede insertar.");
        } else {
            array[++tope] = x;
        }
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía. No se puede eliminar.");
        }
        return array[tope--];
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía. No hay elemento superior.");
        }
        return array[tope];
    }

    public boolean isEmpty() {
        return this.tope == -1;
    }

    public boolean isFull() {
        return this.tope == array.length - 1;
    }

    // De arriba hacia abajo
    public String toString() {
        if (isEmpty())
            return "Pila vacía.";
        StringBuilder sb = new StringBuilder("Pila (tope → fondo): ");
        for (int i = tope; i >= 0; i--) {
            sb.append(array[i]);
            if (i > 0)
                sb.append(" -> ");
        }
        return sb.toString();
    }
}