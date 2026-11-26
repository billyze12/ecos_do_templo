# Ecos do Templo — checkpoint de novembro
UAL · POO · 2026–2027 · Java 17 · aplicação de consola

## Estado
Versão jogável para dois jogadores, com lançamento aleatório ou manual, efeitos de avanço/retorno, validação, desistência e reinício. O modelo não depende da consola.

## Regras
- Tabuleiro com 30 casas; ambos começam na casa 1.
- Jogadores alternam turnos, começando pelo Jogador 1.
- Cada jogada usa um valor de 1 a 6.
- Para vencer é necessário chegar exatamente à casa 30. Se o movimento ultrapassar 30, o jogador fica onde estava.
- As casas partilhadas são permitidas.
- Efeitos aplicam-se uma única vez quando o jogador termina numa casa especial; a casa de destino não desencadeia outro efeito (sem encadeamento).
- Casas especiais: 4→8, 9→5, 13→18, 20→14, 24→28, 27→22.
- A casa 30 é terminal. O jogo termina imediatamente quando um jogador lá chega.
- `Q` permite desistir; `R` permite reiniciar. Entradas inválidas não alteram o estado do jogo.

## Requisitos
JDK 17 ou superior.

## Compilar
A partir da raiz:
```bash
mkdir -p out
javac -encoding UTF-8 -d out src/main/java/ecosdotemplo/*.java
```

## Executar
```bash
java -cp out ecosdotemplo.AplicacaoConsola
```

## Executar verificações automáticas
```bash
javac -encoding UTF-8 -d out src/main/java/ecosdotemplo/*.java src/test/java/ecosdotemplo/*.java
java -cp out ecosdotemplo.TestesJogo
```
Os testes são determinísticos e não precisam de bibliotecas externas.

## Estrutura
- `Jogador`, `Tabuleiro`, `Jogo`: modelo e regras.
- `FonteDado`, `DadoManual`, `DadoAleatorio`: estratégia de lançamento (interface/polimorfismo).
- `AplicacaoConsola`: entrada/saída; não contém regras de movimento.
- `TestesJogo`: verificações repetíveis.

## Autoria
Carlos Denzel - 30016690
Eric Braga - 30010210
