package Actividades.actividad1_lab6;

public class StackLink<E> implements Stack<E> {

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> top;

    public StackLink() {
        top = null;
    }

    @Override
    public void push(E x) {
        Node<E> node = new Node<>(x);
        node.next = top;
        top = node;
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("La pila está vacía. No se puede eliminar.");
        E dato = top.data;
        top = top.next;
        return dato;
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("La pila está vacía. No hay elemento superior.");
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Pila vacía.";
        StringBuilder sb = new StringBuilder("Pila (tope → fondo): ");
        Node<E> current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null)
                sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
}