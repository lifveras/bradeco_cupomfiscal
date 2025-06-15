package io.github.lifveras.bradeco_cupomfiscal.provided;

import java.util.ArrayList;

import io.github.lifveras.bradeco_cupomfiscal.internal.ImpressoraCupomFiscal;
import io.github.lifveras.bradeco_cupomfiscal.required.CupomFiscalConcreteOutbox;
import io.github.lifveras.bredeco_pic_abstract.provided.ComponentInterface;
import io.github.lifveras.bredeco_pic_abstract.required.PortOutbox;

// Classe Concreta de Interface
public class CupomFiscalConcreteInterface extends ComponentInterface {

    public CupomFiscalConcreteInterface() {
        super();
        initialize();
    }

    @Override
    public void initialize() {
        CupomFiscalConcreteInterfacePort cupomPort = new CupomFiscalConcreteInterfacePort("cupomPort");
        ports.add(cupomPort);

        ImpressoraCupomFiscal cupomFiscal = new ImpressoraCupomFiscal();
        cupomPort.setCupomFiscal(cupomFiscal);

        PortOutbox outbox = cupomPort.getOutbox();
        cupomFiscal.setOutbox((CupomFiscalConcreteOutbox) outbox);
    }
}
