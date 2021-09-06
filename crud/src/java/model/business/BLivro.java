package model.business;

import model.dao.DLivro;
import model.entity.ELivro;

import java.util.List;

public class BLivro {

    private DLivro dao;

    public BLivro (){
        dao = new DLivro();
    }

    public void salvar (ELivro livro) throws Exception {

        validarLivro(livro);

        if (livro.getCodigoLivro()== 0 || livro.getCodigoLivro() == null){
            dao.incluir(livro);
        }else{
            dao.alterar(livro);
        }
    }

    public void excluir (int  codigo ){
        dao.excluir(codigo);
    }

    public ELivro consultar(int codigo){
        return dao.consultar(codigo);
    }

    public List<ELivro> listar(){
        return dao.Listar();
    }

    private void validarLivro(ELivro livro) throws Exception{

        if(livro.getNomeLivro().isEmpty()){
            throw new Exception("Vazio");
        }

        if(livro.getNomeLivro() == null){
            throw new Exception("e necessario preecher o nome");
        }

        if (livro.getDataPublicacao() == null){
            throw new Exception("A quantidade nao pode ser zero");
        }
    }

}
