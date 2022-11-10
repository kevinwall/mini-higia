package br.jus.jfrn.minihigia.dto.response;

import br.jus.jfrn.minihigia.controller.UsuarioController;
import br.jus.jfrn.minihigia.model.Periciando;
import br.jus.jfrn.minihigia.model.Representante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PericiandoResponseDTO extends RepresentationModel<PericiandoResponseDTO>
{
    private String nome;

    private String cpf;

    private Representante representante;

    public PericiandoResponseDTO(Periciando p)
    {
        this.nome = p.getNome();
        this.cpf = p.getCpf();
        this.representante = p.getRepresentante();
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
                        .slash("periciandos")
                        .slash(id)
                        .withSelfRel()
        );

        this.add(
                linkTo
                        (UsuarioController.class)
                        .slash("periciandos")
                        .slash(id)
                        .withRel("update")
        );

        this.add(
                linkTo
                        (UsuarioController.class)
                        .slash("periciandos")
                        .slash(id)
                        .withRel("delete")
        );
    }
}
