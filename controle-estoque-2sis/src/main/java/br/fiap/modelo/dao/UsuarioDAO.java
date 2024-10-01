package br.fiap.modelo.dao;

import java.sql.SQLException;

import br.fiap.modelo.bean.Perfil;
import br.fiap.modelo.bean.Usuario;
import br.fiap.modelo.connection.ConnectionFactory;

public class UsuarioDAO extends DAO {

	public UsuarioDAO() {
		this.connection = ConnectionFactory.getInstance().getConnection();
	}

	public Usuario autenticar(String email, String senha) {
		Usuario usuario = null;
		Perfil perfil = null;

		sql = "select u.nome, p.nome as perfil from java_usuario u "
				+ "join java_usuario_perfil up on u.id_usuario = up.id_usuario "
				+ "join java_perfil p on up.id_perfil = p.id_perfil " + "where email = ? and senha = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			if (rs.next()) {
				perfil = new Perfil();
				usuario = new Usuario();
				perfil.setPerfil(rs.getString("perfil"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPerfil(perfil);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	public void cadastrar(Usuario usuario) {
		
		//desativar o commit automatico
		
		int idUsuario = 0;
		int idPerfil = 0;
		
		try {
			connection.setAutoCommit(false);
			sql = "insert into java_usuario values( sequence_usuario.NEXTVAL , ?, ?, ?, ?, ? ";
			ps = connection.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, 1);
			ps.setString(5, usuario.getSalt());
			ps.execute();
			
			
			sql = "select sequence_usuario.CURRVAL FROM dual";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(); 
			if (rs.next() ) {
				idUsuario = rs.getInt(1);
			}
			
			// select para recuperar o ID do perfil do usuario;
			
			sql = "select id_perfil from java_perfil where nome = ?" ;
			ps = connection.prepareStatement(sql);
			ps.setString(1, usuario.getPerfil().getPerfil());
			rs = ps.executeQuery();
			if (rs.next()) {
				idPerfil = rs.getInt(1);
		
			}
			
			// inserção na tabela associativa 
			
			
			sql = "insert into java_usuario_perfil values (?, ?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idUsuario);
			ps.setInt(2, idPerfil);
			ps.execute();
			
			
			connection.commit();
			
			
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}
		
	}

}
