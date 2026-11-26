package ecosdotemplo;

import java.util.Map;

/* Module and purpose: board dimensions and special-cell destination rules.
 */
public class Tabuleiro {
    private final int tamanho;
    private final Map<Integer, Integer> efeitos;

    public Tabuleiro() {
        tamanho = 30;
        efeitos = Map.of(4, 8, 9, 5, 13, 18, 20, 14, 24, 28, 27, 22);
    }

    public int getTamanho() { return tamanho; }
    public boolean temEfeito(int casa) { return efeitos.containsKey(casa); }
    public int aplicarEfeito(int casa) { return efeitos.getOrDefault(casa, casa); }
    public Map<Integer, Integer> getEfeitos() { return efeitos; }
}
