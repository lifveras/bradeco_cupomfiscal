package io.github.lifveras.bradeco_template_dependencia_pic.provided;

import io.github.lifveras.bradeco_template_dependencia_pic.internal.ImpressoraCupomFiscal;
import io.github.lifveras.bradeco_template_dependencia_pic.required.CupomFiscalConcreteOutbox;
import io.github.lifveras.bredeco_pic_abstract.provided.ComponentInterface;
import io.github.lifveras.bredeco_pic_abstract.required.PortOutbox;

// Classe Concreta de Interface
public class CupomFiscalConcreteInterface extends ComponentInterface {

    private ImpressoraCupomFiscal cupomFiscal;

    public CupomFiscalConcreteInterface(){
        initialize();     
    }

    @Override
    public void initialize() {
        CupomFiscalConcreteInterfacePort cupomPorta = 
            new CupomFiscalConcreteInterfacePort("cupomPorta");
        ports.add(cupomPorta);

        ImpressoraCupomFiscal cupomFiscal = new ImpressoraCupomFiscal();
        setCupomFiscal(cupomFiscal);

        PortOutbox outbox = cupomPorta.getOutbox();
        cupomFiscal.setOutbox((CupomFiscalConcreteOutbox)outbox);
    }

    public void setCupomFiscal(ImpressoraCupomFiscal cupomFiscal) {
        this.cupomFiscal = cupomFiscal;
    }
}
