package org.example;

public class TestTema5 {


    // ejercicio 1
    public static int signo(int x) {
        if (x > 0) {
            return 1;
        } else if (x < 0) {
            return -1;
        }
        return 0;
    }

    // ejercicio 2
    public static String clasificarEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Edad no válida");
        }
        if (edad < 6) {
            return "Infancia";
        } else if (edad < 12) {
            return "Niñez";
        } else if (edad < 18) {
            return "Adolescencia";
        } else if (edad < 25) {
            return "Juventud";
        } else if (edad < 60) {
            return "Adultez";
        } else {
            return "Vejez";
        }
    }


    // ejercicio 3
    public static int contarPositivos(int[] datos) {
        int contador = 0;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] > 0) {
                contador++;
            }
        }
        return contador;
    }


    // ejercicio 4
    public static String calificacion(int nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota no válida");
        }
        return switch (nota) {
            case 0, 1, 2, 3, 4 -> "SUSPENSO";
            case 5 -> "SUFICIENTE";
            case 6 -> "BIEN";
            case 7, 8 -> "NOTABLE";
            default -> "SOBRESALIENTE";
        };
    }


    // ejercicio 5
    public static boolean esBisiesto(int anyo) {
        if ((anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }


    // ejercicio 6
    public static String jugar(String jugador1, String jugador2) {

        if (!esValida(jugador1) || !esValida(jugador2)) {
            throw new IllegalArgumentException("Jugada no válida");
        }


        if (jugador1.equals(jugador2)) {
            return "EMPATE";
        }


        if ((jugador1.equals("PIEDRA") && jugador2.equals("TIJERA")) ||
                (jugador1.equals("TIJERA") && jugador2.equals("PAPEL")) ||
                (jugador1.equals("PAPEL") && jugador2.equals("PIEDRA"))) {
            return "GANA JUGADOR 1";
        } else {
            return "GANA JUGADOR 2";
        }
    }


    private static boolean esValida(String jugada) {
        return jugada != null && (jugada.equals("PIEDRA") ||
                jugada.equals("PAPEL") || jugada.equals("TIJERA"));
    }

    // ejercicio 7
    public static int evaluarPassword(String password) {
        if (password == null || password.isEmpty()) return 0;

        int puntos = 0;

        // 1. Longitud
        if (password.length() >= 8) puntos++;

        boolean tieneMayus = false;
        boolean tieneMinus = false;
        boolean tieneNum = false;
        boolean tieneSimb = false;

        // 2. Analizar caracteres
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) tieneMayus = true;
            else if (Character.isLowerCase(c)) tieneMinus = true;
            else if (Character.isDigit(c)) tieneNum = true;
            else tieneSimb = true; // Símbolo
        }

        if (tieneMayus) puntos++;
        if (tieneMinus) puntos++;
        if (tieneNum) puntos++;
        if (tieneSimb) puntos++;

        return puntos;
    }

    public static String interpretarResultado(int puntos) {
        if (puntos <= 2) return "DEBIL";
        if (puntos <= 4) return "MEDIA";
        return "FUERTE";
    }
}