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
@Table(name = "periciandos")
public class Periciando
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @OneToOne(mappedBy = "periciando", cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private Representante representante;

    @OneToOne(mappedBy = "periciando")
    @JsonIgnore
    private Pericia pericia;

    public Periciando(String nome, String cpf, Representante representante)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.representante = representante;
    }
}
