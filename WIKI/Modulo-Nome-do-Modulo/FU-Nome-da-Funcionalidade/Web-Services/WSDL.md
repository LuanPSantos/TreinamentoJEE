![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Nome-do-Módulo](../../Modulo-Nome-do-Modulo.md) :: [FU-Nome da Funcionaldade](../FU-Nome-da-Funcionalidade.md) :: [WSDL](../WSDL.md)


<div style="color:green">
  Template da página de documentação do WSDL dos Web-Services da funcionalidade.  Os textos de instruções estão em verde e devem ser removidos do artefato final, inclusive as tags `div`.
  Os links para diagramas levam aos respectivos templates
</div><br>

# WSDL

<div style="color:green"> WSDL coletado da ferramenta de desenvolvimento </div><br>

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
