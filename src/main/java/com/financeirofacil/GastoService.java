package com.financeirofacil;

import java.util.List;

public class GastoService {

    private GastoRepository repositorio = new GastoRepository();

    public void adicionar(String descricao, double valor, String categoria) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor tem que ser maior que zero");
        }
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descricao nao pode ser vazia");
        }
        Gasto g = new Gasto(descricao, valor, categoria);
        repositorio.salvar(g);
    }

    public List<Gasto> listar() {
        return repositorio.buscarTodos();
    }

    public boolean remover(int id) {
        return repositorio.remover(id);
    }

    public double totalGasto() {
        double total = 0;
        for (Gasto g : repositorio.buscarTodos()) {
            total += g.getValor();
        }
        return total;
    }

    public List<Gasto> buscarPorCategoria(String categoria) {
        return repositorio.buscarPorCategoria(categoria);
    }
}
