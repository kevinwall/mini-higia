package br.jus.jfrn.minihigia.dto.request;

import br.jus.jfrn.minihigia.model.Doenca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoencaRequestDTO
{
    private boolean isPrejudicado;

    private String cid;

    private String sobreDiagnostico;

    private String natureza;

    private String tratamento;

    private String prognostico;

    private String outrasOcupacoesPericiando;

    private String detalhamento;

    public Doenca unpack()
    {
        return new Doenca(this.isPrejudicado, this.cid, this.sobreDiagnostico, this.natureza,
                this.tratamento, this.prognostico, this.outrasOcupacoesPericiando, this.detalhamento);
    }
}
