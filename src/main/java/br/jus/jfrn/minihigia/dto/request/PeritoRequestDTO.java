package br.jus.jfrn.minihigia.dto.request;

import br.jus.jfrn.minihigia.model.Perito;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeritoRequestDTO
{
    private String nome;

    private String crm;

    private String rqe;

    public Perito unpack()
    {
        return new Perito(this.nome, this.crm, this.rqe);
    }
}
