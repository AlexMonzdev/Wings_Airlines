package com.airlines.app_wings.origin;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "origin")
public class Origin {

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
