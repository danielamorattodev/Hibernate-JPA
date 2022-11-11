# :bookmark_tabs: Estudos em JPA com Hibernate

### Projeto de estudo curso Alura.

___

## :point_right: O que vi neste projeto:

* Estudo básico sobre o funcionamento da JPA. Criação de um projeto com Maven adicionando o Hibernate como uma dependência `hibernate-entitymanager`.
Também foi utilizado a dependência do banco de dados em memória com o uso do _H2_.

* Crianção do arquivo `persistence.xml`, entendimento de como funcionam as tags do `persistence-unit`, as propriedades - properties - da JPA e as propriedades específicas do Hibernate. 

* Mapeamento de uma entidade de acordo com a modelagem do banco de dados e a usar anotações, como o `@Entity, @Table, @Id, @GeneratedValue`.

* Como funciona o ciclo de vida das entidades, os estados, as transições de estados, e também como fazer para trabalhar com a persistência de fato das entidades utilizando o EntityManager.

* Criação da classe **JPAUtil** para isolar a criação do `EntityManagerFactory` e do `createEntityManager()` em si.

* Criação das classes **DAO**, por exemplo, ProdutoDao, e isolamento de todo o acesso à API do EntityManager da JPA. (No caso, o código fica bem enxuto, os métodos ficam bem pequenos, diferente de projetos com JDBC puro.

* Como fazer querys utilizando o **JPQL** e os principais recursos da JPA, como _salvar, excluir e atualizar um registro_.

