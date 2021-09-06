package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.EPessoa;
import util.Conexao;




public class DPessoa {


    private Connection cnn;

    public DPessoa() {
        this.cnn = Conexao.getConnection();
    }

    public void incluir(EPessoa pessoa ) {

        try {
            String sql =  "INSERT INTO pessoa (nomePessoa) VALUES" +
                    " (?)";

            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setString(1, pessoa.getNomePessoa());
            prds.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void alterar(EPessoa pessoa) {

        try {
            String sql="UPDATE pessoa SET nomePessoa = ?"
                    +" WHERE codigoPessoa = ?;";

            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setString(1, pessoa.getNomePessoa());
            prds.setInt(2, pessoa.getCodPessoa());
            prds.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void excluir (int codigo){

        try{

            String sql = "DELETE FROM pessoa WHERE codigoPessoa = ?;";
            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setInt(1, codigo);

            prds.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public EPessoa consultar(String nome){

        EPessoa pessoa = new EPessoa();

        try {

            String sql = "SELECT * FROM pessoa  WHERE nomePessoa = ?";
            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setString(1, nome);

            ResultSet rs =  prds.executeQuery();

            if(rs.next()){
                pessoa.setCodPessoa(rs.getInt("codpessoa"));
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
            }

        }catch (SQLException e){

        }
        return pessoa;
    }

    public List<EPessoa> Listar(){

        List <EPessoa> lista = new ArrayList<EPessoa>();

        try {
            String sql = "SELECT * FROM pessoa";
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                EPessoa pessoa = new EPessoa();

                pessoa.setCodPessoa(rs.getInt("codigoPessoa"));
                pessoa.setNomePessoa(rs.getString("nomePessoa"));

                lista.add(pessoa);
            }

        }catch (SQLException e){

        }
        return lista;
    }

}
