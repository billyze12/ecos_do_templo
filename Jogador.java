package ecosdotemplo;

/* Module and purpose: player entity with encapsulated name and board position.
 */
public class Jogador extends Participante {
    public Jogador(String nome) { this(nome, 1); } // justified constructor overload: default start cell
    public Jogador(String nome, int posicao) { super(nome, posicao); }

    @Override
    public String getTipo() { return "Explorador"; }
}
