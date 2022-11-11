package br.com.alura.modelo;

//Esta é uma entidade JPA. Uma classe que faz o mapeamento de uma tabela do banco de dados, funciona como um espelho de uma tabela no banco de dados

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="produtos") //No caso, o nome da entidade está diferente da tabela do BD. Essa linha é para a JPA entender isso e fazer a conversão.
public class Produto {
    @Id //para a JPA entender que essa é a chave primária no BD.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para dizer que o valor é gerado pelo BD e qual o seu tipo. A estragégia vai depender do BD utilizado.
    private Long id;
    private String nome;
    private String descricao; /*Caso hipotéticamente este campo fosse diferente na tabela do BD, usaria-se em cima desta linha,
    a tag @Column(name="nome da coluna no BD) importada na JPA. */
    private BigDecimal preco;

    private LocalDate dataCadastro = LocalDate.now();

    @ManyToOne
    private Categoria categoria;

    public Produto() {
    }

    public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Long getId() {return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }



}
