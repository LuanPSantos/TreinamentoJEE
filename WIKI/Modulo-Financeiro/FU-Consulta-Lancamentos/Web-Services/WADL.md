
![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Consulta Lançamentos](../FU-Consulta-Lancamentos/FU-Consulta-Lancamentos.md) :: [WADL](WADL.md)


# WSDL da Funcionalidade: Consulta Lançamentos

**NOTA AO DESENVOLVEDOR:** Coloque aqui o WSDL dos serviços da funcionalidade:

~~~xml

<definitions name="HelloService"
   targetNamespace="http://www.examples.com/wsdl/HelloService.wsdl"
   xmlns="http://schemas.xmlsoap.org/wsdl/">

   <message name="SayHelloRequest">
      <part name="firstName" type="xsd:string"/>
   </message>

   <portType name="Hello_PortType">
      <operation name="sayHello">
         <input message="tns:SayHelloRequest"/>
         <output message="tns:SayHelloResponse"/>
      </operation>
   </portType>

   <service name="Hello_Service">
   </service>
</definitions>

~~~


_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
