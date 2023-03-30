package org.example.entity;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
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
@Table(name = "gift_certificate")
public class GiftCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "last_update_date")
    private Time lastUpdateDate;
    @Column(name = "create_date")
    private Time createdDate;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "certificate_tag", joinColumns = @JoinColumn(name = "certificate_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GiftCertificate other = (GiftCertificate) o;
        return id != null && Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "GiftCertificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", lastUpdateDate=" + lastUpdateDate +
                ", createdDate=" + createdDate +
                ", tags=" + tags.stream().map(Tag::getName).toList() +
                '}';
    }
}
