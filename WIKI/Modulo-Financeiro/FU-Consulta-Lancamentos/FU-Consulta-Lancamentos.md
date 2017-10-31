![Cabecalho](../../ReadMe-Anexos/Cabecalho.png)

[Home](../../ReadMe.md) :: [Módulo Financeiro](../Modulo-Financeiro.md) :: [FU-Consulta Lançamentos](FU-Consulta-Lancamentos.md)


# Funcionalidade: Consulta Lançamentos

## Descrição

Consulta de Lançamento de Contas Mensais.

## Funcionalidades Impactadas

| Funcionalidade | Descrição |
|----------------|-----------|
| N.H.           | N.H.      |

## Regras de Negócios

| Regra de Negócios | Descrição |
|-------------------|-----------|
| N.H.              | N.H.      |

## Casos de Uso

**NOTA AO DESENVOLVEDOR:** No momento, este projeto não possui interfaces gráficas com interação entre atores e sistema. Sendo assim, ainda não possui casos de uso especificados.

## Web Services

**[WSDL](Web-Services/WSDL.md)**

| Web Service                                                                              | Descrição                                      |
|------------------------------------------------------------------------------------------|------------------------------------------------|
| [WS-Pesquisar Lancamentos por Período](Web-Services/WS-Pesquisar-Lancamentos-Por-Periodo.md) | Pesquisa de lançamentos por período de tempo (dia/mês/ano) |
| [WS-Pesquisar Lancamentos por Nome](Web-Services/WS-Pesquisar-Lancamentos-Por-Nome.md) | Pesquisa de lançamentos por parte do nome do lançamento |
| [WS-Pesquisar Lancamentos por Tipo](Web-Services/WS-Pesquisar-Lancamentos-Por-Tipo.md) | Pesquisa de lançamentos por tipo de lançamento |


## Estrutura de Classes

**NOTA AO DESENVOLVEDOR:** Coloque aqui as classes relacionadas a funcionalidade, ordenadas alfabeticamente de A->Z pelo nome da classe

| Pacote                     | Classe       | Descrição                               |
|----------------------------|--------------|-----------------------------------------|
| caminho.completo.do.pacote | NomeDaClasse | Descrição sucinta do objetivo da classe |

**NOTA AO DESENVOLVEDOR:** Preencha o diagrama abaixo com especificação das classes da funcionalidade e seus relacionamentos. Devem ser informados todos os elementos da classe: seus atributos e métodos publicos, privados e estáticos. Bem como seus relacionamentos com outras classes.

_Diagrama UML: [UML-Classes-Consulta-Lancamentos.asta](FU-Consulta-Lancamentos-Anexos/UML-Classes-Consulta-Lancamentos.asta)_

## Estrutura de Entidades

**NOTA AO DESENVOLVEDOR:** É fornecida abaixo a especificação da entidades, atributos e seus relacionamentos, não sendo necessário evolução pelo desenvolvedor.

| Banco/Schema   | Entidade         | Descrição                                               |
|----------------|------------------|---------------------------------------------------------|
| sistema/public | LancamentoMensal | Despesas Mensais Lançadas                               |
| sistema/public | TipoLancamento   | Normalização dos Tipo de Lançamento para Contas Mensais |

_Diagrama DER: [DER-Consulta-Lancamentos.asta](FU-Consulta-Lancamentos-Anexos/DER-Consulta-Lancamentos.asta)_

## Diagramas Técnicos Opcionais

**NOTA AO DESENVOLVEDOR:** Se o desenv entender como necessário, pode sem criados diagramas técnicos especificando algum comportamento ou característica da funcionaldiade

| Diagrama           | Descrição             |
|--------------------|-----------------------|
| Link-para-Diagrama | Descrição do diagrama |

## Cenários de Teste Manuais

**NOTA AO DESENVOLVEDOR:** No momento, este projeto não possui interfaces gráficas com interação entre atores e sistema. Sendo assim, ainda não possui cenários de teste manuais.

_[Sobre o Portal de Documentação](../../About/About.md)_


![Rodape](../../ReadMe-Anexos/Rodape.png)
