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
 * Esta anotação é usada para garantir que o tamanho (quantidade de caracteres)
 * de um campo específico esteja dentro de um limite definido.
 */

@Entity(name = "tb_news")
/**
 * A anotação @Entity indica que esta classe é uma entidade JPA e será mapeada
 * para uma tabela no banco de dados.
 * O parâmetro 'name' especifica o nome da tabela no banco de dados.
 */

public class News extends BaseItem {
    /**
     * Declaração da classe 'News', que representa uma notícia no sistema.
     * Esta classe estende 'BaseItem', herdando assim os atributos e comportamentos
     * comuns.
     */

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    /**
     * A anotação @NotNull garante que o campo 'icon' não seja nulo.
     * A anotação @Size define que o campo 'icon' deve ter no mínimo 1 e no máximo
     * 255 caracteres.
     * 
     * @Column com 'nullable = false' garante que o campo 'icon' não seja nulo no
     *         banco de dados.
     */
    private String icon;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    /**
     * A anotação @NotNull garante que o campo 'description' não seja nulo.
     * A anotação @Size define que o campo 'description' deve ter no mínimo 1 e no
     * máximo 255 caracteres.
     * 
     * @Column com 'nullable = false' garante que o campo 'description' não seja
     *         nulo no banco de dados.
     */
    private String description;

    // Getters e Setters
    /**
     * Métodos 'getIcon' e 'setIcon' para acessar e modificar o campo 'icon'.
     * Métodos 'getDescription' e 'setDescription' para acessar e modificar o campo
     * 'description'.
     */
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
