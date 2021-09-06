package util;

import java.sql.Date;
import model.dao.DLivro;
import model.entity.ELivro;


public class TLivroAlterar {

    public static void main(String[] args) {

        DLivro dl = new DLivro();
        ELivro el = new ELivro();

        el.setCodigoLivro(1);
        el.setDataPublicacao(Date.valueOf("2001-03-16"));
        el.setNomeLivro("Fanta uva");
        dl.alterar(el);

        System.out.println("Se chegou ate aqui deu certo!");
    }
}
