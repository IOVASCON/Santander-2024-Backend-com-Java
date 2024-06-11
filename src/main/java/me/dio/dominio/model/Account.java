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
 * BigDecimal é usada para representar valores numéricos com precisão decimal, sendo ideal para valores monetários e cálculos que requerem alta precisão.
 */

/**
 * A classe Account representa uma conta bancária.
 * Ela contém informações sobre o número da conta, agência, saldo e limite de
 * crédito.
 * As anotações de validação garantem que os campos estejam preenchidos
 * corretamente.
 */
@Entity(name = "tb_account")
public class Account extends BaseItem {

    /**
     * O número da conta, que deve ser único e não nulo.
     * Utilizamos @Size para garantir que o número tenha entre 3 e 20 caracteres.
     */
    @NotNull(message = "O número da conta não pode ser nulo")
    @Size(min = 3, max = 20, message = "O número da conta deve ter entre 3 e 20 caracteres")
    @Column(nullable = false, unique = true)
    private String number;

    /**
     * A agência da conta, que não pode ser nula.
     * Utilizamos @Size para garantir que a agência tenha entre 3 e 20 caracteres.
     */
    @NotNull(message = "A agência não pode ser nula")
    @Size(min = 3, max = 20, message = "A agência deve ter entre 3 e 20 caracteres")
    @Column(nullable = false)
    private String agency;

    /**
     * O saldo da conta, que não pode ser nulo e deve ser um valor positivo.
     * Utilizamos @DecimalMin para garantir que o saldo seja maior que zero.
     */
    @NotNull(message = "O saldo não pode ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "O saldo deve ser maior que zero")
    @Column(nullable = false, precision = 13, scale = 2)
    private BigDecimal balance;

    /**
     * O limite de crédito da conta, que não pode ser nulo e deve ser um valor
     * positivo.
     * Utilizamos @DecimalMin para garantir que o limite de crédito seja maior que
     * zero.
     */
    @NotNull(message = "O limite de crédito não pode ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "O limite de crédito deve ser maior que zero")
    @Column(nullable = false, precision = 13, scale = 2)
    private BigDecimal creditLimit;

    // Getters and Setters
    /**
     * A seção de Getters e Setters fornece métodos públicos para acessar e
     * modificar os campos privados da classe.
     * Esses métodos são usados para garantir o encapsulamento, permitindo que os
     * valores dos campos sejam lidos
     * e alterados de fora da classe de maneira controlada.
     * 
     * O getter para um campo retorna o valor do campo.
     * O setter para um campo define o valor do campo, permitindo validações
     * adicionais ou outras operações
     * antes de realmente modificar o valor do campo.
     * 
     * Por exemplo, o método getNumber() retorna o valor do campo 'number', e o
     * método setNumber(String number)
     * permite que o valor do campo 'number' seja definido externamente.
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

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
