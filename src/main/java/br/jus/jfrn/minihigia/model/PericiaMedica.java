package br.jus.jfrn.minihigia.model;

import br.jus.jfrn.minihigia.model.enums.InstrucaoPericiando;
import br.jus.jfrn.minihigia.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "pericias_medicas")
public class PericiaMedica extends Pericia
{
    @NotBlank
    private String anamnese;

    @NotBlank
    private String exameClinico;

    @NotBlank
    private String documentos;

    private boolean isPericiandoPaciente;

    @NotNull
    private int idadePericiando;

    @Enumerated(EnumType.STRING)
    private InstrucaoPericiando instrucaoPericiando;

    @NotBlank
    private String ultimaOcupacaoPericiando;

    @NotBlank
    private String outrasOcupacoesPericiando;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_doenca")
    private Doenca doenca;

    @OneToMany(mappedBy = "periciaMedica", cascade = CascadeType.ALL)
    private List<Comorbidade> comorbidades;

    public void addComorbidade(Comorbidade comorbidade)
    {
        comorbidades.add(comorbidade);
        comorbidade.setPericiaMedica(this);
    }

    public void removeComorbidade(Comorbidade comorbidade)
    {
        comorbidades.remove(comorbidade);
        comorbidade.setPericiaMedica(null);
    }

    public PericiaMedica(Status status, String numeroProcesso, String esclarecimentosDiversos,
                         String localAssinatura, String assinaturaPerito, Perito perito, Periciando periciando,
                         String anamnese, String exameClinico, String documentos, boolean isPericiandoPaciente,
                         int idadePericiando, InstrucaoPericiando instrucaoPericiando, String ultimaOcupacaoPericiando,
                         String outrasOcupacoesPericiando, Doenca doenca, List<Comorbidade> comorbidades)
    {
        super(status, numeroProcesso, esclarecimentosDiversos, localAssinatura, assinaturaPerito, perito, periciando);
        this.anamnese = anamnese;
        this.exameClinico = exameClinico;
        this.documentos = documentos;
        this.isPericiandoPaciente = isPericiandoPaciente;
        this.idadePericiando = idadePericiando;
        this.instrucaoPericiando = instrucaoPericiando;
        this.ultimaOcupacaoPericiando = ultimaOcupacaoPericiando;
        this.outrasOcupacoesPericiando = outrasOcupacoesPericiando;
        this.doenca = doenca;
        this.comorbidades = comorbidades;
    }
}
