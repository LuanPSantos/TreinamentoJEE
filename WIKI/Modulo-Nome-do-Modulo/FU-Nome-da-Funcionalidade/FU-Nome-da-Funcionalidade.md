![Cabecalho](../../ReadMe-Anexos/Cabecalho.png)

[Home](../../ReadMe.md) :: [Módulo Nome-do-Módulo](../Modulo-Nome-do-Modulo.md) :: [FU-Nome da Funcionaldade](FU-Nome-da-Funcionalidade.md)

<div style="color:green">
  Template da página de documentação de funcionalidade de software.  Os textos de instruções estão em verde e devem ser removidos do artefato final, inclusive as tags `div`.
  Os links para diagramas levam aos respectivos templates
</div>

# Funcionalidade: nome-da-funcionalidade

## Descrição

<div style="color:green">Descrição completa da Funcionalidade com seu objetivo, suas principais características, etc. Opcionalmente utilize sub-títulos de níveis 2, 3, etc, para organizar o conteúdo conforme for necessário.</div>

## Funcionalidades Impactadas

<div style="color:green">Tabela das Funcionalidades Impactadas por esta. Ordenadas alfabeticamente de A->Z.
Coloque aqui as funcionalidades que possuem relação de dependencia com a funcionalidade desta página, ou seja, funcionalidades nas quais pode ser necessária qualquer adequação em virtude de modificação nesta.
Podem existir funcionalidades impactadas de módulos diferentes, externos à funcionalidade sendo documentada. Estas devem ser incluídas na tabela de funcionalidades impactadas da página da funcionalidade.
Note que estas não devem ser incluídas no diagrama de funcionalidades do módulo, pois não são do módulo em questão.
</div>

| Módulo                                       | Funcionalidade                                                                                                       | Descrição                                                                      |
|----------------------------------------------|----------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------|
| [Nome-do-módulo](Link-para-pagina-do-modulo) | [FU-Nome da Funcionalidade Relacionada](FU-Nome-da-Funcionalidade-Relacionada/FU-Nome-da-Funcionalidade-Relacionada.md) | <div style="color:green">Descrição sucinta da Funcionalidade Relacionada</div> |

## Regras de Negócios

<div style="color:green">Tabela das Regras de Negócios da Funcionalidade, ordenada alfabeticamente de A->Z.

<b>Nota sobre documentação de parâmetros:</b>

Parâmetros que definem ou alteram o comportamento da aplicação, ou como são processados e efetuados cálculos devem ser documentados como Regra de negócios nas páginas de Funcionalidades. Neste caso, deve ser criada uma RN, nomeada, por exemplo: Parâmetros Funcionalidade ABC.. com a lista de parâmetros que esta funcionalidade precisa para operar, seu significado e valores válidos.

Parâmetros estritamente técnicos, como exemplo (i) parâmetros de conexão com base de dados, (ii) parâmetros de autenticação com web-services, (iii) pastas de gravação de arquivos, etc, devem ser documentados na seção de How-to Técnicos
</div>

| Regra de Negócios                                                               | Descrição                                                             |
|---------------------------------------------------------------------------------|-----------------------------------------------------------------------|
| [RN-Nome da Regra de Negócios](Regras-de-Negocios/RN-Nome-da-Regra-de-Negocios.md) | <div style="color:green">Descrição sucinta da Regra de Negócios</div> |

## Casos de Uso

<div style="color:green">Tabela dos Casos de Uso da Funcionalidade, ordenada alfabeticamente de A->Z. </div>

| Caso de Uso                                                                | Descrição                                                  |
|----------------------------------------------------------------------------|------------------------------------------------------------|
| [UC-Nome do Caso de Uso](Casos-de-Uso/UC-Nome-do-Caso-de-Uso.md) | <div style="color:green">Descrição sucinta do caso de uso</div>         |

<div style="color:green">Link para o diagrama de casos de uso da funcionalidade:</div>

_Diagrama UML: [UML-UC-Nome-da-Funcionalidade.asta](FU-Nome-da-Funcionalidade-Anexos/UML-UC-Nome-da-Funcionalidade.asta)_

## Web Services

<div style="color:green">Seção opcional para documentar o WSDL e os Web-Services da funcionalidade. </div>

**WSDL:** [Link-Para-pagina-com-WSDL](Web-Services/WSDL.md)


| Web Service                                                    | Descrição                                               |
|----------------------------------------------------------------|---------------------------------------------------------|
| [WS-Nome do WebService](Web-Services/WS-Nome-do-WebService.md) | <div style="color:green">Descrição do Web Service</div> |


## Estrutura de Classes

<div style="color:green">
Tabela das classes relacionadas a funcionalidade, ordenada alfabeticamente de A->Z pelo nome da classe
Deverão ser incluídas todas as classes que implementam esta funcionalidade, mesmo que a classe seja compartilhada com outra(s) funcionalidade(s)

</div>

| Pacote                     | Classe       | Descrição                                                              |
|----------------------------|--------------|------------------------------------------------------------------------|
| caminho.completo.do.pacote | CL-NomeDaClasse | <div style="color:green">Descrição sucinta do objetivo da classe</div> |

