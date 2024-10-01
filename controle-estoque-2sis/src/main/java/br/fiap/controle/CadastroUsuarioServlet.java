package br.fiap.controle;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.modelo.bean.Perfil;
import br.fiap.modelo.bean.Usuario;
import br.fiap.modelo.dao.UsuarioDAO;
import br.fiap.modelo.util.Util;

/**
 * Servlet implementation class CadastroUsuarioServlet
 */
@WebServlet("/cadastroUsuario")
public class CadastroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Usuario usuario = new Usuario();
		Perfil perfilUsuario = new Perfil();
		UsuarioDAO dao = new UsuarioDAO();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String perfil = request.getParameter("perfil");
		
		// obtem o salt para codificiar a senha 
		byte [] salt = Util.getSalt();
		
		// obtem a senha codificada
		
		String senhaCodificada = Util.codificar(senha, salt);
		
		// atribui os valores para os objetos 
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setSalt(Base64.getEncoder().encodeToString(salt));
		perfilUsuario.setPerfil(perfil);
		usuario.setPerfil(perfilUsuario);
		dao.cadastrar(usuario);
		
		
		// redireciona
		
		response.sendRedirect("index.html");
		
		
	}

}
