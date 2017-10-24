
![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [Log Rastreamento Contas](../FU-Log-Rastreamento-Contas.md) :: [WSDL](WSDL.md)


# WSDL da Funcionalidade: Log Rastreamento Contas

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
