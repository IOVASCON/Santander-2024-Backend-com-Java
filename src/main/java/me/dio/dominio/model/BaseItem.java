package me.dio.dominio.model;

/**
 * O pacote 'me.dio.dominio.model' é onde esta classe está localizada.
 * Ele organiza as classes relacionadas ao domínio do sistema.
 * Neste caso, o pacote 'model' contém as classes de entidade que representam os dados do sistema.
 */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * Importa todas as anotações e classes relacionadas à persistência de dados
 * fornecidas pela especificação JPA (Jakarta Persistence API).
 * Importa a anotação @NotNull da especificação Jakarta Validation API, usada
 * para garantir que um campo específico não seja nulo.
 */

@MappedSuperclass
/**
 * A anotação @MappedSuperclass indica que esta classe não será mapeada para uma
 * tabela no banco de dados diretamente,
 * mas seus campos e mapeamentos serão herdados pelas subclasses.
 */

public abstract class BaseItem {
    /**
     * Declaração da classe abstrata 'BaseItem', que fornece campos e comportamentos
     * comuns a outras entidades.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    /**
     * O campo 'id' é a chave primária da entidade, gerada automaticamente pelo
     * banco de dados.
     * A anotação @Id indica que este campo é a chave primária.
     * A anotação @GeneratedValue com 'strategy = GenerationType.IDENTITY' indica
     * que o valor é gerado pelo banco de dados.
     */

    @NotNull
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    /**
     * O campo 'createdAt' armazena a data e hora de criação da entidade.
     * A anotação @NotNull garante que este campo não seja nulo.
     * A anotação @Column com 'nullable = false' e 'updatable = false' garante que o
     * campo não seja nulo e não possa ser atualizado após a inserção inicial.
     */

    @NotNull
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    /**
     * O campo 'updatedAt' armazena a data e hora da última atualização da entidade.
     * A anotação @NotNull garante que este campo não seja nulo.
     * A anotação @Column com 'nullable = false' garante que o campo não seja nulo.
     */

    @PrePersist
    protected void onCreate() {
        updatedAt = createdAt = LocalDateTime.now();
    }

    /**
     * O método anotado com @PrePersist é chamado automaticamente antes de a
     * entidade ser persistida no banco de dados pela primeira vez.
     * Ele define os campos 'createdAt' e 'updatedAt' para a data e hora atuais.
     */

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    /**
     * O método anotado com @PreUpdate é chamado automaticamente antes de a entidade
     * ser atualizada no banco de dados.
     * Ele define o campo 'updatedAt' para a data e hora atuais.
     */

    // Getters e Setters
    /**
     * Métodos 'getId', 'setId', 'getCreatedAt', 'setCreatedAt', 'getUpdatedAt' e
     * 'setUpdatedAt'
     * para acessar e modificar os campos correspondentes.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
