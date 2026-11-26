package ecosdotemplo;

/* Module and purpose: immutable result of one accepted turn for console feedback and tests.
 */
public record ResultadoJogada(Jogador jogador, int dado, int origem, int casaAterragem,
                              int destinoFinal, boolean ultrapassou, boolean teveEfeito,
                              boolean venceu) { }
