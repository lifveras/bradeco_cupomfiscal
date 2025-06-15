package io.github.lifveras.bradeco_cupomfiscal.internal;

import java.util.List;
import java.util.Map;

import io.github.lifveras.bradeco_calctaxa.internal.model.Item;
import io.github.lifveras.bradeco_cupomfiscal.internal.model.CupomFiscal;
import io.github.lifveras.bradeco_cupomfiscal.required.CupomFiscalConcreteOutbox;

// No lugar de InternalElement
public class ImpressoraCupomFiscal {
    private CupomFiscalConcreteOutbox outbox;

    public void imprimirCupom(List<Item> items) {
        CupomFiscal cupom = calculaValores(items);
        System.out.println("----- CUPOM FISCAL -----");
        System.out.println("Total: " + cupom.getTotalCupom());
        System.out.println("Total de imposto: " + cupom.getTotalImpostos());
        System.out.println("Total com impostos: " + cupom.getTotalComImpostos());
    }

    public CupomFiscal calculaValores(List<Item> items) {
        double soma = 0;
        double somaImposto = 0;

        // Calcular todos os impostos
        outbox.calculaTaxas(items);
        Map<String, Double> taxas = outbox.calculaTaxas(items);

        for (Item item : items) {
            soma += item.getPreco();
            // Calcular com imposto
            somaImposto += taxas.get(item.getNome());
        }

        return new CupomFiscal(soma, somaImposto);
    }

    public void setOutbox(CupomFiscalConcreteOutbox outbox) {
        this.outbox = outbox;
    }
}
