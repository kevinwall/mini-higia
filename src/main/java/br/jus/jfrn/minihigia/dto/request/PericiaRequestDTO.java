package br.jus.jfrn.minihigia.dto.request;

import br.jus.jfrn.minihigia.model.Doenca;
import br.jus.jfrn.minihigia.model.Pericia;
import br.jus.jfrn.minihigia.model.Periciando;
import br.jus.jfrn.minihigia.model.Perito;
import br.jus.jfrn.minihigia.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PericiaRequestDTO
{
    private Status status;

    private String numeroProcesso;

    private String esclarecimentosDiversos;

    private String localAssinatura;

    private String assinaturaPerito;

    private Perito perito;

    private Periciando periciando;

    public Pericia unpack()
    {
        return new Pericia(this.status, this.numeroProcesso, this.esclarecimentosDiversos,
                this.localAssinatura, this.assinaturaPerito, this.perito, this.periciando);
    }
}
