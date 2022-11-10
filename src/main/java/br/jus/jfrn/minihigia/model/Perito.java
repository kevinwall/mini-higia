package br.jus.jfrn.minihigia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "peritos")
public class Perito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String crm;

    @NotBlank
    private String rqe;

    @OneToOne(mappedBy = "perito")
    @JsonIgnore
    private Pericia pericia;

    public Perito(String nome, String crm, String rqe)
    {
        this.nome = nome;
        this.crm = crm;
        this.rqe = rqe;
    }
}
