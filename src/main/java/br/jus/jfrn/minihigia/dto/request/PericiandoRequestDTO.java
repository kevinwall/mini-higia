package br.jus.jfrn.minihigia.dto.request;

import br.jus.jfrn.minihigia.model.Periciando;
import br.jus.jfrn.minihigia.model.Representante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PericiandoRequestDTO
{
    private String nome;

    private String cpf;

    private Representante representante;

    public Periciando unpack()
    {
        return new Periciando(this.nome, this.cpf, this.representante);
    }
}
