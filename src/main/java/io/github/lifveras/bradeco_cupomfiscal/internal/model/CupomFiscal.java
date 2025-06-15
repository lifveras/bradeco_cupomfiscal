package io.github.lifveras.bradeco_cupomfiscal.internal.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CupomFiscal {
    // BigDecimal é mais adequado para valores monetários
    private BigDecimal totalCupom;
    private BigDecimal totalImpostos;

    public CupomFiscal(double totalCupom, double totalImpostos) {
        this.totalCupom = convertWithTwoDecimals(totalCupom);
        this.totalImpostos = convertWithTwoDecimals(totalImpostos);
    }

    public double getTotalCupom() {
        return totalCupom.doubleValue();
    }

    public double getTotalImpostos() {
        return totalImpostos.doubleValue();
    }

    public double getTotalComImpostos() {
        return totalCupom.add(totalImpostos).doubleValue();
    }

    private static BigDecimal convertWithTwoDecimals(double valor) {
        return (new BigDecimal(valor)).setScale(2, RoundingMode.HALF_UP);
    }
}
