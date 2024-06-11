package me.dio.dominio.model;

/**
 * O pacote 'me.dio.dominio.model' é onde esta classe está localizada.
 * Ele organiza as classes relacionadas ao domínio do sistema.
 * Neste caso, o pacote 'model' contém as classes de entidade que representam os dados do sistema.
 */

import jakarta.persistence.*;
/**
 * Importa todas as anotações e classes relacionadas à persistência de dados fornecidas pela especificação JPA (Jakarta Persistence API).
 * Isso inclui anotações como @Entity, @Id, @GeneratedValue, @Column, e outras que são usadas para mapear esta classe para uma tabela no banco de dados.
 */

import jakarta.validation.constraints.NotNull;
/**
 * Importa a anotação @NotNull da especificação Jakarta Validation API.
 * Esta anotação é usada para garantir que um campo específico não seja nulo.
 * É útil para validação de dados antes que eles sejam persistidos no banco de dados.
 */

import jakarta.validation.constraints.Size;
/**
 * Importa a anotação @Size da especificação Jakarta Validation API.
 * Esta anotação é usada para restringir o tamanho de um campo, por exemplo, o número de caracteres em uma string.
 * É útil para garantir que os dados estejam dentro de certos limites antes de serem persistidos.
 */

import jakarta.validation.constraints.DecimalMin;
/**
 * Importa a anotação @DecimalMin da especificação Jakarta Validation API.
 * Esta anotação é usada para garantir que um valor decimal seja maior ou igual a um valor mínimo especificado.
 * É útil para validar dados monetários ou outros valores numéricos que não devem ser negativos ou abaixo de um certo limite.
 */

import java.math.BigDecimal;

/**
 * Importa a classe BigDecimal da biblioteca padrão de Java.
 * BigDecimal é usada para representar valores numéricos com precisão decimal,
 * sendo ideal para valores monetários e cálculos que requerem alta precisão.
 */

@Entity(name = "tb_card")
/**
 * A anotação @Entity indica que esta classe é uma entidade JPA e será mapeada
 * para uma tabela no banco de dados.
 * O parâmetro 'name' especifica o nome da tabela no banco de dados.
 */

public class Card {
    /**
     * Declaração da classe 'Card', que representa um cartão no sistema.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * A anotação @Id indica que o campo 'id' é a chave primária da tabela.
     * 
     * @GeneratedValue com a estratégia 'IDENTITY' indica que o valor do campo será
     *                 gerado automaticamente pelo banco de dados.
     */
    private Long id;

    @NotNull
    @Size(min = 16, max = 16)
    @Column(unique = true, nullable = false)
    /**
     * A anotação @NotNull garante que o campo 'number' não seja nulo.
     * A anotação @Size restringe o tamanho do campo 'number' para exatamente 16
     * caracteres.
     * 
     * @Column com 'unique = true' e 'nullable = false' garante que o campo 'number'
     *         seja único e não nulo no banco de dados.
     */
    private String number;

    @NotNull
    @DecimalMin("0.00")
    @Column(name = "available_limit", precision = 13, scale = 2, nullable = false)
    /**
     * A anotação @NotNull garante que o campo 'creditLimit' não seja nulo.
     * A anotação @DecimalMin garante que o valor do campo 'creditLimit' seja no
     * mínimo 0.00.
     * 
     * @Column com 'precision = 13' e 'scale = 2' define a precisão e a escala do
     *         campo 'creditLimit'.
     *         'nullable = false' garante que o campo 'creditLimit' não seja nulo no
     *         banco de dados.
     */
    private BigDecimal creditLimit;

    // Getters and Setters
    /**
     * Métodos 'getId' e 'setId' para acessar e modificar o campo 'id'.
     * Métodos 'getNumber' e 'setNumber' para acessar e modificar o campo 'number'.
     * Métodos 'getCreditLimit' e 'setCreditLimit' para acessar e modificar o campo
     * 'creditLimit'.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
