package com.airlines.app_wings.destiny;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "destiny")
public class Destiny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String airport;

    @Column(nullable = false)
    private String city;

    @Column(name = "cod_city", nullable = false)
    private String codCity;

}
