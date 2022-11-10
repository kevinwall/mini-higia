package br.jus.jfrn.minihigia.dto.response;

import br.jus.jfrn.minihigia.controller.DoencaController;
import br.jus.jfrn.minihigia.model.Comorbidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComorbidadeResponseDTO extends RepresentationModel<ComorbidadeResponseDTO>
{
    private String nomeDoenca;

    private String natureza;

    private String tratamento;

    public ComorbidadeResponseDTO(Comorbidade c)
    {
        this.nomeDoenca = c.getNomeDoenca();
        this.natureza = c.getNatureza();
        this.tratamento = c.getTratamento();
    }

    public void addLinks(long id)
    {
        this.add(
                linkTo
                        (DoencaController.class)
                        .slash("comorbidades")
                        .withRel("findAll")
        );

        this.add(
                linkTo
                        (DoencaController.class)
                        .slash("comorbidades")
                        .slash(id)
                        .withSelfRel()
        );

        this.add(
                linkTo
                        (DoencaController.class)
                        .slash("comorbidades")
                        .slash(id)
                        .withRel("update")
        );

        this.add(
                linkTo
                        (DoencaController.class)
                        .slash("comorbidades")
                        .slash(id)
                        .withRel("delete")
        );
    }
}
