package br.jus.jfrn.minihigia.controller;

import br.jus.jfrn.minihigia.dto.request.ComorbidadeRequestDTO;
import br.jus.jfrn.minihigia.dto.request.DoencaRequestDTO;
import br.jus.jfrn.minihigia.dto.response.ComorbidadeResponseDTO;
import br.jus.jfrn.minihigia.dto.response.DoencaResponseDTO;
import br.jus.jfrn.minihigia.model.Comorbidade;
import br.jus.jfrn.minihigia.model.Doenca;
import br.jus.jfrn.minihigia.service.DoencaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/doencas")
public class DoencaController
{
    private final DoencaService doencaService;

    public DoencaController(DoencaService doencaService)
    {
        this.doencaService = doencaService;
    }

    @GetMapping
    public List<DoencaResponseDTO> findAllDoencas()
    {
        List<Doenca> doencas = doencaService.listAllDoencas();
        List<DoencaResponseDTO> listDTO = new ArrayList<DoencaResponseDTO>();

        for(Doenca d : doencas)
        {
            DoencaResponseDTO responseDTO = new DoencaResponseDTO(d);
            responseDTO.addLinks(d.getId());
            listDTO.add(responseDTO);
        }

        return listDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoencaResponseDTO> listDoencaByID(@PathVariable long id)
    {
        Optional<Doenca> doenca = doencaService.listDoencaById(id);

        if(doenca.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            Doenca d = doenca.get();
            DoencaResponseDTO responseDTO = new DoencaResponseDTO(d);
            responseDTO.addLinks(d.getId());
            return ResponseEntity.ok().body(responseDTO);
        }
    }

    @PostMapping
    public ResponseEntity<DoencaResponseDTO> insertDoenca(@RequestBody DoencaRequestDTO doencaRequestDTO)
    {
        Doenca doenca = doencaRequestDTO.unpack();
        Doenca d = doencaService.insertDoenca(doenca);
        DoencaResponseDTO responseDTO = new DoencaResponseDTO(d);
        responseDTO.addLinks(d.getId());
        return ResponseEntity.created(URI.create("/"+d.getId())).body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoenca(@PathVariable long id)
    {
        return doencaService
                .listDoencaById(id)
                .map(data -> {
                    doencaService.deleteDoenca(data);
                    return ResponseEntity.status(202).build();
                }).orElse(
                        ResponseEntity.notFound().build()
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoencaResponseDTO> updateDoenca(@PathVariable long id, @RequestBody Doenca d)
    {
        if(!Objects.equals(id, d.getId()))
        {
            return ResponseEntity.badRequest().build();
        }

        return doencaService
                .listDoencaById(id)
                .map(data -> {
                    doencaService.updateDoenca(d);
                    DoencaResponseDTO responseDTO = new DoencaResponseDTO(d);
                    responseDTO.addLinks(d.getId());
                    return ResponseEntity.ok().body(responseDTO);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/comorbidades")
    public List<ComorbidadeResponseDTO> findAllComorbidades()
    {
        List<Comorbidade> comorbidades = doencaService.listAllComorbidades();
        List<ComorbidadeResponseDTO> listDTO = new ArrayList<ComorbidadeResponseDTO>();

        for(Comorbidade c : comorbidades)
        {
            ComorbidadeResponseDTO responseDTO = new ComorbidadeResponseDTO(c);
            responseDTO.addLinks(c.getId());
            listDTO.add(responseDTO);
        }

        return listDTO;
    }

    @GetMapping("/comorbidades/{id}")
    public ResponseEntity<ComorbidadeResponseDTO> listComorbidadeByID(@PathVariable long id)
    {
        Optional<Comorbidade> comorbidade = doencaService.listComorbidadeById(id);

        if(comorbidade.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            Comorbidade c = comorbidade.get();
            ComorbidadeResponseDTO responseDTO = new ComorbidadeResponseDTO(c);
            responseDTO.addLinks(c.getId());
            return ResponseEntity.ok().body(responseDTO);
        }
    }

    @PostMapping("/comorbidades")
    public ResponseEntity<ComorbidadeResponseDTO> insertComorbidade(@RequestBody ComorbidadeRequestDTO comorbidadeRequestDTO)
    {
        Comorbidade comorbidade = comorbidadeRequestDTO.unpack();
        Comorbidade c = doencaService.insertComorbidade(comorbidade);
        ComorbidadeResponseDTO responseDTO = new ComorbidadeResponseDTO(c);
        responseDTO.addLinks(c.getId());
        return ResponseEntity.created(URI.create("/"+c.getId())).body(responseDTO);
    }

    @DeleteMapping("/comorbidades/{id}")
    public ResponseEntity<?> deleteComorbidade(@PathVariable long id)
    {
        return doencaService
                .listComorbidadeById(id)
                .map(data -> {
                    doencaService.deleteComorbidade(data);
                    return ResponseEntity.status(202).build();
                }).orElse(
                        ResponseEntity.notFound().build()
                );
    }

    @PutMapping("/comorbidades/{id}")
    public ResponseEntity<ComorbidadeResponseDTO> updateDoenca(@PathVariable long id, @RequestBody Comorbidade c)
    {
        if(!Objects.equals(id, c.getId()))
        {
            return ResponseEntity.badRequest().build();
        }

        return doencaService
                .listComorbidadeById(id)
                .map(data -> {
                    doencaService.updateComorbidade(c);
                    ComorbidadeResponseDTO responseDTO = new ComorbidadeResponseDTO(c);
                    responseDTO.addLinks(c.getId());
                    return ResponseEntity.ok().body(responseDTO);
                }).orElse(ResponseEntity.notFound().build());
    }
}
