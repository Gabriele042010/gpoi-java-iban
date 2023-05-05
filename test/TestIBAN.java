import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestIBAN {

    private IBAN iban;

    @Before
    public void init() {
        iban = new IBAN();
    }

    @Test
    public void testVerificaIbanValido() {
        iban.setIban("IT39S0300203280758493646878");
        assertTrue(iban.verificaIban());
    }

    @Test
    public void testVerificaIbanNonValido() {
        iban.setIban("IT39S0300203280758493646875");
        assertFalse(iban.verificaIban());
    }

    @Test
    public void testVarificaIbanLunghezzaNonValida() {
        iban.setIban("IT39S030020328075849364687810");
        assertFalse(iban.verificaIban());
    }

    @Test
    public void testVarificaIbanVuoto() {
        iban.setIban("");
        assertThrows(NullPointerException.class, () -> {
            iban.verificaIban();
        });
    }
}
