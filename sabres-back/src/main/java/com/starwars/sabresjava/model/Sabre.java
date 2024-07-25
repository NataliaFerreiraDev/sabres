package com.starwars.sabresjava.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.starwars.sabresjava.enums.SabreStatus;
import com.starwars.sabresjava.enums.SabreTipo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sabre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SabreTipo tipo;

    @Column(nullable = false)
    private LocalDate dataFabricacao;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SabreStatus status;

    @Column(length = 50)
    private String jedi;

    private boolean deleted = false;

}
