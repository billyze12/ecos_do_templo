package ecosdotemplo;

import java.util.Random;

/* Module and purpose: generates die values from 1 to 6.
 * Student name/number and implemented contributions: [NOME/N.º B] — [confirm].
 * Collaborator/reviewer and contribution: [NOME/N.º A] — [confirm].
 * AI assistance: ChatGPT; implementation support, see AI_USE.md.
 */
public class DadoAleatorio implements FonteDado {
    private final Random random;

    public DadoAleatorio() { this(new Random()); }
    public DadoAleatorio(Random random) { this.random = random; }

    @Override
    public int lancar() {
        return random.nextInt(6) + 1;
    }
}
