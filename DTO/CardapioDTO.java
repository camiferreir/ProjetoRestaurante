package DTO;

public class CardapioDTO {

    private int id_prato;
    private String nome_prato;
    private String descricao;
    private double preco;
    private String categoria;

    public int getId_prato() {
        return id_prato;
    }

    public void setId_prato(int id_prato) {
        this.id_prato = id_prato;
    }

    public String getNome_prato() {
        return nome_prato;
    }

    public void setNome_prato(String nome_prato) {
        this.nome_prato = nome_prato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
