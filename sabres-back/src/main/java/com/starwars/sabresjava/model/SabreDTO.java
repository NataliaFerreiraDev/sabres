package com.starwars.sabresjava.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.starwars.sabresjava.enums.SabreStatus;
import com.starwars.sabresjava.enums.SabreTipo;
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

    private SabreTipo tipo;

    private String dataFabricacao;

    private SabreStatus status;

    private String jedi;

}
