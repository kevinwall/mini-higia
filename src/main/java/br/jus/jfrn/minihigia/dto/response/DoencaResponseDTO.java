package br.jus.jfrn.minihigia.dto.response;

import br.jus.jfrn.minihigia.controller.DoencaController;
import br.jus.jfrn.minihigia.model.Doenca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoencaResponseDTO extends RepresentationModel<DoencaResponseDTO>
{
    private boolean isPrejudicado;

    private String cid;

    private String sobreDiagnostico;

    private String natureza;

    private String tratamento;

    private String prognostico;

    private String outrasOcupacoesPericiando;

    private String detalhamento;

    public DoencaResponseDTO(Doenca d)
    {
        this.isPrejudicado = d.isPrejudicado();
        this.cid = d.getCid();
        this.sobreDiagnostico = d.getSobreDiagnostico();
        this.natureza = d.getNatureza();
        this.tratamento = d.getTratamento();
        this.prognostico = d.getPrognostico();
        this.outrasOcupacoesPericiando = d.getOutrasOcupacoesPericiando();
        this.detalhamento = d.getDetalhamento();
    }

    public void addLinks(long id)
    {
        this.add(
                linkTo
                        (DoencaController.class)
                        .withRel("findAll")
        );

        this.add(
                linkTo
                        (DoencaController.class)
                        .slash(id)
                        .withSelfRel()
        );

        this.add(
                linkTo
                        (DoencaController.class)
                        .slash(id)
                        .withRel("update")
        );

        this.add(
                linkTo
                        (DoencaController.class)
                        .slash(id)
                        .withRel("delete")
        );
    }
}
