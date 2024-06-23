package com.starwars.sabresjava.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sabre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 10, nullable = false)
    private String tipo;

    @Column(nullable = false)
    private LocalDate dataFabricacao;

    @NotNull
    @NotBlank
    @Column(length = 10, nullable = false)
    private String status;

    @Column(length = 50)
    private String jedi;

    private boolean deleted = false;

}
