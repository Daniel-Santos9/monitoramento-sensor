package com.example.myapplication.model.classes;

public class Sensor {
    private String nome;
    private String medida;
    private String tipo_saida;
    private String range;
    private String velocidade_resposta;
    private String unidade_medida;
    private String localizacao;
    private String status;


    public Sensor(){}
    public Sensor( String nome, String medida, String tipo_saida, String range, String velocidade_resposta, String unidade_medida, String localizacao, String status) {
        this.nome = nome;
        this.medida = medida;
        this.tipo_saida = tipo_saida;
        this.range = range;
        this.velocidade_resposta = velocidade_resposta;
        this.unidade_medida = unidade_medida;
        this.localizacao = localizacao;
        this.status = status;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_saida() {
        return tipo_saida;
    }

    public void setTipo_saida(String tipo_saida) {
        this.tipo_saida = tipo_saida;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getVelocidade_resposta() {
        return velocidade_resposta;
    }

    public void setVelocidade_resposta(String velocidade_resposta) {
        this.velocidade_resposta = velocidade_resposta;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return dados();
    }

    public String dados(){

       String dados =  "Nome: "+nome + "\n"+
               "Medida: " + medida + "\n"+
               "Tipo de Saída: " + tipo_saida + "\n"+
               "Alcance: " + range + "\n"+
               "Velocidade de resposta: " +  velocidade_resposta + "\n"+
               "Unidade de medida: " +  unidade_medida + "\n" +
               "Localização: " + localizacao +  "\n"+
               "Status: "+ status.toUpperCase() + "\n";

       return  dados;

    }
}

