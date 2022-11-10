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
@Table(name = "doencas")
public class Doenca
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean isPrejudicado;

    @NotBlank
    private String cid;

    @NotBlank
    private String sobreDiagnostico;

    @NotBlank
    private String natureza;

    @NotBlank
    private String tratamento;

    @NotBlank
    private String prognostico;

    @NotBlank
    private String outrasOcupacoesPericiando;

    @NotBlank
    private String detalhamento;

    @OneToOne(mappedBy = "doenca")
    @JsonIgnore
    private PericiaMedica periciaMedica;

    public Doenca(boolean isPrejudicado, String cid, String sobreDiagnostico, String natureza,
                  String tratamento, String prognostico, String outrasOcupacoesPericiando, String detalhamento)
    {
        this.isPrejudicado = isPrejudicado;
        this.cid = cid;
        this.sobreDiagnostico = sobreDiagnostico;
        this.natureza = natureza;
        this.tratamento = tratamento;
        this.prognostico = prognostico;
        this.outrasOcupacoesPericiando = outrasOcupacoesPericiando;
        this.detalhamento = detalhamento;
    }
}
