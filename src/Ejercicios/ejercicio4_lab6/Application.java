package Ejercicios.ejercicio4_lab6;

import Actividades.actividad1_lab6.ExceptionIsEmpty;
import Actividades.actividad1_lab6.StackLink;

public class Application {

    public static boolean symbolBalancing(String s) {
        StackLink<Character> stack = new StackLink<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty())
                    return false;

                try {
                    char top = stack.pop();

                    if ((c == ')' && top != '(') ||
                            (c == ']' && top != '[') ||
                            (c == '}' && top != '{')) {
                        return false;
                    }
                } catch (ExceptionIsEmpty e) {
                    return false; // En caso extremo, aunque ya lo verificamos con isEmpty
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] tests = {
                "()()()[()]()",
                "((()))[]",
                "([])[](",
                "([{)]}",
                "[",
                "[][][]{{{}}}"
        };

        for (String test : tests) {
            System.out.println("Entrada: " + test + " -> " + symbolBalancing(test));
        }
    }
}