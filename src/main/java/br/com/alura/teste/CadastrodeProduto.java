package br.com.alura.teste;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class CadastrodeProduto {
    //criando um produto no BD;
    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());

        List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        todos.forEach(p2 -> System.out.println(p.getNome()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
        System.out.println("Preco do Produto: " +precoDoProduto);
    }

    public static void cadastrarProduto(){
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi","Melhor que Iphone",new BigDecimal("800"), celulares);

        //inserindo o objeto celular e fazendo o insert na tabela de "produtos":

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin(); //para startar a operação.

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit(); //para ao fim da transação comitar no BD.
        em.close();

        /* PS: Na JPA existe uma interface que faz a ligação do Java com o banco de dados,que é uma interface chamada EntityManager.
        Essa classe funciona como se fosse o gerente, o "manager" das entidades.
        Toda vez que acessar o banco de dados, seja para salvar, excluir, atualizar, carregar, fazer um select, ou qualquer outra operação no BD com a JPA,
        utiliza-se a interface EntityManager.

        Na JPA, não se cria manualmente o EntityManager. Assim, existe uma factory de EntityManager.
        Para criar o EntityManager, precisamos do EntityManagerFactory, ele tem o método que faz a construção do EntityManager.

        Nós temos uma variável EntityManagerFactory e a chamamos de factory. Outra classe foi criada na JPA e se chama Persistence,
        e ela tem um método estático chamado CreateEntityManagerFactory.Então, basta chamar Persistence.createEntityManagerFactory().

        O método CreateEntityManagerFactory está esperando um parâmetro que é uma String.
        Essa String é o nome do persistence-unit, utilizado no arquivo persistence.xml do projeto.
        Se tivéssemos vários BD's na aplicação, teríamos várias tags persistence-unit, cada uma com um name distinto, e, na hora de criar a factory,
        passaríamos qual é o persistence-unit. Desta maneira, a JPA fica sabendo com qual banco ela deve se conectar. Portanto,
        neste caso, foi adicionado o nome do persistence-unit como "loja". */





    }
}
