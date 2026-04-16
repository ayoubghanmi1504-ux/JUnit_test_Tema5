package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class TestTema5Test {

    // Ejercicio 1  SignoTest
    @Test
    void testPositivo() {
        assertEquals(1, TestTema5.signo(10));
    }

    @Test
    void testNegativo() {
        assertEquals(-1, TestTema5.signo(-5));
    }

    @Test
    void testCero() {
        assertEquals(0, TestTema5.signo(0));
    }

    // Ejercicio 2  ClasificarEdadTest
    @Test
    void clasificarEdadNegativaLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            TestTema5.clasificarEdad(-1);
        });
    }

    @Test
    void clasificarEdadCeroEsInfancia() {
        assertEquals("Infancia", TestTema5.clasificarEdad(0));
    }

    @Test
    void clasificarEdadCincoEsInfancia() {
        assertEquals("Infancia", TestTema5.clasificarEdad(5));
    }

    @Test
    void clasificarEdadSeisEsNinez() {
        assertEquals("Niñez", TestTema5.clasificarEdad(6));
    }

    @Test
    void clasificarEdadDiecisieteEsAdolescencia() {
        assertEquals("Adolescencia", TestTema5.clasificarEdad(17));
    }

    @Test
    void clasificarEdadDieciochoEsJuventud() {
        assertEquals("Juventud", TestTema5.clasificarEdad(18));
    }

    @Test
    void clasificarEdadVeinticincoEsAdultez() {
        assertEquals("Adultez", TestTema5.clasificarEdad(25));
    }

    @Test
    void clasificarEdadSesentaEsVejez() {
        assertEquals("Vejez", TestTema5.clasificarEdad(60));
    }

    // Ejercicio 3 ContarPositivosTest
    @Test
    void contarPositivosEnArrayVacioEsCero() {
        int[] datos = {};
        int resultado = TestTema5.contarPositivos(datos);
        assertEquals(0, resultado);
    }

    @Test
    void contarPositivosEnArrayConSoloNegativosEsCero() {
        int[] datos = {-5, -10, -1};
        int resultado = TestTema5.contarPositivos(datos);
        assertEquals(0, resultado);
    }

    @Test
    void contarPositivosEnArrayConCerosEsCero() {
        int[] datos = {0, 0, 0};
        int resultado = TestTema5.contarPositivos(datos);
        assertEquals(0, resultado);
    }

    @Test
    void contarPositivosEnArrayMezcladoEsCorrecto() {
        // Mezcla de positivo, negativo y cero
        int[] datos = {10, -5, 0, 3};
        int resultado = TestTema5.contarPositivos(datos);
        assertEquals(2, resultado);
    }


    // Ejercicio 4 CalificacionTest

    @Test
    void calificacionNegativaLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            TestTema5.calificacion(-1);
        });
    }

    @Test
    void calificacionMayorADiezLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            TestTema5.calificacion(11);
        });
    }

    @ParameterizedTest
    @CsvSource({"0, SUSPENSO", "3, SUSPENSO", "5, SUFICIENTE", "8, NOTABLE", "10, SOBRESALIENTE"})
    void testCalificacionesParametrizado(int nota, String esperado) {
        assertEquals(esperado, TestTema5.calificacion(nota));
    }

    // Ejercicio 5 EsBisiestoTest

    @Test
    void anyoDivisiblePorCuatroPeroNoPorCienEsBisiesto() {

        assertTrue(TestTema5.esBisiesto(2024));
    }

    @Test
    void anyoDivisiblePorCienPeroNoPorCuatroCientosNoEsBisiesto() {

        assertFalse(TestTema5.esBisiesto(1900));
    }

    @Test
    void anyoDivisiblePorCuatroCientosEsBisiesto() {

        assertTrue(TestTema5.esBisiesto(2000));
    }

    @Test
    void anyoNoDivisiblePorCuatroNoEsBisiesto() {

        assertFalse(TestTema5.esBisiesto(2023));
    }


    // Ejercicio 6 PiedraPapelTijeraTest

    @Test
    void jugadaInvalidaLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            TestTema5.jugar("FUEGO", "PIEDRA");
        });
    }

    @Test
    void jugadasIgualesEsEmpate() {
        assertEquals("EMPATE", TestTema5.jugar("PIEDRA", "PIEDRA"));
    }

    @Test
    void piedraGanaATijera() {
        assertEquals("GANA JUGADOR 1", TestTema5.jugar("PIEDRA", "TIJERA"));
    }

    @Test
    void tijeraGanaAPapel() {
        assertEquals("GANA JUGADOR 1", TestTema5.jugar("TIJERA", "PAPEL"));
    }

    @Test
    void papelGanaAPiedra() {
        assertEquals("GANA JUGADOR 1", TestTema5.jugar("PAPEL", "PIEDRA"));
    }

    @Test
    void jugadorDosGanaSiSuJugadaVenceALaDelUno() {

        assertEquals("GANA JUGADOR 2", TestTema5.jugar("TIJERA", "PIEDRA"));
    }



    // Ejercicio 7 PasswordTest
    @Test
    void passwordVaciaTieneCeroPuntos() {
        assertEquals(0, TestTema5.evaluarPassword(""));
    }

    @Test
    void passwordCortaSoloMinusculasEsDebil() {
        String pass = "abc";
        int puntos = TestTema5.evaluarPassword(pass);
        assertEquals(1, puntos);
        assertEquals("DEBIL", TestTema5.interpretarResultado(puntos));
    }

    @Test
    void passwordLargaConMayusculasYMinusculasEsMedia() {
        String pass = "Abcdefghi";
        int puntos = TestTema5.evaluarPassword(pass);
        assertEquals(3, puntos);
        assertEquals("MEDIA", TestTema5.interpretarResultado(puntos));
    }

    @Test
    void passwordCompletaEsFuerte() {
        String pass = "Admin123!";
        int puntos = TestTema5.evaluarPassword(pass);
        assertEquals(5, puntos);
        assertEquals("FUERTE", TestTema5.interpretarResultado(puntos));
    }
}




