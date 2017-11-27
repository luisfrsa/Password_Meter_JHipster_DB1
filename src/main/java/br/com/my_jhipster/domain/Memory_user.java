package br.com.my_jhipster.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Memory_user.
 */
@Entity
@Table(name = "memory_user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Memory_user implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Min(value = 0)
    @Column(name = "score", nullable = false)
    private Integer score;

    @NotNull
    @Min(value = 0)
    @Column(name = "num_cards", nullable = false)
    private Integer num_cards;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Memory_user name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public Memory_user score(Integer score) {
        this.score = score;
        return this;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getNum_cards() {
        return num_cards;
    }

    public Memory_user num_cards(Integer num_cards) {
        this.num_cards = num_cards;
        return this;
    }

    public void setNum_cards(Integer num_cards) {
        this.num_cards = num_cards;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Memory_user memory_user = (Memory_user) o;
        if (memory_user.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), memory_user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Memory_user{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", score='" + getScore() + "'" +
            ", num_cards='" + getNum_cards() + "'" +
            "}";
    }
}
