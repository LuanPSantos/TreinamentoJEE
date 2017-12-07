![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Lançamento Contas Mensais](../FU-Lancamento-Contas-Mensais.md) :: [WS-Incluir Lancamento Conta Mensal](WS-Incluir-Lancamento-Conta-Mensal.md)


# WebService: Alterar Lançamento Conta Mensal

## Descrição

Alteração de lançamentos de conta mensal.

## Header

**NOTA AO DESENVOLVEDOR:** Coloque aqui a lista de atributos do header, sua obrigatoriedade e valores válidos

| Atributo                          | Obrigatório | Observações                          |
|-----------------------------------|:-----------:|--------------------------------------|
| Content-Type |     S     | Informa o formado do objeto enviado na requisição |


## Atributos do Serviço

**NOTA AO DESENVOLVEDOR:** Coloque aqui a lista de atributos da chamada ao WS, sua obrigatoriedade e valores válidos

| Atributo                          | Obrigatório | Observações                          |
|-----------------------------------|:-----------:|--------------------------------------|
| description |    S     | Informa a descrição de um Lançamento (Cadeia de caracteres) |
| type |     S     | Tipo do Lançamento [EntryType](../Regras-de-Negocios/RN-Tipo-de-Lancamento.md) |
| date |     S     | Data do Lançamento (yyyy-MM-dd) |
| value |     S     | Valor do Lançamento (Double)|


## Demais Validações

**NOTA AO DESENVOLVEDOR:** Coloque aqui alguma regra de validação mais especifica (que não seja apenas validação de obrigatoridade de campos)


## XML Request

**NOTA AO DESENVOLVEDOR:** Coloque aqui o XML de request padrão

~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Header/>
   <soapenv:Body>
   </soapenv:Body>
</soapenv:Envelope>
~~~

## Response

**NOTA AO DESENVOLVEDOR:** Coloque aqui o XML de response padrão

~~~xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
   </soap:Body>
</soap:Envelope>
~~~

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
