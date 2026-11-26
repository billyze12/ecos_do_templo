package ecosdotemplo;

/* Module and purpose: abstract common participant type; provides shared identity and position contract.
 */
public abstract class Participante {
    private final String nome;
    private int posicao;

    protected Participante(String nome, int posicao) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome obrigatório.");
        if (posicao < 1 || posicao > 30) throw new IllegalArgumentException("Posição inválida.");
        this.nome = nome;
        this.posicao = posicao;
    }

    public String getNome() { return nome; }
    public int getPosicao() { return posicao; }
    public void moverPara(int novaPosicao) {
        if (novaPosicao < 1 || novaPosicao > 30) throw new IllegalArgumentException("Posição fora do tabuleiro.");
        posicao = novaPosicao;
    }
    public void reiniciar() { posicao = 1; }
    public abstract String getTipo();
}
