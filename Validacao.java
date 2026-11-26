package ecosdotemplo;

/* Module and purpose: pure parsing/validation helpers for console commands and manual die values.
 */
public final class Validacao {
    private Validacao() { }

    public static boolean eComando(String texto, String comando) {
        return texto != null && texto.trim().equalsIgnoreCase(comando);
    }

    public static int lerDado(String texto) {
        if (texto == null || !texto.trim().matches("[1-6]"))
            throw new IllegalArgumentException("Introduza um número inteiro de 1 a 6.");
        return Integer.parseInt(texto.trim());
    }
}
