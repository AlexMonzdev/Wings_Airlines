package com.airlines.app_wings.profiles;

import com.airlines.app_wings.roles.Role;
import com.airlines.app_wings.users.User;
import jakarta.persistence.*;
import lombok.*;



import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String passportId;

    private String name;
    private String phone;
    private String nationality;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_rol", nullable = false)
    private Role role;

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    public int getAge() {
        if (this.dateOfBirth == null) {
            return 0;
        }
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

}
