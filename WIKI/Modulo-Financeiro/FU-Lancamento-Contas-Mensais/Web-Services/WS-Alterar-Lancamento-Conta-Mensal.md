![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Lançamento Contas Mensais](../FU-Lancamento-Contas-Mensais.md) :: [WS-Incluir Lancamento Conta Mensal](WS-Incluir-Lancamento-Conta-Mensal.md)


# WebService: Alterar Lançamento Conta Mensal

## Descrição

Alteração de lançamentos de conta mensal.

## Método e URL
**PUT**: http://localhost:8080/myfin/webapi/entry/<id>

## Header

| Atributo                          | Obrigatório | Observações                          |
|-----------------------------------|:-----------:|--------------------------------------|
| Content-Type |     S     | application/json |


## Atributos do Serviço

| Atributo                          | Obrigatório | Observações                          |
|-----------------------------------|:-----------:|--------------------------------------|
| description | S | String genérica |
| entryDate | S | Dada do pacote java.sql |
| entryValue | S | Double com valor máximo 100000000 e mínimo de 0 |
| entryType | S | EntryType com um atributo String value |

## Demais Validações

EntryType.value valores válidos:
 - ALIMENTACAO
 - MORADIA
 - EDUCACAO
 - TRANSPORTE
 - SAUDE
 - LAZER
 - OUTROS

## JSON Request

~~~json
{
    "description": "Teste 2",
    "entryDate": "2018-03-12",
    "entryValue": 1,
    "entryType": {
    	"value": "ALIMENTACAO"
    }
}
~~~

## Response

~~~json
{
    "id": 1,
    "description": "Teste 2",
    "entryDate": "2018-03-12",
    "entryValue": 1,
    "entryType": {
        "value": "ALIMENTACAO"
    }
}
~~~

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
