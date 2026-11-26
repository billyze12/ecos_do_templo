package ecosdotemplo;

/* Module and purpose: stores a validated manual die value for the next turn.
 * Student name/number and implemented contributions: [NOME/N.º A] — [confirm].
 * Collaborator/reviewer and contribution: [NOME/N.º B] — [confirm].
 * AI assistance: ChatGPT; implementation support, see AI_USE.md.
 */
public class DadoManual implements FonteDado {
    private int valor;

    public void definirValor(int valor) {
        if (valor < 1 || valor > 6) throw new IllegalArgumentException("O dado deve estar entre 1 e 6.");
        this.valor = valor;
    }

    @Override
    public int lancar() {
        if (valor < 1 || valor > 6) throw new IllegalStateException("Defina um valor válido antes de lançar.");
        return valor;
    }
}
