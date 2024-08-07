package connectionDB;
import java.sql.Date;
import java.util.List;

public class TestConnection {
	public static void main(String[] args) {
		ClienteDAO dao = new ClienteDAO();
		Date dataNasc = new Date(0);
		Cliente maria = new Cliente("Maria", "123456", "321654", dataNasc);
		dao.insert(maria);
		List<Cliente> listaClientes = dao.selectAll();

		for (Cliente cliente : listaClientes) {
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("Data nascimento: " + cliente.getDataNasc());
			System.out.println("----------------------------------------");
		}
		Cliente cliente = dao.selectById(1);
		System.out.println(cliente.getNome());
		dao.delete(2);
	}
}
