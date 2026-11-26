# Regras e mapa — Ecos do Templo

## Tema
Dois exploradores atravessam um templo antigo para alcançar a câmara central do tesouro.

## Tabuleiro
30 casas numeradas em percurso serpenteante. Início na casa 1; objetivo na casa 30.

| Casa | Tipo | Efeito |
|---:|---|---|
| 1–3 | Normal | Nenhum |
| 4 | Avanço | Vai para 8 |
| 5–8 | Normal | Nenhum |
| 9 | Retorno | Vai para 5 |
| 10–12 | Normal | Nenhum |
| 13 | Avanço | Vai para 18 |
| 14–19 | Normal | Nenhum |
| 20 | Retorno | Vai para 14 |
| 21–23 | Normal | Nenhum |
| 24 | Avanço | Vai para 28 |
| 25–26 | Normal | Nenhum |
| 27 | Retorno | Vai para 22 |
| 28–29 | Normal | Nenhum |
| 30 | Final | Vitória |

## Regras operacionais
- Dois jogadores; turnos alternados, jogador 1 primeiro.
- Dado manual ou aleatório, ambos com valores de 1 a 6.
- A posição é limitada ao intervalo 1–30.
- Exceder 30 não move o peão (não há ressalto).
- É permitido partilhar uma casa.
- Só se aplica o efeito da casa onde o peão aterra inicialmente; não há encadeamento.
- A vitória ocorre ao chegar exatamente à casa 30. O jogo termina logo após a jogada.
- `Q` desiste e termina; `R` reinicia posições, turno e estado, mantendo o modo de dado.
- Entrada inválida é rejeitada antes de alterar o modelo.

## Representação
| Conceito do jogo | Consola | Modelo | Mockup |
|---|---|---|---|
| Posição dos peões | Linha `P1: 12 | P2: 18` e marcadores no mapa | `List<Jogador>` com `posicao` encapsulada; por exemplo `(22, 24)` | Dois peões com cores/símbolos distintos |
| Casa especial | Mensagem `Casa 13: avanço para 18` | `Map<Integer,Integer>` no `Tabuleiro` | Casa com ícone/realce |
| Turno | `Vez de Explorador 1` | índice `jogadorAtual` em `Jogo` | Indicação visual do jogador ativo |
| Vitória | Mensagem de vencedor | estado `terminado` e `vencedor` | Câmara do tesouro na casa 30 |
| Dado | Resultado textual | `FonteDado` e implementações manual/aleatória | Dado ilustrado |

## Limitações conhecidas
A versão é uma aplicação de consola; não contém interface gráfica. O mockup é uma representação artística, não uma interface funcional. Os efeitos não encadeiam por decisão de design.
