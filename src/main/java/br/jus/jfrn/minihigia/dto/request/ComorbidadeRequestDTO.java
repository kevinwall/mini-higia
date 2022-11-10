package br.jus.jfrn.minihigia.dto.request;

import br.jus.jfrn.minihigia.model.Comorbidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComorbidadeRequestDTO
{
    private String nomeDoenca;

    private String natureza;

    private String tratamento;

    public Comorbidade unpack()
    {
        return new Comorbidade(this.nomeDoenca, this.natureza, this.tratamento);
    }
}
