![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Conta-Corrente](../FU-Conta-Corrente.md) :: [WS-Atualizar Conta-Corrente](WS-Atualizar-Conta-Corrente.md)


# WebService: Atualizar Conta-Corrente

## Descrição

Cálculo dos totais de lançamentos por tipo e consolidação na tabela de `ContaCorrente` conforme: [RN Conta-Corrente](../Regras-de-Negocios/RN-Conta-Corrente.md)

## Header

**NOTA AO DESENVOLVEDOR:** Coloque aqui a lista de atributos do header, sua obrigatoriedade e valores válidos

| Atributo                          | Obrigatório | Observações                          |
|-----------------------------------|:-----------:|--------------------------------------|
| Nome do Atributo (case sensitive) |     S/N     | Descrição do campo e valores válidos |


## Atributos do Serviço

**NOTA AO DESENVOLVEDOR:** Coloque aqui a lista de atributos da chamada ao WS, sua obrigatoriedade e valores válidos

| Atributo                          | Obrigatório | Observações                          |
|-----------------------------------|:-----------:|--------------------------------------|
| Nome do Atributo (case sensitive) |     S/N     | Descrição do campo e valores válidos |


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
