package util;

import model.dao.DLivro;
import model.entity.ELivro;

import java.util.List;

public class TLivroList {

    public static void main(String[] args) {

        DLivro dl = new DLivro();
        ELivro el = new ELivro();

        System.out.println("Se chegou ate aqui deu certo!");
        System.out.println("Listando livros");
        System.out.println(" ");
        List<ELivro> lista  = dl.Listar();

        for (ELivro livro: lista) {
            System.out.println("Código: " + livro.getCodigoLivro());
            System.out.println("Nome: " + livro.getNomeLivro());
            System.out.println("Data Publicação: " + livro.getDataPublicacao());
            System.out.println(" ");

        }
        System.out.println("Fim da listagem");
    }
}
