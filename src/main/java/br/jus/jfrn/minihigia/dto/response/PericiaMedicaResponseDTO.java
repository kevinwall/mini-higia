package br.jus.jfrn.minihigia.dto.response;

import br.jus.jfrn.minihigia.controller.FormularioController;
import br.jus.jfrn.minihigia.model.*;
import br.jus.jfrn.minihigia.model.enums.InstrucaoPericiando;
import br.jus.jfrn.minihigia.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PericiaMedicaResponseDTO extends RepresentationModel<DoencaResponseDTO>
{
    private Status status;

    private String numeroProcesso;

    private String esclarecimentosDiversos;

    private String localAssinatura;

    private String assinaturaPerito;

    private Perito perito;

    private Periciando periciando;

    private String anamnese;

    private String exameClinico;

    private String documentos;

    private boolean isPericiandoPaciente;

    private int idadePericiando;

    private InstrucaoPericiando instrucaoPericiando;

    private String ultimaOcupacaoPericiando;

    private String outrasOcupacoesPericiando;

    private Doenca doenca;

    private List<Comorbidade> comorbidades;

    public PericiaMedicaResponseDTO(PericiaMedica pm)
    {
        this.status = pm.getStatus();
        this.numeroProcesso = pm.getNumeroProcesso();
        this.esclarecimentosDiversos = pm.getEsclarecimentosDiversos();
        this.localAssinatura = pm.getLocalAssinatura();
        this.assinaturaPerito = pm.getAssinaturaPerito();
        this.perito = pm.getPerito();
        this.periciando = pm.getPericiando();
        this.anamnese = pm.getAnamnese();
        this.exameClinico = pm.getExameClinico();
        this.documentos = pm.getDocumentos();
        this.isPericiandoPaciente = pm.isPericiandoPaciente();
        this.idadePericiando = pm.getIdadePericiando();
        this.instrucaoPericiando = pm.getInstrucaoPericiando();
        this.ultimaOcupacaoPericiando = pm.getUltimaOcupacaoPericiando();
        this.outrasOcupacoesPericiando = pm.getOutrasOcupacoesPericiando();
        this.doenca = pm.getDoenca();
        this.comorbidades = pm.getComorbidades();
    }

    public void addLinks(long id)
    {
        this.add(
                linkTo
                        (FormularioController.class)
                        .slash("pericias_medicas")
                        .withRel("findAll")
        );

        this.add(
                linkTo
                        (FormularioController.class)
                        .slash("pericias_medicas")
                        .slash(id)
                        .withSelfRel()
        );

        this.add(
                linkTo
                        (FormularioController.class)
                        .slash("pericias_medicas")
                        .slash(id)
                        .withRel("update")
        );

        this.add(
                linkTo
                        (FormularioController.class)
                        .slash("pericias_medicas")
                        .slash(id)
                        .withRel("delete")
        );
    }
}
