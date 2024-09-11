package com.beloti.poi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_ponto_interesse")
public class PontoInteresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private String funcionamento;
    private Long x;
    private Long y;

    public PontoInteresse() {
    }

    public PontoInteresse(String nome,String tipo, String funcionamento, Long x, Long y) {
        this.nome = nome;
        this.tipo = tipo;
        this.funcionamento = funcionamento;
        this.x = x;
        this.y = y;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFuncionamento() {
        return funcionamento;
    }

    public void setFuncionamento(String funcionamento) {
        this.funcionamento = funcionamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }
}
