package com.techstore.calculadora;

public class CalculadoraDesconto {

    private static final double LIMITE_DESCONTO_5_PORCENTO = 100.00;
    private static final double LIMITE_DESCONTO_10_PORCENTO = 500.00;
    private static final double DESCONTO_5_PORCENTO = 0.05;
    private static final double DESCONTO_10_PORCENTO = 0.10;

    public double calcularValorFinal(double valorCompra) {
        validarValor(valorCompra);
        
        double percentualDesconto = obterPercentualDesconto(valorCompra);
        
        return aplicarDesconto(valorCompra, percentualDesconto);
    }

    private void validarValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor da compra não pode ser negativo.");
        }
    }

    private double obterPercentualDesconto(double valor) {
        if (valor >= LIMITE_DESCONTO_10_PORCENTO) {
            return DESCONTO_10_PORCENTO;
        } else if (valor >= LIMITE_DESCONTO_5_PORCENTO) {
            return DESCONTO_5_PORCENTO;
        }
        return 0; // Sem desconto
    }

    private double aplicarDesconto(double valor, double percentual) {
        return valor * (1 - percentual);
    }
}