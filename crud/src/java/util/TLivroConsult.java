package util;

import model.dao.DLivro;
import model.entity.ELivro;

import java.util.List;

public class TLivroConsult {

    public static void main(String[] args) {

        DLivro dl = new DLivro();
        ELivro el;


        System.out.println("Consultando livros");
        System.out.println(" ");
        el = dl.consultar(2);


            System.out.println("Codigo: " + el.getCodigoLivro());
            System.out.println("Nome: " + el.getNomeLivro());
            System.out.println("Data Publicação: " + el.getDataPublicacao());
            System.out.println(" ");

        System.out.println("Fim da consulta");
    }
}
