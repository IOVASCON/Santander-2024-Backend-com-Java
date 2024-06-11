package me.dio.dominio.model;

/**
 * O pacote 'me.dio.dominio.model' é onde esta classe está localizada.
 * Ele organiza as classes relacionadas ao domínio do sistema.
 * Neste caso, o pacote 'model' contém as classes de entidade que representam os dados do sistema.
 */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * Importa todas as anotações e classes relacionadas à persistência de dados
 * fornecidas pela especificação JPA (Jakarta Persistence API).
 * Importa anotações de validação (@NotNull e @Size) da especificação Jakarta
 * Validation API, usadas para garantir a integridade dos dados.
 */

@Entity(name = "tb_application_user")
/**
 * A anotação @Entity indica que esta classe é uma entidade JPA.
 * O parâmetro 'name = "tb_application_user"' especifica o nome da tabela no
 * banco de dados.
 */

public class ApplicationUser {
    /**
     * Declaração da classe 'ApplicationUser' que representa um usuário da
     * aplicação.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * O campo 'id' é a chave primária da entidade, gerada automaticamente pelo
     * banco de dados.
     * A anotação @Id indica que este campo é a chave primária.
     * A anotação @GeneratedValue com 'strategy = GenerationType.IDENTITY' indica
     * que o valor é gerado pelo banco de dados.
     */

    @NotNull
    @Size(min = 2, max = 100)
    private String name;
    /**
     * O campo 'name' armazena o nome do usuário.
     * A anotação @NotNull garante que este campo não seja nulo.
     * A anotação @Size define um tamanho mínimo e máximo para o campo.
     */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
    /**
     * O campo 'account' representa a associação de um para um com a entidade
     * 'Account'.
     * A anotação @OneToOne indica um relacionamento de um para um.
     * A anotação @JoinColumn especifica a coluna de junção.
     * 'cascade = CascadeType.ALL' indica que todas as operações de persistência são
     * cascata.
     */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emprestimos_id", referencedColumnName = "id")
    private Emprestimos emprestimos;
    /**
     * O campo 'emprestimos' representa a associação de um para um com a entidade
     * 'Emprestimos'.
     * A anotação @OneToOne indica um relacionamento de um para um.
     * A anotação @JoinColumn especifica a coluna de junção.
     * 'cascade = CascadeType.ALL' indica que todas as operações de persistência são
     * cascata.
     */

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Feature> features;
    /**
     * O campo 'features' representa a associação de um para muitos com a entidade
     * 'Feature'.
     * A anotação @OneToMany indica um relacionamento de um para muitos.
     * 'cascade = CascadeType.ALL' indica que todas as operações de persistência são
     * cascata.
     * 'fetch = FetchType.LAZY' indica que a coleção é carregada sob demanda.
     * A anotação @JoinColumn especifica a coluna de junção.
     */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;
    /**
     * O campo 'card' representa a associação de um para um com a entidade 'Card'.
     * A anotação @OneToOne indica um relacionamento de um para um.
     * A anotação @JoinColumn especifica a coluna de junção.
     * 'cascade = CascadeType.ALL' indica que todas as operações de persistência são
     * cascata.
     */

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<News> news;
    /**
     * O campo 'news' representa a associação de um para muitos com a entidade
     * 'News'.
     * A anotação @OneToMany indica um relacionamento de um para muitos.
     * 'cascade = CascadeType.ALL' indica que todas as operações de persistência são
     * cascata.
     * 'fetch = FetchType.LAZY' indica que a coleção é carregada sob demanda.
     * A anotação @JoinColumn especifica a coluna de junção.
     */

    // Getters and Setters
    /**
     * Métodos 'getId', 'setId', 'getName', 'setName', 'getAccount', 'setAccount',
     * 'getEmprestimos', 'setEmprestimos',
     * 'getFeatures', 'setFeatures', 'getCard', 'setCard', 'getNews', e 'setNews'
     * para acessar e modificar os campos correspondentes.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Emprestimos getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(Emprestimos emprestimos) {
        this.emprestimos = emprestimos;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
