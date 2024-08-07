package connectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD Cliente
public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {
		this.connection = new ConnectionFactory().conectar();
	}

	// inserir
	public void insert(Cliente cliente) {
		String sql = "insert into cliente (nome, cpf, telefone, dataNasc) values (?, ?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getTelefone());
			stmt.setDate(4, cliente.getDataNasc());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// buscar todos
	public List<Cliente> selectAll() {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			String sql = "select * from cliente";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("idCliente"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setDataNasc(rs.getDate("dataNasc"));
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	// buscar um cliente
	public Cliente selectById(int id) {
		Cliente cliente = null;
		try {
			String sql = "select * from cliente where idCliente = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getInt("idCliente"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setDataNasc(rs.getDate("dataNasc"));
			}
			rs.close();
			stmt.close();
			return cliente;
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	// alterar
	public void update(Cliente cliente, int id) {
		String sql = "update cliente set nome=?, cpf=?, telefone=?, dataNasc=? where idCliente=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getTelefone());
			stmt.setDate(4, cliente.getDataNasc());
			stmt.setInt(5, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// excluir
	public void delete(int id) {
		try {
			String sql = "delete from cliente where idCliente=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
