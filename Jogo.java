package ecosdotemplo;

import java.util.ArrayList;
import java.util.List;

/* Module and purpose: coordinates turn order, movement, effects, victory and restart; independent of console I/O.
 */
public class Jogo {
    private final List<Jogador> jogadores;
    private final Tabuleiro tabuleiro;
    private int jogadorAtual;
    private boolean terminado;
    private Jogador vencedor;

    public Jogo(String nome1, String nome2) {
        jogadores = new ArrayList<>(List.of(new Jogador(nome1), new Jogador(nome2)));
        tabuleiro = new Tabuleiro();
    }

    public ResultadoJogada jogar(int valorDado) {
        if (terminado) throw new IllegalStateException("O jogo já terminou.");
        if (valorDado < 1 || valorDado > 6) throw new IllegalArgumentException("O dado deve estar entre 1 e 6.");

        Jogador jogador = jogadores.get(jogadorAtual);
        int origem = jogador.getPosicao();
        int tentativa = origem + valorDado;
        boolean ultrapassou = tentativa > tabuleiro.getTamanho();
        int aterragem = ultrapassou ? origem : tentativa;
        jogador.moverPara(aterragem);

        boolean efeito = false;
        int destino = aterragem;
        if (!ultrapassou && tabuleiro.temEfeito(aterragem)) {
            destino = tabuleiro.aplicarEfeito(aterragem);
            jogador.moverPara(destino);
            efeito = true;
        }

        boolean venceu = destino == tabuleiro.getTamanho();
        if (venceu) {
            terminado = true;
            vencedor = jogador;
        } else {
            jogadorAtual = (jogadorAtual + 1) % jogadores.size();
        }
        return new ResultadoJogada(jogador, valorDado, origem, aterragem, destino,
                ultrapassou, efeito, venceu);
    }

    public void reiniciar() {
        jogadores.forEach(Jogador::reiniciar);
        jogadorAtual = 0;
        terminado = false;
        vencedor = null;
    }

    public List<Jogador> getJogadores() { return List.copyOf(jogadores); }
    public Jogador getJogadorAtual() { return jogadores.get(jogadorAtual); }
    public boolean isTerminado() { return terminado; }
    public Jogador getVencedor() { return vencedor; }
    public Tabuleiro getTabuleiro() { return tabuleiro; }
}
