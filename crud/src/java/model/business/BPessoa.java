package model.business;

import model.dao.DPessoa;
import model.entity.EPessoa;
import util.BusinessException;

import java.util.List;

public class BPessoa {

    private DPessoa dao;

    public BPessoa(){
        dao = new DPessoa();
    }

    public void salvar (EPessoa pessoa) {

        validarPessoa(pessoa);

        if ( pessoa.getCodPessoa() == null || pessoa.getCodPessoa() == 0 ){
            pessoa.setCodPessoa(0);
            dao.incluir(pessoa);
        }else{
            dao.alterar(pessoa);
        }
    }

    public void excluir (int  codigo ){
        dao.excluir(codigo);
    }

    public EPessoa consultar(String nome){
        return dao.consultar(nome);
    }

    public List<EPessoa> listar(){
        return dao.Listar();
    }

    private void validarPessoa(EPessoa pessoa){

        if(pessoa.getNomePessoa().isEmpty()){
            throw new BusinessException("Vazio");
        }

        if(pessoa.getNomePessoa() == null){
            throw new BusinessException("e necessario preecher o nome");
        }

    }

}
