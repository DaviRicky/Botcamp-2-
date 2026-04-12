package com.financeirofacil;

public class Gasto {

    private static int proximoId = 1;

    private int id;
    private String descricao;
    private double valor;
    private String categoria;

    public Gasto(String descricao, double valor, String categoria) {
        this.id = proximoId++;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return String.format("[%d] %s - R$ %.2f (%s)", id, descricao, valor, categoria);
    }
}
