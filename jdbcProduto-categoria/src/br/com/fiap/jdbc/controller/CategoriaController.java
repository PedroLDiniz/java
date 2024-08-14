package br.com.fiap.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.jdbc.dao.CategoriaDAO;
import br.com.fiap.jdbc.factory.ConnectionFactory;
import br.com.fiap.jdbc.model.Categoria;

public class CategoriaController {
	
	private CategoriaDAO categoriaDAO;
	
	public CategoriaController() {
		Connection connection = new ConnectionFactory().getConnection();
		categoriaDAO = new CategoriaDAO(connection);
	}
	
	public List<Categoria> listarTodas() throws SQLException{
		return this.categoriaDAO.listarTodas();
	}
	
	public List<Categoria> listarComProduto() throws SQLException{
		return this.categoriaDAO.ListarComProduto();
	}
	
}
