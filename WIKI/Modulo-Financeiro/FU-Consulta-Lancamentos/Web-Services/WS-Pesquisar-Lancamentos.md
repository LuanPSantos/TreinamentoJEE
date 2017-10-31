![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Consulta Lançamentos](../FU-Consulta-Lancamentos.md) :: [WS-Pesquisar Lancamentos por Nome](WS-Pesquisar-Lancamentos-Por-Nome.md)


# WebService: Pesquisar Lancamentos por Nome

## Descrição

Pesquisa de lançamentos usando os parâmetros passados por URL, de acordo com a [RN-Criterios-de-Buscas](../Regras-de-Negocios/RN-Criterios-de-Buscas.md)

## Header

**NOTA AO DESENVOLVEDOR:** Coloque aqui a lista de atributos do header, sua obrigatoriedade e valores válidos

| Atributo                          | Obrigatório | Observações                          |
|-----------------------------------|:-----------:|--------------------------------------|
| N.H. |     N.H.     | N.H. |


## Atributos do Serviço

**NOTA AO DESENVOLVEDOR:** Coloque aqui a lista de atributos da chamada ao WS, sua obrigatoriedade e valores válidos

| Atributo                          | Obrigatório | Observações                                                                           |
|-----------------------------------|:-----------:|---------------------------------------------------------------------------------------|
| type                              |      N      | Recebe como valores válidos a String que representa o item do enum EntryType          |
| initialPeriod                     |      N      | Formato (dd/MM/yyyy)                                                                  |
| finalPeriod                       |      N      | Formato (dd/MM/yyyy)                                                                  |
| description                       |      N      | String que representa o nome ou parte dele de um lançamento                           |

## Demais Validações

**NOTA AO DESENVOLVEDOR:** Coloque aqui alguma regra de validação mais especifica (que não seja apenas validação de obrigatoridade de campos)



## JSON Request

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