<div style="color:green">Link para o diagrama de classes da funcionalidade:

No diagrama de classes, as classes compartilhadas por várias funcionalidades devem ser replicadas em todas elas. Lembrando que é uma boa prática que as funcionalidades sejam coesas e fracamente acopladas. Cada funcionalidade (salvo exceções) deve ser implementada por classes de apresentação, GUI e modelo próprias e não compartilhadas por muitas funcionalidades gerando alto acoplamento.



</div>

_Diagrama UML: [UML-Classes-Nome-da-Funcionalidade.asta](FU-Nome-da-Funcionalidade-Anexos/UML-Classes-Nome-da-Funcionalidade.asta)_

## Estrutura de Entidades

<div style="color:green">
Tabela das entidades relacionadas a funcionalidade, ordenada alfabeticamente de A->Z pelo nome da tabela
Deverão ser incluídas todas as entidades acessadas por esta funcionalidade, mesmo que a entidade também seja acessada por outra(s) funcionalidade(s). Situação que deve ser evitada no bom design.

A coluna Operação deve ser preenchida com as operações que a funcionalidade executa na tabela (para uma análise de impacto mais acurada):

I: Insert
S: Select
U: Update
D: Delete

</div>

| Operação | Banco/Schema                 | Entidade          | Descrição                                                              |
|:--------:|------------------------------|-------------------|------------------------------------------------------------------------|
|   ISUD   | nome-do-banco/nome-do-schema | TB-Nome-da-Tabela | <div style="color:green">Descrição sucinta do objetivo da tabela</div> |

\* _Operações:_ (I)nsert, (S)elect, (U)pdate, (D)elete

<div style="color:green">Link para o diagrama de entidades e relacionamentos da funcioanalidade:
No DER, as tabelas compartilhadas por várias funcionalidades devem ser replicadas em todas elas. Lembrando que é uma boa prática que as funcionalidades sejam coesas e fracamente acopladas. Cada funcionalidade (salvo exceções) persistir e manter suas informações isolada das demais, compartilhando as informações com outras funcionalidades através de métodos e objetos.
</div>

_Diagrama DER: [DER-Nome-da-Funcionalidade.asta](FU-Nome-da-Funcionalidade-Anexos/DER-Nome-da-Funcionalidade.asta)_


## Diagramas Técnicos Opcionais

<div style="color:green">
  Seção **opcional** com diagramas técnicos que descrevam alguma característica complexa da **FUNCIONALIDADE**
  Podem ser, por exemplo:  diagramas comportamentais do tipo Atividades, Sequencia ou Estado que descrevam algum processo ou interação complexa, ou a transição de estados de algum elemento importante do sistema
  Deve se atentar sempre que o **escopo** destes diagramas é a **FUNCINALIDADE**
  A tabela deve ser ordenada alfabeticamente de A->Z pelo nome do diagrama
</div><br>

| Diagrama                                                                                                                      | Descrição                                                                                                                |
|-------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| [UML-Atividades-Processo-Integracao-XYZ.asta](FU-Nome-da-Funcionalidade-Anexos/UML-Atividades-Processo-Integracao-XYZ.asta)   | <div style="color:green"> Descrição suscinta do processo descrito no diagrama </div>                                     |
| [UML-Sequencia-Processo-Comunicacao-XPTO.asta](FU-Nome-da-Funcionalidade-Anexos/UML-Sequencia-Processo-Comunicacao-XPTO.asta) | <div style="color:green"> Descrição suscinta da iteração descrita no diagrama </div>                                     |
| [UML-Estado-Status-ABC.asta](FU-Nome-da-Funcionalidade-Anexos/UML-Estado-Status-ABC.asta)                                     | <div style="color:green"> Descrição suscinta do elemento cuja transição de estado está sendo elucidada no diagrama </div> |

## Cenários de Teste Manuais

<div style="color:green"> Tabela com os cenários de testes manuais da funcionalidade, ordenados alfabeticamente de A->Z pelo nome cenário de teste </div><br>

| Cenário de Teste                                                     | Descrição                                                                  |
|----------------------------------------------------------------------|----------------------------------------------------------------------------|
| [CT-Nome do Cenário](Cenarios-de-Teste/TC-Nome-do-Cenario-de-Testes.md) | <div style="color:green"> Descrição do cenário (o quê será testado) </div> |

## Cenários de Teste Automatizados

<div style="color:green"> Tabela com os cenários de testes automatizados da funcionalidade, ordenados alfabeticamente de A->Z pelo nome da classe de testes </div><br>

| Classe de Teste        | Método de Teste         | Descrição                                                                |
|------------------------|-------------------------|--------------------------------------------------------------------------|
| CL-NomeDaClasseDeTeste | Nome do método de teste | <div style="color:green">Descrição do cenário (o quê será testado)</div> |


_[Sobre o Portal de Documentação](../../About/About.md)_


![Rodape](../../ReadMe-Anexos/Rodape.png)
