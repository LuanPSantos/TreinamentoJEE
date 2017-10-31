![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Nome-do-Módulo](../../Modulo-Nome-do-Modulo.md) :: [FU-Nome da Funcionaldade](../FU-Nome-da-Funcionalidade.md) :: [WS Nome do WebService](../WS-Nome-do-WebService.md)


<div style="color:green">
  Template da página de documentação de um web-service.  Os textos de instruções estão em verde e devem ser removidos do artefato final, inclusive as tags `div`.
  Os links para diagramas levam aos respectivos templates
</div></br>

# WebService: Nome-do-Web-Service

## Descrição

<div style="color:green">Descrição do objetivo do Web-service e detalhes do que executa no sistema.</div></br>

## Header

<div style="color:green">Tabela de atributos, obrigatoriedade e valores válidos do header. </div></br>

| Atributo                                                         | Obrigatório | Observações                                                         |
|------------------------------------------------------------------|:-----------:|---------------------------------------------------------------------|
| <div style="color:green">Nome do Atributo (case sensitive)</div> |     S/N     | <div style="color:green">Descrição do campo e valores válidos</div> |


## Atributos do Serviço

<div style="color:green">Tabela de atributos, obrigatoriedade e valores válidos do serviço. </div></br>

| Atributo                                                         | Obrigatório | Observações                                                         |
|------------------------------------------------------------------|:-----------:|---------------------------------------------------------------------|
| <div style="color:green">Nome do Atributo (case sensitive)</div> |     S/N     | <div style="color:green">Descrição do campo e valores válidos</div> |

## Demais Validações

<div style="color:green">Seção opcional para descrever alguma regra de validação mais especifica (que não seja apenas validação de obrigatoridade de campos)</div></br>

## XML Request

<div style="color:green">XML de Request</div></br>

~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Header/>
   <soapenv:Body>
   </soapenv:Body>
</soapenv:Envelope>
~~~


## Response
<div style="color:green">XML de Response</div></br>

~~~xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
   </soap:Body>
</soap:Envelope>
~~~



_[Sobre o Portal de Documentação](../../../About/About.md)_


![Rodape](../../../ReadMe-Anexos/Rodape.png)
