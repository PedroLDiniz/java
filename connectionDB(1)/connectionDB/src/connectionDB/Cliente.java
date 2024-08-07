package connectionDB;

import java.sql.Date;

//Javabean
public class Cliente {

	// atributos
	private int idCliente;
	private String cpf;
	private String nome;
	private String telefone;
	private Date dataNasc;

	//constructors
	public Cliente() {

	}

	public Cliente(String nome, String cpf, String telefone, Date dataNasc) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
	}

	//getters / setters
	public int getId() {
		return idCliente;
	}

	public void setId(int id) {
		this.idCliente = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

}
