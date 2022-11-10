package br.jus.jfrn.minihigia.dto.request;

import br.jus.jfrn.minihigia.model.*;
import br.jus.jfrn.minihigia.model.enums.InstrucaoPericiando;
import br.jus.jfrn.minihigia.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PericiaMedicaRequestDTO
{
    private Status status;

    private String numeroProcesso;

    private String esclarecimentosDiversos;

    private String localAssinatura;

    private String assinaturaPerito;

    private Perito perito;

    private Periciando periciando;

    private String anamnese;

    private String exameClinico;

    private String documentos;

    private boolean isPericiandoPaciente;

    private int idadePericiando;

    private InstrucaoPericiando instrucaoPericiando;

    private String ultimaOcupacaoPericiando;

    private String outrasOcupacoesPericiando;

    private Doenca doenca;

    private List<Comorbidade> comorbidades;

    public PericiaMedica unpack()
    {
        return new PericiaMedica(this.status, this.numeroProcesso, this.esclarecimentosDiversos,
                this.localAssinatura, this.assinaturaPerito, this.perito, this.periciando,
                this.anamnese, this.exameClinico, this.documentos, this.isPericiandoPaciente,
                this.idadePericiando, this.instrucaoPericiando, this.ultimaOcupacaoPericiando,
                this.outrasOcupacoesPericiando, this.doenca, this.comorbidades);
    }
}
