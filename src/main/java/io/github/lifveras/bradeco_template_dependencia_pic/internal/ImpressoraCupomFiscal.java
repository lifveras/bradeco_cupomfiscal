package io.github.lifveras.bradeco_template_dependencia_pic.internal;

import java.util.List;
import java.util.Map;

import io.github.lifveras.bradeco_template_dependencia_pic.internal.model.Item;
import io.github.lifveras.bradeco_template_dependencia_pic.required.CupomFiscalConcreteOutbox;

// No lugar de InternalElement
public class ImpressoraCupomFiscal {
    private CupomFiscalConcreteOutbox outbox;
    
    public void imprimirCupom(List<Item> items) {
        System.out.println("----- CUPOM FISCAL -----");
        
        double soma = 0;
        double somaImposto = 0;

        // Calcular todos os impostos
        Map<String, Double> taxas = outbox.calculaTaxas(items);

        for(Item item : items){
            soma += item.getPreco();
            //Calcular com imposto
            somaImposto =+ taxas.get(item.getNome());
        }

        System.out.println("Total: " + soma);
        System.out.println("Total com imposto: " + somaImposto);
    }

    public void setOutbox(CupomFiscalConcreteOutbox outbox){
        this.outbox = outbox;
    }
}
