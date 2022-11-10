package br.jus.jfrn.minihigia.dto.response;

import br.jus.jfrn.minihigia.controller.UsuarioController;
import br.jus.jfrn.minihigia.model.Perito;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeritoResponseDTO extends RepresentationModel<PeritoResponseDTO>
{
    private String nome;

    private String crm;

    private String rqe;

    public PeritoResponseDTO(Perito p)
    {
        this.nome = p.getNome();
        this.crm = p.getCrm();
        this.rqe = p.getRqe();
    }

    public void addLinks(long id)
    {
        this.add(
                linkTo
                        (UsuarioController.class)
                        .withRel("findAll")
        );

        this.add(
                linkTo
                        (UsuarioController.class)
                        .slash("peritos")
                        .slash(id)
                        .withSelfRel()
        );

        this.add(
                linkTo
                        (UsuarioController.class)
                        .slash("peritos")
                        .slash(id)
                        .withRel("update")
        );

        this.add(
                linkTo
                        (UsuarioController.class)
                        .slash("peritos")
                        .slash(id)
                        .withRel("delete")
        );
    }
}
