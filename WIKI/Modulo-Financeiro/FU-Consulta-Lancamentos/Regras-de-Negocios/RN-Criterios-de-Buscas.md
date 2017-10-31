![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Consulta-Lancamentos](../FU-Consulta-Lancamentos.md) :: [RN Critérios de Busca](RN-Criterios-de-Buscas.md)


# Regra de Negócios: Critérios de Buscas

É possível combinar os parêmtros para fazer buscas ainda mais personalizadas, como por exemplo: buscar todos lançamentos desde 10/07/2017 cujo o nome contenha "luz".

| Query Parâmetros| Obrigatório | Descrição/Valores Válidos                                                             |
|-----------------|:-----------:|---------------------------------------------------------------------------------------|
| type            |      N      | Recebe como valores válidos a String que representa o item do enum EntryType          |
| initialPeriod   |      N      | Data limite mínima para a busca de lançamentos no formato (dd/MM/yyyy)                |
| finalPeriod     |      N      | Data limite máxima para a busca de lançamentos no formato (dd/MM/yyyy)                |
| description     |      N      | String que representa o nome ou parte dele de um lançamento                           |

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
