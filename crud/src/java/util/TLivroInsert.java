package util;

import java.sql.Date;
import model.dao.DLivro;
import model.entity.ELivro;


public class TLivroInsert {

    public static void main(String[] args) {

        DLivro dl = new DLivro();
        ELivro el = new ELivro();

        System.out.println("Tentando incluir livro");

        el.setNomeLivro("Nova coca cola");
        el.setDataPublicacao(Date.valueOf("2001-03-16"));

        dl.incluir(el);

        System.out.println("Se chegou ate aqui deu certo!");
        
    }
}
