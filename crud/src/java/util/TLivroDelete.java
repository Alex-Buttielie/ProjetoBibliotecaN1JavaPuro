package util;

import model.dao.DLivro;


public class TLivroDelete {

    public static void main(String[] args) {

        DLivro dp = new DLivro();

        System.out.println("Tentando deletar livro");

        dp.excluir(3);

        System.out.println("Se chegou ate aqui deu certo!");

    }
}
