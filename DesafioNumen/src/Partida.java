import java.util.Random;

	//declaração do objeto partida
public class Partida {
	private Jogador jogador;
	private Jogador ia;
	private int empate;
	
	// instanciando o objeto da partida que recebe o jogador e ia
	
	   public Partida(Jogador jogador, Jogador ia) {
	        this.jogador = jogador;
	        this.ia = ia;
	        this.empate = 0;
	    }
	   // metodo que gera um valor aleatorio para IA e define sua escolha
	    public void jogar() {
	        Random random = new Random();
	        int escolhaIA = random.nextInt(3) + 1;
	        ia.setEscolha(escolhaIA);
	        // abaixo é mostrado o numero aleatorio da inteligencia artificial
	        System.out.println(jogador.getNome() + " escolheu: " + opcao(jogador.getEscolha()));
	        System.out.println(ia.getNome() + " escolheu: " + opcao(ia.getEscolha()));
	        // validação para saber se a escolha do jogador e da IA foram iguais, caso verdade é empate
	        if (jogador.getEscolha() == ia.getEscolha()) {
	            System.out.println("Empate!");
	            empate++; 		// a variavel empate recebe uma somatoria pois se consagrou como verdadeira
	            
	            // teste de validação da logica do joken pou
	        } else if ((jogador.getEscolha() == 1 && ia.getEscolha() == 3) ||  // pedra ganha de tesoura
	                   (jogador.getEscolha() == 2 && ia.getEscolha() == 1) || // papel ganha de pedra
	                   (jogador.getEscolha() == 3 && ia.getEscolha() == 2)) {	//tesoura ganha de papel
	            System.out.println(jogador.getNome() + " venceu esta rodada!");
	            jogador.contarVitorias();
	        } else { // ia recebe as vitorias 
	            System.out.println(ia.getNome() + " venceu esta rodada!");
	            ia.contarVitorias();
	        }
	    }

	    public int getEmpate() {
	        return empate;
	    }
	    
	    	// metodo que retorna uma string respectiva podendo ser pedra, papel ou tesoura de acordo com a escolha int
	    public static String opcao(int escolha) {
	        switch (escolha) {
	            case 1:
	                return "Pedra";
	            case 2:
	                return "Papel";
	            case 3:
	                return "Tesoura";
	            default:
	                return "Escolha inválida";
	        }
	    }
	}

