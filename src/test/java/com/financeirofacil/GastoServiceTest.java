package com.financeirofacil;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class GastoServiceTest {

    private GastoService servico;

    @BeforeEach
    void init() {
        servico = new GastoService();
    }

    @Test
    void adicionaGastoNormal() {
        servico.adicionar("mercado", 150.0, "alimentacao");
        assertEquals(1, servico.listar().size());
        assertEquals("mercado", servico.listar().get(0).getDescricao());
    }

    @Test
    void valorNegativoDevedarErro() {
        assertThrows(IllegalArgumentException.class, () -> {
            servico.adicionar("teste", -50.0, "outros");
        });
    }

    @Test
    void removeGastoQueExiste() {
        servico.adicionar("luz", 200.0, "moradia");
        int id = servico.listar().get(0).getId();
        assertTrue(servico.remover(id));
        assertEquals(0, servico.listar().size());
    }

    @Test
    void removeIdQueNaoExiste() {
        assertFalse(servico.remover(999));
    }

    @Test
    void descricaoVaziaDevedarErro() {
        assertThrows(IllegalArgumentException.class, () -> {
            servico.adicionar("", 100.0, "outros");
        });
    }
}
