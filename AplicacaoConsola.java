package ecosdotemplo;

import java.util.Scanner;

public class AplicacaoConsola {
    private final Scanner scanner;

    public AplicacaoConsola(Scanner scanner) { this.scanner = scanner; }

    public static void main(String[] args) {
        new AplicacaoConsola(new Scanner(System.in)).executar();
    }

    public void executar() {
        System.out.println("=== ECOS DO TEMPLO ===");
        System.out.print("Nome do Explorador 1: ");
        String n1 = scanner.nextLine().trim();
        System.out.print("Nome do Explorador 2: ");
        String n2 = scanner.nextLine().trim();
        if (n1.isBlank()) n1 = "Explorador 1";
        if (n2.isBlank()) n2 = "Explorador 2";
        Jogo jogo = new Jogo(n1, n2);

        boolean aleatorio;
        while (true) {
            System.out.print("Dado manual (M) ou aleatório (A)? ");
            String modo = scanner.nextLine().trim();
            if (Validacao.eComando(modo, "M")) { aleatorio = false; break; }
            if (Validacao.eComando(modo, "A")) { aleatorio = true; break; }
            System.out.println("Opção inválida.");
        }
        FonteDado dado = aleatorio ? new DadoAleatorio() : new DadoManual();
        jogarAteTerminar(jogo, dado, aleatorio);
    }

    private void jogarAteTerminar(Jogo jogo, FonteDado dado, boolean aleatorio) {
        while (!jogo.isTerminado()) {
            mostrarPosicoes(jogo);
            System.out.print("Vez de " + jogo.getJogadorAtual().getNome()
                    + ". Introduza 1-6, R reiniciar ou Q sair: ");
            String entrada = scanner.nextLine().trim();
            if (Validacao.eComando(entrada, "Q")) {
                System.out.println("Jogo terminado por desistência.");
                return;
            }
            if (Validacao.eComando(entrada, "R")) {
                jogo.reiniciar();
                System.out.println("Jogo reiniciado.");
                continue;
            }

            try {
                int valor;
                if (aleatorio) {
                    valor = dado.lancar();
                    System.out.println("Resultado aleatório: " + valor);
                } else {
                    valor = Validacao.lerDado(entrada);
                    ((DadoManual) dado).definirValor(valor);
                    valor = dado.lancar();
                }
                apresentar(jogo.jogar(valor));
            } catch (IllegalArgumentException ex) {
                System.out.println("Entrada inválida: " + ex.getMessage() + " Estado inalterado.");
            }
        }
        System.out.println("VITÓRIA: " + jogo.getVencedor().getNome() + " chegou à casa 30!");
    }

    private void apresentar(ResultadoJogada r) {
        System.out.println(r.jogador().getNome() + " lançou " + r.dado() + ".");
        if (r.ultrapassou()) {
            System.out.println("Ultrapassaria a casa 30: fica na casa " + r.origem() + ".");
        } else {
            System.out.println("Movimento: " + r.origem() + " -> " + r.casaAterragem() + ".");
            if (r.teveEfeito()) System.out.println("Efeito especial: " + r.casaAterragem() + " -> " + r.destinoFinal() + ".");
        }
        System.out.println("Posições: " + r.jogador().getNome() + ": " + r.jogador().getPosicao());
    }

    private void mostrarPosicoes(Jogo jogo) {
        System.out.print("Posições: ");
        for (int i = 0; i < jogo.getJogadores().size(); i++) {
            Jogador j = jogo.getJogadores().get(i);
            System.out.print(j.getNome() + ": " + j.getPosicao());
            if (i < jogo.getJogadores().size() - 1) System.out.print(" | ");
        }
        System.out.println();
    }
}
