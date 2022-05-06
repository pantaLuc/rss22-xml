<p align="center">
  <a href="#" target="blank"><img src="https://findvectorlogo.com/wp-content/uploads/2019/09/universite-de-rouen-normandie-vector-logo.png" width="200" alt="AdCoin Logo" /></a>
</p>

  <p align="center"> <a href="#" target="_blank">Projet : Service REST & Client </a> for   Langage Web.</p>

## Manuel d' installation

[Luc Perin Panta - XML ](https://github.com/pantaLuc/rss22-xml) Ce Repertoire contient tout  les elements necessaire pour deployer le projet XML..

## Installation De la Base donnee

```bash
#Executer la commande suivante pour lancer la BD
$ docker-compose up

```

#Ajouter Les Configurations 

```bash
# Dans applications.properties pour vous connectez a base local
spring.h2.console.enabled=true 
spring.datasource.url=jdbc:postgresql://localhost:5432/rss22xml
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create    
spring.jpa.open-in-view=false
```

##Lancez l' application 
```bash
# Executez 
$ $ mvn spring-boot:run
```

