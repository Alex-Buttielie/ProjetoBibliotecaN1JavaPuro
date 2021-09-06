package model.business;

import model.dao.DEmprestimo;
import model.dao.DLivro;
import model.dao.DPessoa;
import model.entity.ELivro;
import model.entity.EPessoa;
import model.entity.Emprestimo;
import util.BusinessException;

import java.util.List;

public class BEmprestimo {

    private DEmprestimo dao;
    private DLivro daoLivro;

    public BEmprestimo(){
        dao = new DEmprestimo();
        daoLivro = new DLivro();
    }

    public void salvar (Emprestimo emprestimo) throws Exception {

        validarEmprestimo(emprestimo);
        salvarLivroEmprestimo(emprestimo.getCodLivroEmprestimo());

        if (emprestimo.getCodEmprestimo() == null || emprestimo.getCodEmprestimo() == 0){
            dao.incluir(emprestimo);
        }
    }

    public void excluir (int  codigo ){
        dao.excluir(codigo);
    }

    public Emprestimo consultar(int codigo){
        return dao.consultar(codigo);
    }

    public List<Emprestimo> listar(){
        return dao.Listar();
    }

    public void validarEmprestimo(Emprestimo emprestimo){

        if(emprestimo.getDataEmprestimo() == null){
            throw new BusinessException("Campo Data Emprestimo Vazio");
        }

        if(emprestimo.getCodLivroEmprestimo() == null){
            throw new BusinessException("Coloque o número do livro ao ser preencher o formulário para que a gambiarra funcione");
        }

        if (emprestimo.getObservacao() == null){
            throw new BusinessException("Coloque um observação");
        }

    }

    public void devolver(Emprestimo emprestimo)  {

        if(emprestimo.getCodEmprestimo() == null){
            throw new BusinessException ("Veja alguma problema ao enviar o codigo do emprestimo");
        }

        if (emprestimo.getIsEmprestimoAtivo() == true){
            ELivro tabela = new ELivro();
            DLivro dLivro = new DLivro();
            tabela = dLivro.consultar(emprestimo.getCodLivroEmprestimo());

            if(tabela.getCodigoLivro() == emprestimo.getCodLivroEmprestimo() && tabela.getEmprestado() == true){
                emprestimo.setIsEmprestimoAtivo(false);
                tabela.setEmprestado(false);
                dao.alterar(emprestimo);
                daoLivro.alterar(tabela);

            }
        }

    }

    public void validarDevolcaoEmprestimo(Emprestimo emprestimo){

        if (emprestimo.getIsEmprestimoAtivo() == true){
            ELivro tabela = new ELivro();
            DLivro dLivro = new DLivro();
            tabela = dLivro.consultar(emprestimo.getCodLivroEmprestimo());

            if(tabela.getCodigoLivro() == emprestimo.getCodLivroEmprestimo() && tabela.getEmprestado() == true){
                throw new BusinessException("Impossível emprestar o livro, possivelmente o livro está emprestado");
            }
        }
    }

    public void salvarLivroEmprestimo(int codigoLivro){
        ELivro tabela = new ELivro();
        DLivro dLivro = new DLivro();
        tabela = dLivro.consultar(codigoLivro);
        tabela.setEmprestado(true);
        daoLivro.alterar(tabela);
    }
}
