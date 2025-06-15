import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.lifveras.bradeco_calctaxa.internal.Categoria;
import io.github.lifveras.bradeco_calctaxa.internal.model.Item;
import io.github.lifveras.bradeco_calctaxa.provided.CalculadoraTaxaConcreteInterface;
import io.github.lifveras.bradeco_cupomfiscal.internal.model.CupomFiscal;
import io.github.lifveras.bradeco_cupomfiscal.provided.CupomFiscalConcreteInterface;
import io.github.lifveras.bradeco_cupomfiscal.provided.CupomFiscalConcreteInterfacePort;

public class CupomFiscalComponentTest {
    private static CupomFiscalConcreteInterface cupomFiscal;
    private static CupomFiscalConcreteInterfacePort cupomPort;
    private static CalculadoraTaxaConcreteInterface calcTaxa;
    private static List<Item> lista;

    @BeforeAll
    public static void configTestes() {
        // Criação dos componentes
        cupomFiscal = new CupomFiscalConcreteInterface();
        calcTaxa = new CalculadoraTaxaConcreteInterface();

        cupomFiscal.connect(calcTaxa.getPort("calcPort"), "cupomPort");

        cupomPort = (CupomFiscalConcreteInterfacePort) cupomFiscal.getPort("cupomPort");

        lista = new ArrayList<>();
        lista.add(new Item("Banana", 10.9d, Categoria.FOOD));
        lista.add(new Item("Camisa", 23.9d, Categoria.CLOTHING));
        lista.add(new Item("Computador", 999.9d, Categoria.ELECTRONICS));
    }

    @Test
    public void testaCupomFiscalValores() {
        CupomFiscal cupom = cupomPort.calculaValoresCupomFiscal(lista);
        assertEquals(cupom.getTotalCupom(), 1034.7);
        assertEquals(cupom.getTotalImpostos(), 152.92);
        assertEquals(cupom.getTotalComImpostos(), 1187.62);
    }
}
