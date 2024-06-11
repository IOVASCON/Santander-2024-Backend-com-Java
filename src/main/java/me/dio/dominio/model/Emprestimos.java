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

import jakarta.validation.constraints.DecimalMin;
/**
 * Importa a anotação @DecimalMin da especificação Jakarta Validation API.
 * Esta anotação é usada para garantir que um valor decimal seja maior ou igual a um valor mínimo especificado.
 * É útil para validar dados monetários ou outros valores numéricos que não devem ser negativos ou abaixo de um certo limite.
 */

import java.math.BigDecimal;
/**
 * Importa a classe BigDecimal da biblioteca padrão de Java.
 * BigDecimal é usada para representar valores numéricos com precisão decimal, sendo ideal para valores monetários e cálculos que requerem alta precisão.
 */

import java.time.LocalDateTime;

/**
 * Importa a classe LocalDateTime da biblioteca padrão de Java.
 * LocalDateTime é usada para representar data e hora sem o fuso horário.
 * É ideal para registros de data e hora em sistemas de banco de dados.
 */

@Entity(name = "tb_emprestimos")
/**
 * A anotação @Entity indica que esta classe é uma entidade JPA e será mapeada
 * para uma tabela no banco de dados.
 * O parâmetro 'name' especifica o nome da tabela no banco de dados.
 */

public class Emprestimos {
    /**
     * Declaração da classe 'Emprestimos', que representa um empréstimo no sistema.
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
    @DecimalMin("0.00")
    /**
     * A anotação @NotNull garante que o campo 'amount' não seja nulo.
     * A anotação @DecimalMin garante que o valor do campo 'amount' seja no mínimo
     * 0.00.
     */
    private BigDecimal amount;

    @NotNull
    @Column(nullable = false)
    /**
     * A anotação @NotNull garante que o campo 'date' não seja nulo.
     * 
     * @Column com 'nullable = false' garante que o campo 'date' não seja nulo no
     *         banco de dados.
     */
    private LocalDateTime date;

    @DecimalMin("0.00")
    @Column(precision = 5, scale = 2)
    /**
     * A anotação @DecimalMin garante que o valor do campo 'interestRate' seja no
     * mínimo 0.00.
     * 
     * @Column com 'precision = 5' e 'scale = 2' define a precisão e a escala do
     *         campo 'interestRate'.
     */
    private BigDecimal interestRate;

    // Getters e Setters
    /**
     * Métodos 'getId' e 'setId' para acessar e modificar o campo 'id'.
     * Métodos 'getAmount' e 'setAmount' para acessar e modificar o campo 'amount'.
     * Métodos 'getDate' e 'setDate' para acessar e modificar o campo 'date'.
     * Métodos 'getInterestRate' e 'setInterestRate' para acessar e modificar o
     * campo 'interestRate'.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
