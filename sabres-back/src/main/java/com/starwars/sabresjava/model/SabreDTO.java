package com.starwars.sabresjava.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SabreDTO {

    private Long id;

    private String tipo;

    private String dataFabricacao;

    private String status;

    private String jedi;

}
