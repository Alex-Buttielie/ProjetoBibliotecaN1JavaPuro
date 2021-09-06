package controller;

import model.business.BLivro;
import model.entity.ELivro;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;




@WebServlet(name = "LivroController", urlPatterns = {"/LivroController"})
public class LivroController extends HttpServlet {

    private final BLivro bLivro;
    private static final String MANTER = "/manterLivro.jsp";
    private static final String LISTAR = "/listarLivro.jsp";
    private static final String EMPRESTAR = "/emprestarLivro.jsp";

    public LivroController (){
        super();
        bLivro = new BLivro();

    }

   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String avancar = "";
        String acao = request.getParameter("acao");

        if(acao.equalsIgnoreCase("alterar")){

            avancar = MANTER;
            int codigo = Integer.parseInt(request.getParameter("codigoLivro"));
            ELivro livro = bLivro.consultar(codigo);
            request.setAttribute("livro", livro);


        }else if(acao.equalsIgnoreCase("excluir")){

            avancar = LISTAR;
            int codigo = Integer.parseInt(request.getParameter("codigoLivro"));
            bLivro.excluir(codigo);
            request.setAttribute("livros", bLivro.listar());

        }else if(acao.equalsIgnoreCase("emprestar")){

            avancar = EMPRESTAR;
            int codigo = Integer.parseInt(request.getParameter("codigoLivro"));
            ELivro livro = bLivro.consultar(codigo);
            request.setAttribute("livro", livro);

        }else if(acao.equalsIgnoreCase("listar")){

            avancar = LISTAR;
            request.setAttribute("livros", bLivro.listar());
        }else{
            avancar = MANTER;
        }

        RequestDispatcher view = request.getRequestDispatcher(avancar);
        view.forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ELivro eLivro = new ELivro();
        eLivro.setNomeLivro(request.getParameter("nome"));
        eLivro.setDataPublicacao(Date.valueOf(request.getParameter("quantidade")));

        String codigo = request.getParameter("codigo");


        if(codigo != null && !codigo.isEmpty()){
            eLivro.setCodigoLivro(Integer.parseInt(codigo));
        }else if(codigo.equals(""))
            eLivro.setCodigoLivro(0);

        try{
            bLivro.salvar(eLivro);
        }catch (Exception e){
            
        }

        RequestDispatcher view  = request.getRequestDispatcher(LISTAR);
        request.setAttribute("livros", bLivro.listar());
        view.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
