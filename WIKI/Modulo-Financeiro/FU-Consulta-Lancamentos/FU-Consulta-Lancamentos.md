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

| Regra de Negócios                                                       | Descrição                                           |
|-------------------------------------------------------------------------|-----------------------------------------------------|
| [RN-Critérios de busca](Regras-de-Negocios/RN-Criterios-de-Buscas.md)   | Descreve os parâmetros para as buscas de Lançamentos|

## Casos de Uso

**NOTA AO DESENVOLVEDOR:** No momento, este projeto não possui interfaces gráficas com interação entre atores e sistema. Sendo assim, ainda não possui casos de uso especificados.

## Web Services

**[WADL](Web-Services/WADL.md)**

| Web Service                                                          | Descrição                                   |
|----------------------------------------------------------------------|---------------------------------------------|
| [WS-Pesquisar Lancamentos](Web-Services/WS-Pesquisar-Lancamentos.md) | Pesquisa de lançamentos                     |


## Estrutura de Classes

**NOTA AO DESENVOLVEDOR:** Coloque aqui as classes relacionadas a funcionalidade, ordenadas alfabeticamente de A->Z pelo nome da classe

| Pacote                     | Classe       | Descrição                               |
|----------------------------|--------------|-----------------------------------------|
| com.luan.myfin.financeiro.web.resources | EntryResource | Expõe os serviços REST relacionados aos Lançamentos |
| com.luan.myfin.financeiro.base.interfaces | EntryService | Contrato dos serviços de Lançamentos |
| com.luan.myfin.financeiro.ejb.services | EntryServiceBean | Implementação dos serviços de Lançamentos |
| com.luan.myfin.financeiro.ejb.daos | EntryDAO | Camada de persistência |
| com.luan.myfin.financeiro.base.models | Entry | Entidade que representa o Lançamento |

**NOTA AO DESENVOLVEDOR:** Preencha o diagrama abaixo com especificação das classes da funcionalidade e seus relacionamentos. Devem ser informados todos os elementos da classe: seus atributos e métodos publicos, privados e estáticos. Bem como seus relacionamentos com outras classes.

_Diagrama UML: [UML-Classes-Consulta-Lancamentos.asta](FU-Consulta-Lancamentos-Anexos/UML-Classes-Consulta-Lancamentos.asta)_

## Estrutura de Entidades

**NOTA AO DESENVOLVEDOR:** É fornecida abaixo a especificação da entidades, atributos e seus relacionamentos, não sendo necessário evolução pelo desenvolvedor.

| Banco/Schema   | Entidade         | Descrição                                               |
|----------------|------------------|---------------------------------------------------------|
| sistema/public | Entry | Despesas Mensais Lançadas                               |
| sistema/public | EntryType   | Normalização dos Tipo de Lançamento para Contas Mensais |

_Diagrama DER: [DER-Consulta-Lancamentos.asta](FU-Consulta-Lancamentos-Anexos/DER-Consulta-Lancamentos.asta)_

## Diagramas Técnicos Opcionais

**NOTA AO DESENVOLVEDOR:** Se o desenv entender como necessário, pode sem criados diagramas técnicos especificando algum comportamento ou característica da funcionaldiade

| Diagrama           | Descrição             |
|--------------------|-----------------------|
| Link-para-Diagrama | Descrição do diagrama |

## Cenários de Teste Manuais

**NOTA AO DESENVOLVEDOR:** No momento, este projeto não possui interfaces gráficas com interação entre atores e sistema. Sendo assim, ainda não possui cenários de teste manuais.

## Cenários de Testes Automatizados

**NOTA**

| Classe de Teste     | Método de Teste    |Descrição         |
|---------------------|--------------------|------------------|
| CL-EntryResourceIntegrationTest | it_should_gets_all_entries | testa a busca de todas os Lançamentos |
| CL-EntryResourceIntegrationTest | it_should_insert_entry | testa a inserção de um Lançamentos |
| CL-EntryResourceIntegrationTest | it_should_filters_by_description | testa a buscar de Lançamentos filtrando pela descrição |
| CL-EntryResourceIntegrationTest | it_should_filters_by_type | testa a busca de Lançamentos filtrando pelo tipo |
| CL-EntryResourceIntegrationTest | it_should_gets_entrys_until_the_final_period | testa a busca de Lançamentos do início até a data especificada |
| CL-EntryResourceIntegrationTest | it_should_gets_entrys_starting_from_the_initial_period | testa a de busca Lançamentos a partir da data especificada |
| CL-EntryResourceIntegrationTest | it_should_delete_an_entry_by_id | testa a remoção de um Lançamento |
| CL-EntryResourceIntegrationTest | it_should_gets_an_entry_by_id | testa a busca de um Lançamento |

_[Sobre o Portal de Documentação](../../About/About.md)_


![Rodape](../../ReadMe-Anexos/Rodape.png)
