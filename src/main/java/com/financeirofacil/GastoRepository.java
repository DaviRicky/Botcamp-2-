package com.financeirofacil;

import java.util.ArrayList;
import java.util.List;

public class GastoRepository {

    private List<Gasto> gastos = new ArrayList<>();

    public void salvar(Gasto g) {
        gastos.add(g);
    }

    public List<Gasto> buscarTodos() {
        return gastos;
    }

    public boolean remover(int id) {
        return gastos.removeIf(g -> g.getId() == id);
    }

    public List<Gasto> buscarPorCategoria(String categoria) {
        List<Gasto> resultado = new ArrayList<>();
        for (Gasto g : gastos) {
            if (g.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(g);
            }
        }
        return resultado;
    }
}
