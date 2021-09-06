package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.ELivro;
import util.Conexao;




public class DLivro {


    private Connection cnn;

    public DLivro() {
        this.cnn = Conexao.getConnection();
    }

    public void incluir(ELivro livro ) {

        try {
            String sql =  "INSERT INTO livro (nomeLivro, dataPublicacao) VALUES" +
                    " (?, ?)";

            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setString(1, livro.getNomeLivro());
            prds.setDate(2, (Date) livro.getDataPublicacao());
            prds.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void alterar(ELivro livro) {

        try {
            String sql="UPDATE livro SET nomeLivro = ?,"
                    +" dataPublicacao =?, "
                    +" isemprestado =? "
                    +" WHERE codigoLivro = ?;";

            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setString(1, livro.getNomeLivro());
            prds.setDate(2, (Date) livro.getDataPublicacao());
            prds.setBoolean(3,  livro.getEmprestado());
            prds.setInt(4, livro.getCodigoLivro());
            prds.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void excluir (int codigo){

        try{

            String sql = "DELETE FROM livro WHERE codigoLivro= ?;";
            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setInt(1, codigo);

            prds.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ELivro consultar(int codigo){

        ELivro livro = new ELivro();

        try {

            String sql = "SELECT * FROM livro  WHERE codigolivro = ?";
            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setInt(1, codigo);

            ResultSet rs =  prds.executeQuery();

            if(rs.next()){
                livro.setCodigoLivro(rs.getInt("codigoLivro"));
                livro.setNomeLivro(rs.getString("nomeLivro"));
                livro.setDataPublicacao(rs.getDate("dataPublicacao"));
                livro.setEmprestado(rs.getBoolean("isemprestado"));
            }

        }catch (SQLException e){

        }
        return livro;
    }

    public List<ELivro> Listar(){

        List <ELivro> lista = new ArrayList<ELivro>();

        try {
            String sql = "SELECT * FROM livro";
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

         while(rs.next()){

             ELivro livro = new ELivro();

                livro.setCodigoLivro(rs.getInt("codigoLivro"));
                livro.setNomeLivro(rs.getString("nomeLivro"));
                livro.setDataPublicacao(rs.getDate("dataPublicacao"));

                lista.add(livro);
         }

        }catch (SQLException e){

        }
        return lista;
    }



}
