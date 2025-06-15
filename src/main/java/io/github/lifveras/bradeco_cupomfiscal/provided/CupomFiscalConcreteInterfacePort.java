package io.github.lifveras.bradeco_cupomfiscal.provided;

import java.util.List;

import io.github.lifveras.bradeco_calctaxa.internal.model.Item;
import io.github.lifveras.bradeco_calctaxa.provided.CalculadoraTaxaInterfacePort;
import io.github.lifveras.bradeco_cupomfiscal.internal.ImpressoraCupomFiscal;
import io.github.lifveras.bradeco_cupomfiscal.internal.model.CupomFiscal;
import io.github.lifveras.bradeco_cupomfiscal.provided.interfaces.CupomFiscalInterface;
import io.github.lifveras.bradeco_cupomfiscal.required.CupomFiscalConcreteOutbox;
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

    public void setCupomFiscal(ImpressoraCupomFiscal cupomFiscal) {
        this.cupomFiscal = cupomFiscal;
    }

    @Override
    public void imprimirCupomFiscal(List<Item> items) {
        cupomFiscal.imprimirCupom(items);
    }

    @Override
    public CupomFiscal calculaValoresCupomFiscal(List<Item> items) {
        return cupomFiscal.calculaValores(items);
    }
}
