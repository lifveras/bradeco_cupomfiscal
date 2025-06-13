package io.github.lifveras.bradeco_template_dependencia_pic.provided;

import java.util.List;

import io.github.lifveras.bradeco_template_dependencia_pic.internal.ImpressoraCupomFiscal;
import io.github.lifveras.bradeco_template_dependencia_pic.internal.model.Item;
import io.github.lifveras.bradeco_template_dependencia_pic.provided.interfaces.CupomFiscalInterface;
import io.github.lifveras.bradeco_template_dependencia_pic.required.CupomFiscalConcreteOutbox;
import io.github.lifveras.bredeco_pic_abstract.provided.InterfacePort;

// Classe Concreta de Porto de Interface
public class CupomFiscalConcreteInterfacePort extends InterfacePort implements CupomFiscalInterface {

    private ImpressoraCupomFiscal cupomFiscal;

    public CupomFiscalConcreteInterfacePort(String id) {
        this.id = id;
        initialize();
    }

    @Override
    public void initialize() {
        CupomFiscalConcreteOutbox cupomOutbox = new CupomFiscalConcreteOutbox();
        cupomOutbox.connect(new CalculadoraTaxaInterfacePort("calcId"));
        outbox = cupomOutbox;
    }

    @Override
    public void imprimirCupomFiscal(List<Item> items) {
        cupomFiscal.imprimirCupom(items);
    }    
}
