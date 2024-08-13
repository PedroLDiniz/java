import java.util.Scanner;
	// objeto jogo, armazena as informações sobre os jogadores, empate e qtd de partidas
public class Jogo {
	private Jogador jogador;
    private Jogador ia;
    private Scanner teclado;
    private int totalEmpates;
    private int partidas;

    // instanciando os objetos de jogador e ia
    public Jogo() {
        teclado = new Scanner(System.in);
        jogador = new Jogador("Jogador");
        ia = new Jogador("IA");
    }

    public void iniciar() {
        System.out.println("Bem vindo ao Jokenpo");
        System.out.println("As regras do Jokenpo são: pedra vence tesoura, tesoura vence papel, e papel vence pedra.");
        // metodo para escolher a quantidade de partidas sendo elas 1 3 ou 5 partidas
        selecionarModoJogo();
        // loop para escolha de pedra papel ou tesoura
        for (int i = 0; i < partidas; i++) {
            System.out.println();
            System.out.println("Escolha um valor entre 1, 2 e 3, sendo respectivamente:");
            System.out.println("Pedra = 1");
            System.out.println("Papel = 2");
            System.out.println("Tesoura = 3");
            // jogador digita sua escolha
            int escolhaJogador = teclado.nextInt();

            if (escolhaJogador < 1 || escolhaJogador > 3) {
                System.out.println("Escolha inválida, tente com outro valor.");
                i--; // Não conta essa rodada como válida
                continue;
            }
            // a escolha do jogador é definida na escolha
            jogador.setEscolha(escolhaJogador);
            
            
            Partida partida = new Partida(jogador, ia);
            partida.jogar();
            totalEmpates += partida.getEmpate();
        }

        mostrarResultados();
    }
    
    	// jogador escolhe o modo de jogo que ele quer 
    private void selecionarModoJogo() {
        System.out.println("Escolha o modo de jogo:");
        System.out.println("Digite 1 para 1 partida:");
        System.out.println("Digite 2 para melhor de 3 partidas:");
        System.out.println("Digite 3 para melhor de 5 partidas:");
        // sua escolha é armazenada na variavel modo
        int modo = teclado.nextInt();
        // de acordo com a escolha da variavel modo, a variavel partida pode receber os valores 1,3 ou 5.
        if (modo == 1) {
            partidas = 1;
        } else if (modo == 2) {
            partidas = 3;
        } else if (modo == 3) {
            partidas = 5;
            
            // caso o valor seja diferente desses citados anteriormente o modo é invalido
        } else {
            System.out.println("Modo inválido.");
            System.exit(0);
        }
    }
    	// metodo utilizado para mostrar as estatisticas das partidas
    private void mostrarResultados() {
        System.out.println("\nResultados finais:");
        // casting para calcular porcentagem ja que int não é usado para valores decimais, somente para inteiros
        System.out.println("Vitórias do " + jogador.getNome() + ": " + (jogador.getVitorias() / (double) partidas) * 100 + "%");
        System.out.println("Vitórias da " + ia.getNome() + ": " + (ia.getVitorias() / (double) partidas) * 100 + "%");
        System.out.println("Empates: " + (totalEmpates / (double) partidas) * 100 + "%");
        // validação para saber quem foi o vencedor do jogo
        if (jogador.getVitorias() > ia.getVitorias()) {
            System.out.println(jogador.getNome() + " venceu o jogo!");
        } else if (ia.getVitorias() > jogador.getVitorias()) {
            System.out.println(ia.getNome() + " venceu o jogo!");
        } else {
            System.out.println("O jogo terminou empatado!");
        }
    }

}
