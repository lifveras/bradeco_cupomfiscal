package io.github.lifveras.bradeco_template_dependencia_pic.required;

import java.util.List;
import java.util.Map;

import io.github.lifveras.bradeco_template_dependencia_pic.internal.model.Item;
import io.github.lifveras.bradeco_template_dependencia_pic.provided.CalculadoraTaxaInterfacePort;
import io.github.lifveras.bradeco_template_dependencia_pic.provided.interfaces.CalculadoraTaxaInterface;
import io.github.lifveras.bradeco_template_dependencia_pic.provided.interfaces.CupomFiscalInterface;
import io.github.lifveras.bredeco_pic_abstract.required.StandardPortOutbox;

// Definir somente se houver componente requerido
public class CupomFiscalConcreteOutbox extends StandardPortOutbox implements CalculadoraTaxaInterface {
    
    @Override
    public Map<String, Double> calculaTaxas(List<Item> items) {
        // CalculadoraTaxaInterfacePort calculadoraExterna;
        CalculadoraTaxaInterfacePort calculadoraExterna = 
            (CalculadoraTaxaInterfacePort) externalPort;
        return calculadoraExterna.calculaTaxas(items);
    }
}
