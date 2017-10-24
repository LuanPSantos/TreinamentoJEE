![Cabecalho](../../ReadMe-Anexos/Cabecalho.png)

[About](../About.md)

# Nomenclaturas

## Nomenclatura das Pastas de Arquivos de Página wiki

Nome da pasta principal: **Wiki**

Sub-pastas de **Wiki**:

* Arquitetura
* Modulo-_nome-do-modulo_
  - FU-_nome-da-funcionalidade_
    - Regras-de-Negocios
    - Casos-de-Uso
    - Casos-de-Teste
* How-To-Tecnico

## Nomenclatura dos Arquivos (.md) obrigatórios

| PREFIXO     | Nome                        | Artefato                                 |
|-------------|-----------------------------|------------------------------------------|
| **Modulo-** | _nome-do-modulo_            | Página wiki de um Módulo do Software     |
| **FU-**     | _nome-da-funcionalidade_    | Página wiki de uma Funcionalidade        |
| **TC-**     | _nome-do-cenario-de-testes_ | Página wiki de Cenários e Casos de Teste |
| **RN-**     | _nome-da-regra-de-negocios_ | Página wiki de Regras de Negócios        |

O nome do arquivo não pode conter acentuação, cedilha ou qualquer caracter especial.

## Nomenclatura de imagens

As imagens exibidas em qualquer página devem ser representadas com um texto alternativo no formato: `![Texto-Alternativo](IMG-Texto-Alternativo.extensão)`

O arquivo de imagem deve ser gravado na pasta de anexos e deve ser nomeado com o prefixo "IMG" e o mesmo texto alternativo da imagem. Lembrando que este texto será visível no cliente.

Exemplo:
- Referencia: `![Tela-de-Login](IMG-Tela-de-Login.png)`
- Arquivo: `IMG-Tela-de-Login.png`

## Nomenclatura dos Diagramas (.asta)  obrigatórios e opcionais


|   | PREFIXO                  | Nome                          | Artefato                                      | Escopo         |
|---|--------------------------|-------------------------------|-----------------------------------------------|----------------|
| * | **Arquitetura-**         | Sistema.asta                  | Diagrama de Arquitetura do Sistema            | Arquitetura    |
| * | **Arquitetura-**         | Camadas.asta                  | Diagrama de Camadas da Arquitetura            | Arquitetura    |
|   | **Arquitetura-**         | Fluxo-Basico.asta             | Diagrama de Fluxo Básico de Comunicação       | Arquitetura    |
| * | **UML-Arquitetura-**     | Pacotes.asta                  | Diagrama de Pacotes do Software               | Arquitetura    |
|   | **UML-Arquitetura-**     | Deployment.asta               | Diagrama de Empacotamento de Entrega          | Arquitetura    |
| * | **DER-**                 | _nome-do-modulo_.asta         | Diagrama de Entidade-Relacionamento           | Módulo         |
| * | **UML-UC-**              | _nome-do-modulo_.asta         | Diagrama UML de Casos de Uso                  | Módulo         |
| * | **UML-Funcionalidades-** | _nome-do-modulo_.asta         | Diagrama de Relacionamento de Funcionalidades | Módulo         |
| * | **UML-Classes-**         | _nome-da-funcionalidade_.asta | Diagrama UML de Classes                       | Funcionalidade |
|   | **UML-Atividades-**      | _nome-do-processo_.asta       | Diagrama UML de Atividades                    | _Livre_        |
|   | **UML-Sequencia-**       | _nome-da-interacao_.asta      | Diagrama UML de Sequencia                     | _Livre_        |
|   | **UML-Estado-**          | _nome-do-diagrama_.asta       | Diagrama UML de Estados                       | _Livre_        |


\* Diagramas obrigatórios

## Nomenclatura de Elementos

Os elementos de documentação referenciados em qualquer página, seja em tabelas ou no próprio texto, devem ser prefixados conforme a regra abaixo:

| Elemento          | Prefixo | Exemplo                                                                                                                                                    |
|-------------------|---------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Funcionaliade     | **FU-** | [FU-Cadastrar Clientes](../../Modulo-Nome-do-Modulo/FU-Nome-da-Funcionalidade/FU-Nome-da-Funcionalidade.md)                                                |
| Regra de Negócios | **RN-** | [RN-Campos Obrigatórios no Cadastro de Clientes](../../Modulo-Nome-do-Modulo/FU-Nome-da-Funcionalidade/Regras-de-Negocios/RN-Nome-da-Regra-de-Negocios.md) |
| Caso de Uso       | **UC-** | [UC-Nome do Caso de Uso](../../Modulo-Nome-do-Modulo/FU-Nome-da-Funcionalidade/Casos-de-Uso/UC-Nome-do-Caso-de-Uso.md)                                     |
| Web Services      | **WS-** | [WS-Nome do WebService](../../Modulo-Nome-do-Modulo/FU-Nome-da-Funcionalidade/Web-Services/WS-Nome-do-WebService.md)                                       |
| Classe            | **CL-** | CL-CadastroClientesEJB                                                                                                                                     |
| Tabela            | **TB-** | TB-Clientes                                                                                                                                                |
| Cenário de Teste  | **TC-** | [CT-Nome do Cenário](../../Modulo-Nome-do-Modulo/FU-Nome-da-Funcionalidade/Cenarios-de-Teste/TC-Nome-do-Cenario-de-Testes.md)                              |
| Imagens  | **IMG-** | [IMG-Nome do Cenário](../../Modulo-Nome-do-Modulo/FU-Nome-da-Funcionalidade/Cenarios-de-Teste/TC-Nome-do-Cenario-de-Testes.md)                              |


\* No caso se documentos documentados em pagina específica, deverá ser utilizado link para a página no padrão: `[PREFIXO-Nome-do-Elemento](link-de-endereço-relativo)`.


_[Voltar para Documentação do Software](../../ReadMe.md)_


![Rodape](../../ReadMe-Anexos/Rodape.png)
