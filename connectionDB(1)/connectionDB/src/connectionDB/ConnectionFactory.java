package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private final String SCHEMA = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

	public Connection conectar() {
		try {
			return DriverManager.getConnection(SCHEMA, "RM97935", "120704");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar");
			throw new RuntimeException(e);
		}
	}
}
