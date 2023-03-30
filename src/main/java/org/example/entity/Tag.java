package org.example.entity;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany()
    @JoinTable(name = "certificate_tag",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "certificate_id"))
    private List<GiftCertificate> certificates;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Tag other = (Tag) o;
        return id != null && Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
