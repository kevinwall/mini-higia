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
@Table(name = "comorbidades")
public class Comorbidade
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "O nome da doença não pode ser vazio")
    private String nomeDoenca;

    @NotBlank(message = "A natureza da doença precisa ser informada")
    private String natureza;

    @NotBlank(message = "O tratamento da doença deve ser informado")
    private String tratamento;

    @ManyToOne
    @JoinColumn(name = "id_pericia_medica")
    @JsonIgnore
    private PericiaMedica periciaMedica;

    public Comorbidade(String nomeDoenca, String natureza, String tratamento)
    {
        this.nomeDoenca = nomeDoenca;
        this.natureza = natureza;
        this.tratamento = tratamento;
    }
}
