package com.techstore.calculadora;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraDescontoTest {

    private CalculadoraDesconto calculadora;

    @BeforeEach
    void setup() {
        calculadora = new CalculadoraDesconto();
    }

    // --- Cenário: Sem Desconto ---
    
    @Test
    @DisplayName("Deve retornar valor sem desconto quando for menor que R$ 100,00")
    void deveRetornarValorSemDesconto_QuandoValorForMenorQueCem() {
        assertEquals(80.00, calculadora.calcularValorFinal(80.00), 0.001);
    }

    // --- Cenário: 5% de Desconto ---

    @Test
    @DisplayName("Deve aplicar 5% de desconto quando valor for entre R$ 100,00 e R$ 499,99")
    void deveAplicarDescontoDeCincoPorcento_QuandoValorForEntreCemECinhentos() {
        double resultado = calculadora.calcularValorFinal(200.00);
        assertEquals(190.00, resultado, 0.001);
    }

    @Test
    @DisplayName("Deve aplicar 5% de desconto no limite inferior R$ 100,00")
    void deveAplicarCincoPorcento_QuandoValorForExatamenteCem() {
        assertEquals(95.00, calculadora.calcularValorFinal(100.00), 0.001);
    }

    @Test
    @DisplayName("Deve aplicar 5% de desconto no limite superior R$ 499,99")
    void deveAplicarCincoPorcento_QuandoValorForQuatrocentosENoventaENove() {
        assertEquals(474.9905, calculadora.calcularValorFinal(499.99), 0.001);
    }

    // --- Cenário: 10% de Desconto ---

    @Test
    @DisplayName("Deve aplicar 10% de desconto quando valor for maior ou igual a R$ 500,00")
    void deveAplicarDescontoDeDezPorcento_QuandoValorForMaiorOuIgualACinhentos() {
        assertEquals(900.00, calculadora.calcularValorFinal(1000.00), 0.001);
    }

    @Test
    @DisplayName("Deve aplicar 10% de desconto no limite inferior R$ 500,00")
    void deveAplicarDezPorcento_QuandoValorForExatamenteQuinhentos() {
        assertEquals(450.00, calculadora.calcularValorFinal(500.00), 0.001);
    }

    // --- Cenário: Exceção ---

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando valor for negativo")
    void deveLancarExcecao_QuandoValorForNegativo() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> calculadora.calcularValorFinal(-50.00)
        );
        
        assertEquals("Valor da compra não pode ser negativo.", exception.getMessage());
    }
}