![Cabecalho](../../ReadMe-Anexos/Cabecalho.png)

[Home](../../ReadMe.md) :: [Módulo Financeiro](../Modulo-Financeiro.md) :: [FU-Conta Corrente](FU-Conta-Corrente.md)


# Funcionalidade: Conta Corrente

## Descrição

Consolida os totais de despesas lançadas por tipo de lançamento.

## Funcionalidades Impactadas

| Funcionalidade | Descrição |
|----------------|-----------|
| N.H.           | N.H.      |

## Regras de Negócios

| Regra de Negócios                                                                             | Descrição                                                  |
|-----------------------------------------------------------------------------------------------|------------------------------------------------------------|
| [RN Conta Corrente](Regras-de-Negocios/RN-Conta-Corrente.md) | Especificação da Conta-Corrente como consolidação de Lançamentos Mensais por Tipo de Lançamento |

## Casos de Uso

**NOTA AO DESENVOLVEDOR:** No momento, este projeto não possui interfaces gráficas com interação entre atores e sistema. Sendo assim, ainda não possui casos de uso especificados.

## Web Services

**[WSDL](Web-Services/WSDL.md)**

| Web Service                                                                | Descrição                                                          |
|----------------------------------------------------------------------------|--------------------------------------------------------------------|
| [WS-Atualizar Conta-Corrente](Web-Services/WS-Atualizar-Conta-Corrente.md) | Calcula a consolidação dos lançamentos e atualiza a conta-corrente |
| [WS-Obter Conta-Corrente](Web-Services/WS-Obter-Conta-Corrente.md)         | Obtém os valores da conta corrente por tipo de lançamento          |

## Estrutura de Classes

**NOTA AO DESENVOLVEDOR:** Coloque aqui as classes relacionadas a funcionalidade, ordenadas alfabeticamente de A->Z pelo nome da classe

| Pacote                     | Classe          | Descrição                               |
|----------------------------|-----------------|-----------------------------------------|
| caminho.completo.do.pacote | CL-NomeDaClasse | Descrição sucinta do objetivo da classe |

**NOTA AO DESENVOLVEDOR:** Preencha o diagrama abaixo com especificação das classes da funcionalidade e seus relacionamentos. Devem ser informados todos os elementos da classe: seus atributos e métodos publicos, privados e estáticos. Bem como seus relacionamentos com outras classes.

_Diagrama UML: [UML-Classes-Conta-Corrente.asta](FU-Conta-Corrente-Anexos/UML-Classes-Conta-Corrente.asta)_

## Estrutura de Entidades

**NOTA AO DESENVOLVEDOR:** É fornecida abaixo a especificação da entidades, atributos e seus relacionamentos, não sendo necessário evolução pelo desenvolvedor.

| Operação | Banco/Schema   | Entidade       | Descrição                                               |
|:--------:|----------------|----------------|---------------------------------------------------------|
|   ISU    | sistema/public | TB-ContaCorrente  | Totais de Despesas Mensais Consolidadas por Tipo        |
|    S     | sistema/public | TB-TipoLancamento | Normalização dos Tipo de Lançamento para Contas Mensais |

\* _Operações:_ (I)nsert, (S)elect, (U)pdate, (D)elete

_Diagrama DER: [DER-Consulta-Lancamentos.asta](FU-Conta-Corrente-Anexos/DER-Conta-Corrente.asta)_

## Diagramas Técnicos Opcionais

**NOTA AO DESENVOLVEDOR:** Se o desenv entender como necessário, pode sem criados diagramas técnicos especificando algum comportamento ou característica da funcionaldiade

| Diagrama           | Descrição             |
|--------------------|-----------------------|
| Link-para-Diagrama | Descrição do diagrama |

## Cenários de Teste Manuais

**NOTA AO DESENVOLVEDOR:** No momento, este projeto não possui interfaces gráficas com interação entre atores e sistema. Sendo assim, ainda não possui cenários de teste manuais.

_[Sobre o Portal de Documentação](../../About/About.md)_


![Rodape](../../ReadMe-Anexos/Rodape.png)
