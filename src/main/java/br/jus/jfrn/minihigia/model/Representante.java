package br.jus.jfrn.minihigia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "representantes")
public class Representante
{
    @Id
    private long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String vinculo;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_periciando")
    @JsonIgnore
    private Periciando periciando;
}
