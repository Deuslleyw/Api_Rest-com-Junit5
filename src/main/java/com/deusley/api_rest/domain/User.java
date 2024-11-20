package com.deusley.api_rest.domain;


<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

=======
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
>>>>>>> e8b7943613ffa70f7274b5b7ec065f35be738692
import java.util.Objects;

@Builder
@ToString
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_USUARIOS")
public class User {

    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
    @GeneratedValue (strategy = GenerationType.IDENTITY)
>>>>>>> e8b7943613ffa70f7274b5b7ec065f35be738692
    private Integer id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
