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
- Em URL altere **«database/path?»** pelo caminho do banco de dados, recomendo que seja:  
**{{Seu diretório até}}/HelloEJB/Database/database**
- Utilize **root** como user e password  
Apartir de agora você já pode acessar o banco de dados da aplicação através da ferramenta Admin do HSQLDB.

#### Configurando o DataSource
**No Glassfish 5**  
Com o Glassfish rodando entre no seu painel de administração através de [localhost:4848](localhost:4848). Vá até a aba JDBC e clique em **JDBC Connection Pools** para criar um novo pool de conexões.  
- Click em **new**
- Dê um nome ao pool (ex: exemploPool)
- Em **Resource Type** selecione **javax.sql.DataSource**, que é o tipo usado nesse projeto.
- Em **Driver Vendor** utilize **HSQLDB**
- Clique em next para ir para a parte dois
- Em **Datasource Classname** utilize **org.hsqldb.jdbc.JDBCDataSource** que é a classe que implementa o DataSource
- Em **Additional Properties** utilize apenas 3: **user**, **password** e **Url**. Onde *user* e *password* serão **root**, pois criamos o banco com estes dados. Passe o caminho completo do banco em *Url*, inclusive com o trexo:  
**jdbc:hsqldb:file:** + {{Seu diretório até}}/HelloEJB/Database/database.  
Note que **database** é o nome do banco de dados!  
- Feito isso o DataSource está configurado. Agora é preciso criar o **Resource**, que também se encontra na aba JDBC
- Entre em **JDBC Resources**
- Clique em **new**
- Dê um nome ao seu resource que siga o padrão **jdbc/NomeDoResourceDS** pois estamos criando um Resource JDBC de um DataSource. Ele será usado para realizar lookup do CDI
- Em **Pool Name** selecione o pool criado anteriormente
- Clique em **OK** para finalizar. Apartir de agora o DataSource está pronto para o uso dentro da aplicação.  

**No WildFly**
