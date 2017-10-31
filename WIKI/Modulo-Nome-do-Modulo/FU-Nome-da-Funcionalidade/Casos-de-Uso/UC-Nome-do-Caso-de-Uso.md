![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)

[Home](../../../ReadMe.md) ::  [Módulo Nome-do-Módulo](../../Modulo-Nome-do-Modulo.md) :: [FU-Nome da Funcionaldade](../FU-Nome-da-Funcionalidade.md) :: [UC-Nome do Caso de Uso](UC-Nome-do-Caso-de-Uso.md)


<div style="color:green">
  Template da página de documentação de **Caso de Uso**.  Os textos de instruções estão em verde e devem ser removidos do artefato final, inclusive as tags `div`. Nos demais pontos substituir `nome-do-caso-de-uso` pelo nome real do caso de uso.

  Os links para diagramas levam aos respectivos templates
  Nota: O nome do caso de uso deve ser um verbo no infinitivo.

  Casos de uso podem referenciar outros através dos relacionamentos de extensão, inclusão e herança. Segue abaixo o padrão para documentação destes relacionamentos:

    - Herança: Deve ser representada no diagrama de casos de uso da funcionalidade
    - Inclusão ou Extensão: O relacionamento deve ser representado no diagrama de casos de uso da funcionalidade e o ponto de inclusão / extensão (link) deve ser colocado no passo do caso de uso "chamador". Ex: Operador de Caixa Informa os dados de pagamento através de [UC-Informar Dados Pagamento]
</div>


# Caso de Uso: nome-do-caso-de-uso

| **[UC]**                | nome-do-caso-de-uso                                                                                                                    |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------------------|
| **Objetivo**            | <div style="color:green"> Descrição do objetivo do caso de uso </div>                                                                  |
| **Ator Principal**      | <div style="color:green"> Papel do Ator Principal do caso de uso. A quem interessa o objetivo do mesmo </div>                         |
| **Atores Secundários**  | <div style="color:green"> Lista opcional (separada por vírgulas) dos Atores Secundários </div>                                          |
| **Fluxo Principal**     | [PR: Nome do Fluxo Principal](#pr-nome-do-fluxo-principal) <div style="color:green"> Link para o único fluxo principal </div>          |
| **Fluxos Alternativos** | [AL01: Nome do Fluxo Alternativo 1](#al01-nome-do-fluxo-alternativo) <div style="color:green"> Link para o fluxo alternativo 01 </div> |
|                         | [AL02: Nome do Fluxo Alternativo 2](#al02-nome-do-fluxo-alternativo) <div style="color:green"> Link para o fluxo alternativo 02 </div> |
| **Fluxos de Exceção**   | [EX01: Nome do FLuxo de Exceção 1](#ex01-nome-do-fluxo-de-exce-o) <div style="color:green"> Link para o fluxo de exceção 01 </div>  |
|                         | [EX02: Nome do FLuxo de Exceção 2](#ex02-nome-do-fluxo-de-exce-o) <div style="color:green"> Link para o fluxo de exceção 02 </div>  |

## PR: Nome do Fluxo Principal

<div style="color:green">
  O caso de uso deverá ter sempre um e apenas um fluxo principal, o qual deve corresponder e levar ao objetivo principal do caso de uso.
  O fluxo principal deve estar em `heading-2`
  Passos da iteração do fluxo principal em lista numerada:   </div>

1. **Ator XYZ** ação do Ator XYZ <div style="color:green">Todo passo deve se iniciar com o nome do ator, em **negrito** </div>
2. **Sistema** ação do sistema <div style="color:green">O sistema também é considerado um ator</div>
3. **Ator XYZ** ação do Ator XYZ com opção de seguir fluxo alternativo [[AL01](#al01-nome-do-fluxo-alternativo)] <div style="color:green"> Pontos de acesso a fluxos alternativos devem ser referenciados entre colchetes, com link para o mesmo </div>
4. **Sistema** ação do sistema relacionada com uma RN, cf: [RN Nome da Regra de Negocios](../Regras-de-Negocios/RN-Nome-da-Regra-de-Negocios.md) <div style="color:green"> Referências a regras de negócios devem ser declaradas com o prefixo "RN", nome e link para a mesma </div>
5. **Ator XYZ** ação do Ator XYZ que pode levar a exceção [[EX01](#ex01-nome-do-fluxo-de-exce-o)] <div style="color:green"> Passos que possam levar a fluxos de execeção devem ser referenciados entre colchetes, com link para o mesmo </div>
6. **Ator XYZ** realiza tal ação através do caso de uso incluído/extendido [[UC-Nome do Caso de Uso](UC-Nome-do-Caso-de-Uso.md)] <div style="color:green"> Passos que representam pontos de inclusão ou extensão devem ser referenciados entre colchetes, com link para o caso de uso relacionado. </div>

## Fluxos Alternativos

<div style="color:green">
  Lista dos fluxos alternativos.  O caso de uso poderá ter zero ou vários fluxos alternativos.

  Os fluxos alternativos deve estar em `heading-3`
  Lembrando que: Todos os fluxos alternativos são fluxos de sucesso, os fluxos de erro devem ser documentados como fluxos de exceção.
</div>

### AL01: Nome do Fluxo Alternativo

<div style="color:green">
    Descrição da condição que leva a execução deste fluxo alternativo 01
    Ex: Fluxo executado quando o **Operador Cadastro** informa o CPF do cliente além do nome

    Passos da iteração do fluxo alternativo 01, em lista numerada: </div>

1. **Ator XYZ** ação do Ator XYZ
2. **Sistema** ação do sistema

### AL02: Nome do Fluxo Alternativo

## Fluxos de Exceção

<div style="color:green">
  Lista dos fluxos de exceção. O caso de uso poderá ter zero ou vários fluxos de exceção.

  Lembrando que: Todos os fluxos de exceção são sempre fluxos de falha, que não levam ao sucesso.
  Os fluxos alternativos deve estar em `heading-3`

  Devem ser documentadas as execeções causadas pelo ator, ou por situações que o ator conheça e possa atuar. Não devem ser documentadas no caso de uso as exceções estritamente técnicas (por exemplo, exceção ao não conectar com base de dados)
</div>

### EX01: Nome do Fluxo de Exceção

<div style="color:green">
    Descrição da condição que leva a esta exceção
    Ex: Fluxo executado quando o CPF informado não está válido segundo regra ABC...

    Passos da iteração do fluxo de exceção 01, em lista numerada.   </div>

1. **Ator XYZ** ação do Ator XYZ
2. **Sistema** ação do sistema

### EX02: Nome do Fluxo de Exceção

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
