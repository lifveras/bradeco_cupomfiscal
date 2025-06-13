import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.lifveras.bradeco_template_dependencia_pic.internal.Categoria;
import io.github.lifveras.bradeco_template_dependencia_pic.internal.model.Item;
import io.github.lifveras.bradeco_template_dependencia_pic.provided.CalculadoraTaxaConcreteInterface;
import io.github.lifveras.bradeco_template_dependencia_pic.provided.CupomFiscalConcreteInterface;
import io.github.lifveras.bradeco_template_dependencia_pic.provided.CupomFiscalConcreteInterfacePort;

public class CupomFiscalComponentTest {
    private static double num1;
    private static double num2;
    private static CupomFiscalConcreteInterface cupomFiscal;
    private static CalculadoraTaxaConcreteInterface calcTaxa;
    private static List<Item> lista;
    @BeforeAll
    public static void configTestes(){
        num1 = 10;
        num2 = 20;
        cupomFiscal = new CupomFiscalConcreteInterface();
        calcTaxa = new CalculadoraTaxaConcreteInterface();

        cupomFiscal.connect(calcTaxa.getPort("opsPort"), "cupomPorta");

        lista = new ArrayList<>();
        lista.add(new Item("Banana", 10.9d, Categoria.FOOD));
        lista.add(new Item("Camisa", 23.9d, Categoria.CLOTHING));
        lista.add(new Item("Computador", 999.9d, Categoria.ELECTRONICS));
    }

    @Test
    public void testaCupomFiscal(){
        CupomFiscalConcreteInterfacePort cupom = 
            (CupomFiscalConcreteInterfacePort) cupomFiscal.getPort("cupomPorta");
        cupom.imprimirCupomFiscal(lista);
        assertEquals(0, 0);
    }

    @Test
    public void testSoma(){
        double result = soma(num1, num2);
        assertEquals(result, 30);
    }

    @Test
    public void testSubtracao(){
        double result = subtracao(num1, num2);
        assertEquals(result, -10);
    }

    public static double soma(double a, double b){
        return a + b;
    }
    public static double subtracao(double a, double b){
        return a - b;
    }
}
