package br.jus.jfrn.minihigia.model;

import br.jus.jfrn.minihigia.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "pericias")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pericia
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @NotBlank
    private String numeroProcesso;

    @NotBlank
    private String esclarecimentosDiversos;

    @NotBlank
    private String localAssinatura;

    @NotBlank
    private String assinaturaPerito;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_perito")
    private Perito perito;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_periciando")
    private Periciando periciando;

    public Pericia(Status status, String numeroProcesso, String esclarecimentosDiversos,
                   String localAssinatura, String assinaturaPerito, Perito perito, Periciando periciando)
    {
        this.status = status;
        this.numeroProcesso = numeroProcesso;
        this.esclarecimentosDiversos = esclarecimentosDiversos;
        this.localAssinatura = localAssinatura;
        this.assinaturaPerito = assinaturaPerito;
        this.perito = perito;
        this.periciando = periciando;
    }
}
