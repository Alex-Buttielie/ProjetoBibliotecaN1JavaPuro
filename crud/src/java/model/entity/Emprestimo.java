package model.entity;

import java.util.Date;

public class Emprestimo {

    private Integer codEmprestimo;
    private Date dataEmprestimo;
    private Integer codLivroEmprestimo;
    private Integer codPessoaEmprestimo;
    private String observacao;
    private Boolean isEmprestimoAtivo;

    public Integer getCodEmprestimo() {
        return codEmprestimo;
    }

    public void setCodEmprestimo(Integer codEmprestimo) {
        this.codEmprestimo = codEmprestimo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Integer getCodLivroEmprestimo() {
        return codLivroEmprestimo;
    }

    public void setCodLivroEmprestimo(Integer codLivroEmprestimo) {
        this.codLivroEmprestimo = codLivroEmprestimo;
    }

    public Integer getCodPessoaEmprestimo() {
        return codPessoaEmprestimo;
    }

    public void setCodPessoaEmprestimo(Integer codPessoaEmprestimo) {
        this.codPessoaEmprestimo = codPessoaEmprestimo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Boolean getIsEmprestimoAtivo() {
        return isEmprestimoAtivo;
    }

    public void setIsEmprestimoAtivo(Boolean isEmprestimoAtivo) {
        this.isEmprestimoAtivo = isEmprestimoAtivo;
    }
}
