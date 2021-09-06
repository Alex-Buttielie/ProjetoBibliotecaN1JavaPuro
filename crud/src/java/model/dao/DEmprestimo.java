package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.business.BEmprestimo;
import model.entity.EPessoa;
import model.entity.Emprestimo;
import util.Conexao;




public class DEmprestimo {


    private Connection cnn;

    public DEmprestimo() {
        this.cnn = Conexao.getConnection();
    }

    public void incluir(Emprestimo emprestimo) {

        try {
            String sql =  "INSERT INTO emprestimo (dataEmprestimo, codLivroEmprestimo, codPessoaEmprestimo, observacao, isEmprestimoAtivo) VALUES" +
                    " (?, ?, ?, ?, ?)";

            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setDate(1, (Date) emprestimo.getDataEmprestimo());
            prds.setInt(2, emprestimo.getCodLivroEmprestimo());
            prds.setInt(3, emprestimo.getCodPessoaEmprestimo());
            prds.setString(4, emprestimo.getObservacao());
            prds.setBoolean(5, emprestimo.getIsEmprestimoAtivo());
            prds.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void alterar(Emprestimo emprestimo) {

        BEmprestimo bEmprestimo = new BEmprestimo();
        bEmprestimo.validarDevolcaoEmprestimo(emprestimo);
        try {
            String sql="UPDATE emprestimo SET isemprestimoativo = ?"
                    +" WHERE codigoemprestimo = ?;";

            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setBoolean(1, emprestimo.getIsEmprestimoAtivo());
            prds.setInt(2, emprestimo.getCodEmprestimo());
            prds.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void excluir (int codigo){

        try{

            String sql = "DELETE FROM emprestimo WHERE codEmprestimo = ?;";
            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setInt(1, codigo);

            prds.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Emprestimo consultar(int codigo){

        Emprestimo emprestimo = new Emprestimo();

        try {

            String sql = "SELECT * FROM emprestimo  WHERE codigoEmprestimo = ?";
            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setInt(1, codigo);

            ResultSet rs =  prds.executeQuery();

            if(rs.next()){

                emprestimo.setCodEmprestimo(rs.getInt("codigoemprestimo"));
                emprestimo.setDataEmprestimo(rs.getDate("dataemprestimo"));
                emprestimo.setCodLivroEmprestimo(rs.getInt("codlivroemprestimo"));
                emprestimo.setCodPessoaEmprestimo(rs.getInt("codpessoaemprestimo"));
                emprestimo.setIsEmprestimoAtivo(rs.getBoolean("isemprestimoativo"));
                emprestimo.setObservacao(rs.getString("observacao"));
            }

        }catch (SQLException e){

        }
        return emprestimo;
    }

    public List Listar(){

        List <Object> lista = new ArrayList<Object>();

        try {
            String sql = "SELECT \n" +
                    "l.codigolivro, \n" +
                    "l.nomelivro, \n" +
                    "l.datapublicacao, \n" +
                    "e.codigoemprestimo, \n" +
                    "e.dataemprestimo, \n" +
                    "e.isemprestimoativo, \n" +
                    "e.observacao, \n" +
                    "p.codpessoa, \n" +
                    "p.nomepessoa \n" +
                    "from emprestimo e\n" +
                    "inner join pessoa p on e.codpessoaemprestimo  = p.codpessoa \n" +
                    "inner join livro l on e.codlivroemprestimo = l.codigolivro \n" +
                    "order by e.codigoemprestimo asc";

            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                Map<String, Object> emprestimo = new HashMap<String, Object>();

                emprestimo.put("codigoemprestimo",rs.getInt("codigoemprestimo"));
                emprestimo.put("dataemprestimo",rs.getDate("dataemprestimo"));
                emprestimo.put("codigolivro",rs.getInt("codigolivro"));
                emprestimo.put("codpessoa",rs.getInt("codpessoa"));
                emprestimo.put("isemprestimoativo",rs.getBoolean("isemprestimoativo"));
                emprestimo.put("observacao",rs.getString("observacao"));
                emprestimo.put("nomelivro", rs.getString("nomelivro"));
                emprestimo.put("nomepessoa", rs.getString("nomepessoa"));
                emprestimo.put("datapublicacao", rs.getDate("datapublicacao"));

                lista.add(emprestimo);
            }

        }catch (SQLException e){

        }
        return lista;
    }

}
