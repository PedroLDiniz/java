

// objeto jogador, responsavel por armazenar nome, vitoria e escolhas
public class Jogador {
	
	// private para encapsulamento de objeto
	
	private String nome;
	private int vitorias;
	private int escolha;
	 
		// metodo construtor jogador para instancia o nome e qtd de vitorias
	
	public Jogador(String nome) {
		this.nome = nome;
		this.vitorias = 0;
		
	}
	
	// getters and setters para acessar o objeto
	public void setEscolha(int escolha) {
		this.escolha = escolha;
	}
	public int getEscolha() {
		return escolha;
	}
	 public void contarVitorias() {
	        vitorias++;
	    }

	    public int getVitorias() {
	        return vitorias;
	    }

	    public String getNome() {
	        return nome;
	    }
	

}