/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.Date;

/**
 *
 * @author alex_buttielie
 */
public class ELivro {
    
    private Integer  codigoLivro;
    private String  nomeLivro;
    private Date dataPublicacao;
    private Boolean isEmprestado;


    public Integer getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(Integer codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Boolean getEmprestado() {
        return isEmprestado;
    }

    public void setEmprestado(Boolean emprestado) {
        isEmprestado = emprestado;
    }
}
