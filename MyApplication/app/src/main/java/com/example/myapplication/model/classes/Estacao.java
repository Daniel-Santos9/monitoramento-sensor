package com.example.myapplication.model.classes;

public class Estacao {
    private String nome;
    private String descricao;
    private String proprietatio;
    private String localizacao;

    public Estacao(){}


    public Estacao(String nome, String descricao, String proprietatio, String localizacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.proprietatio = proprietatio;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProprietatio() {
        return proprietatio;
    }

    public void setProprietatio(String proprietatio) {
        this.proprietatio = proprietatio;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return nome;
    }
}
