package io.github.lifveras.bradeco_cupomfiscal.provided.interfaces;

import java.util.List;

import io.github.lifveras.bradeco_calctaxa.internal.model.Item;
import io.github.lifveras.bradeco_cupomfiscal.internal.model.CupomFiscal;

// No lugar de SpecificProvidedInterface
public interface CupomFiscalInterface {
    public void imprimirCupomFiscal(List<Item> items);

    public CupomFiscal calculaValoresCupomFiscal(List<Item> items);
}
