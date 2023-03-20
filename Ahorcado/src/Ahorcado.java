import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] palabras = {"java", "busqueda", "empleo", "programacion", "desarrollador", "compilador"};
        String palabraSeleccionada = palabras[(int) (Math.random() * palabras.length)];
        int intentosRestantes = 6;
        boolean[] letrasAdivinadas = new boolean[palabraSeleccionada.length()];

        while (intentosRestantes > 0 && !todasLetrasAdivinadas(letrasAdivinadas)) {
            System.out.println("Adivina la palabra:");
            mostrarPalabra(palabraSeleccionada, letrasAdivinadas);
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.print("Introduce una letra: ");
            String letra = scanner.nextLine();

            if (letra.length() != 1) {
                System.out.println("Introduce una letra válida");
                continue;
            }

            boolean letraAdivinada = false;
            for (int i = 0; i < palabraSeleccionada.length(); i++) {
                if (palabraSeleccionada.charAt(i) == letra.charAt(0)) {
                    letrasAdivinadas[i] = true;
                    letraAdivinada = true;
                }
            }

            if (!letraAdivinada) {
                System.out.println("La letra no está en la palabra");
                intentosRestantes--;
            }
        }

        if (todasLetrasAdivinadas(letrasAdivinadas)) {
            System.out.println("¡Felicidades, has adivinado la palabra!");
        } else {
            System.out.println("Lo siento, has perdido. La palabra era: " + palabraSeleccionada);
        }
    }

    private static boolean todasLetrasAdivinadas(boolean[] letrasAdivinadas) {
        for (boolean letraAdivinada : letrasAdivinadas) {
            if (!letraAdivinada) {
                return false;
            }
        }
        return true;
    }

    private static void mostrarPalabra(String palabra, boolean[] letrasAdivinadas) {
        for (int i = 0; i < palabra.length(); i++) {
            if (letrasAdivinadas[i]) {
                System.out.print(palabra.charAt(i) + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }
}
