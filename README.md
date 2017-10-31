# Treinamento JEE + SQL
**Menu**  
- [wiki](WIKI/ReadMe.md)
## Setup do banco de dados (HSQLDB)
Faça download do HSQLDB pelo [site oficial](http://hsqldb.org/), descompacte o arquivo e navegue até o diretório lib caso você esteja usando Linux. 
Para criar um novo banco de dados standalone utilize o comando:
```
java -jar hsqldb.jar
```
Ele abrirá uma janela de configuração.  
- Em type selecione **HSQL Database Engine Standalone**  
- Em URL altere **«database/path?»** pelo caminho do banco de dados que está no projeto:  
**{{Seu diretório até}}/HelloEJB/Database/database**
- Utilize **root** como user e password  
Apartir de agora você já pode acessar o banco de dados da aplicação através da ferramenta Admin do HSQLDB.

#### Configurando o DataSource
**No Glassfish**

**No WildFly**
