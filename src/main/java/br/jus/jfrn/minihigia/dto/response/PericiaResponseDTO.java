package br.jus.jfrn.minihigia.dto.response;

import br.jus.jfrn.minihigia.controller.FormularioController;
import br.jus.jfrn.minihigia.model.Pericia;
import br.jus.jfrn.minihigia.model.Periciando;
import br.jus.jfrn.minihigia.model.Perito;
import br.jus.jfrn.minihigia.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PericiaResponseDTO extends RepresentationModel<DoencaResponseDTO>
{
    private Status status;

    private String numeroProcesso;

    private String esclarecimentosDiversos;

    private String localAssinatura;

    private String assinaturaPerito;

    private Perito perito;

    private Periciando periciando;

    public PericiaResponseDTO(Pericia p)
    {
        this.status = p.getStatus();
        this.numeroProcesso = p.getNumeroProcesso();
        this.esclarecimentosDiversos = p.getEsclarecimentosDiversos();
        this.localAssinatura = p.getLocalAssinatura();
        this.assinaturaPerito = p.getAssinaturaPerito();
        this.perito = p.getPerito();
        this.periciando = p.getPericiando();
    }

    public void addLinks(long id)
    {
        this.add(
                linkTo
                        (FormularioController.class)
                        .slash("pericias")
                        .withRel("findAll")
        );

        this.add(
                linkTo
                        (FormularioController.class)
                        .slash("pericias")
                        .slash(id)
                        .withSelfRel()
        );

        this.add(
                linkTo
                        (FormularioController.class)
                        .slash("pericias")
                        .slash(id)
                        .withRel("update")
        );

        this.add(
                linkTo
                        (FormularioController.class)
                        .slash("pericias")
                        .slash(id)
                        .withRel("delete")
        );
    }
}
