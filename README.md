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
Para utilizar o HSQLDB com o WildFly é necessário alterar o jar do banco para adicionar um novo arquivo com o nome completo da classe do seu Driver.  
- No mesmo diretório do jar cria a seguinte estrutura de diretórios: **META-INF/services/**; dentro do diretório services crie o arquivo **java.sql.Driver** contendo uma única linha, que deve ser o nome completo da classe do Driver do HSQLDB: **org.hsqldb.jdbc.JDBCDriver**.  
- Agora é necessário atualizar o jar do HSQLDB. para isso execute o comando:  
```
jar -uf jdbc-driver.jar META-INF/services/java.sql.Driver
```
**DataSource**  
Para criar o datasource será utilizado o jboss-cli, que é um utilitário que vem junto com o WildFly e fica dentro do diretório bin.  
- Com o WildFly rodando, execute o jboss-cli e digite **connect**.  
- Com o seguinte comando, é criado um novo module:  
```
module add --name=<<nome_module>> --resources=<<caminho/arquivo_do_banco.jar>> --dependencies=javax.api,javax.transaction.api
```
```
module add --name=org.hsqldb --resources=hsqldb.jar --dependencies=javax.api,javax.transaction.api
```
- Agora é necessário criar um Driver:  
```
/subsystem=datasources/jdbc-driver=<<nome_driver>>:add(driver-module-name=<<nome_module>>,driver-name=<<nome_driver>>,driver-class-name=<<nome_classe_driver>>)
```
```
/subsystem=datasources/jdbc-driver=hsqldb:add(driver-module-name=org.hsqldb,driver-name=hsqldb,driver-class-name=org.hsqldb.jdbc.JDBCDriver)
```
- E por fim, para criar o Datasource:
```
/subsystem=datasources/data-source=<<nome_datasource>>:add(jndi-name=<<nome_jndi>>, driver-name=<<nome_driver>>, connection-url=<<caminho_completo_banco>>,user-name=<<usuari>>,password=<<senha>>)
```
```
/subsystem=datasources/data-source=TesteDS:add(jndi-name=java:jboss/datasources/TesteDS, driver-name=hsqldb, connection-url=jdbc:hsqldb:file:/home/luan/Documentos/TreinamentoJEE/TreinamentoJEE/HelloEJB/Database/database,user-name=root,password=root)
```
- **OBS**: é recomendado usar a interface de admin do wildfly para revisar os dados, pois pode ser que as barras (/) não sejam inseridas corretamente. Nesse caso, basta atualizar utilizando o próprio admin.





