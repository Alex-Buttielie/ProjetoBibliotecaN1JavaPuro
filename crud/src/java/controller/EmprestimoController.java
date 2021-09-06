package controller;

import model.business.BEmprestimo;
import model.business.BLivro;
import model.business.BPessoa;
import model.entity.ELivro;
import model.entity.EPessoa;
import model.entity.Emprestimo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;




@WebServlet(name = "EmprestimoController", urlPatterns = {"/EmprestimoController"})
public class EmprestimoController extends HttpServlet {

    private final BEmprestimo bEmprestimo;
    private final BPessoa bPessoa;
    private static final String MANTER = "/manterLivro.jsp";
    private static final String LISTAR = "/listarEmprestimo.jsp";
    private static final String EMPRESTAR = "/emprestarLivro.jsp";

    public EmprestimoController (){
        super();
        bEmprestimo = new BEmprestimo();
        bPessoa = new BPessoa();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String avancar = "";
        String acao = request.getParameter("acao");

        if(acao.equalsIgnoreCase("alterar")){

            avancar = MANTER;
            int codigo = Integer.parseInt(request.getParameter("codigoLivro"));
            Emprestimo emprestimo = bEmprestimo.consultar(codigo);
            request.setAttribute("emprestimo", emprestimo);


        }else if(acao.equalsIgnoreCase("excluir")){

            avancar = LISTAR;
            int codigo = Integer.parseInt(request.getParameter("codEmprestimo"));
            bEmprestimo.excluir(codigo);
            request.setAttribute("emprestimos", bEmprestimo.listar());

        }else if(acao.equalsIgnoreCase("emprestar")){

            avancar = EMPRESTAR;
            int codigo = Integer.parseInt(request.getParameter("codigoLivro"));
            Emprestimo emprestimo = bEmprestimo.consultar(codigo);
            request.setAttribute("emprestimo", emprestimo);

        }else if(acao.equalsIgnoreCase("listar")){

            avancar = LISTAR;
            request.setAttribute("emprestimos", bEmprestimo.listar());
        }else if(acao.equalsIgnoreCase("devolver")){

            avancar = LISTAR;
            int codigo = Integer.parseInt(request.getParameter("codigoemprestimo"));
            Emprestimo emprestimo = bEmprestimo.consultar(codigo);
            emprestimo.setCodEmprestimo(codigo);
           /// request.setAttribute("emprestimo", emprestimo);
            bEmprestimo.devolver(emprestimo);
            request.setAttribute("emprestimos", bEmprestimo.listar());

        }else{
            avancar = MANTER;
        }

        RequestDispatcher view = request.getRequestDispatcher(avancar);
        view.forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Emprestimo emprestimo = new Emprestimo();
        EPessoa pessoa = new EPessoa();

        if(request.getParameter("codPessoaEmprestimo") == null || request.getParameter("codPessoaEmprestimo").equals("")){
            emprestimo.setCodPessoaEmprestimo(null);
        }else{
            emprestimo.setCodPessoaEmprestimo(Integer.parseInt(request.getParameter("codPessoaEmprestimo")));}

        emprestimo.setDataEmprestimo(Date.valueOf(request.getParameter("dataEmprestimo")));
        emprestimo.setObservacao((request.getParameter("observacao")));
        emprestimo.setIsEmprestimoAtivo(true);
        emprestimo.setCodLivroEmprestimo(Integer.parseInt(request.getParameter("codLivroEmprestimo")));
        pessoa.setNomePessoa(request.getParameter("nomePessoa"));
        pessoa = salvarPessoa(pessoa.getNomePessoa());
        emprestimo.setCodPessoaEmprestimo(pessoa.getCodPessoa());
        String codigo = request.getParameter("codEmprestimo");


        if(codigo != null && !codigo.isEmpty()){
            emprestimo.setCodEmprestimo(Integer.parseInt(codigo));
        }else if(codigo.equals(""))
            emprestimo.setCodEmprestimo(null);

        try{
            bEmprestimo.salvar(emprestimo);

        }catch (Exception e){

        }

        RequestDispatcher view  = request.getRequestDispatcher(LISTAR);
        request.setAttribute("emprestimos", bEmprestimo.listar());
        view.forward(request, response);
    }

    private EPessoa salvarPessoa (String nomePessoa){

        EPessoa tabela = new EPessoa();
        tabela.setNomePessoa(nomePessoa);
         bPessoa.salvar(tabela);
        return tabela = bPessoa.consultar(tabela.getNomePessoa());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
