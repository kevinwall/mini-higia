package br.jus.jfrn.minihigia.controller;

import br.jus.jfrn.minihigia.dto.request.PericiaMedicaRequestDTO;
import br.jus.jfrn.minihigia.dto.request.PericiaRequestDTO;
import br.jus.jfrn.minihigia.dto.response.PericiaMedicaResponseDTO;
import br.jus.jfrn.minihigia.dto.response.PericiaResponseDTO;
import br.jus.jfrn.minihigia.model.Pericia;
import br.jus.jfrn.minihigia.model.PericiaMedica;
import br.jus.jfrn.minihigia.service.FormularioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/formularios")
public class FormularioController
{
    private final FormularioService formularioService;

    public FormularioController(FormularioService formularioService)
    {
        this.formularioService = formularioService;
    }

    @GetMapping("/pericias")
    public List<PericiaResponseDTO> findAllPericias()
    {
        List<Pericia> pericias = formularioService.listAllPericias();
        List<PericiaResponseDTO> listDTO = new ArrayList<PericiaResponseDTO>();

        for(Pericia p: pericias)
        {
            PericiaResponseDTO responseDTO = new PericiaResponseDTO(p);
            responseDTO.addLinks(p.getId());
            listDTO.add(responseDTO);
        }

        return listDTO;
    }

    @GetMapping("/pericias/{id}")
    public ResponseEntity<PericiaResponseDTO> listPericiaByID(@PathVariable long id)
    {
        Optional<Pericia> pericia = formularioService.listPericiaById(id);

        if(pericia.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            Pericia p = pericia.get();
            PericiaResponseDTO responseDTO = new PericiaResponseDTO(p);
            responseDTO.addLinks(p.getId());
            return ResponseEntity.ok().body(responseDTO);
        }
    }

    @PostMapping("/pericias")
    public ResponseEntity<PericiaResponseDTO> insertPericia(@RequestBody PericiaRequestDTO periciaRequestDTO)
    {
        Pericia pericia = periciaRequestDTO.unpack();
        Pericia p = formularioService.insertPericia(pericia);
        PericiaResponseDTO responseDTO = new PericiaResponseDTO(p);
        responseDTO.addLinks(p.getId());
        return ResponseEntity.created(URI.create("/"+p.getId())).body(responseDTO);
    }

    @DeleteMapping("/pericias/{id}")
    public ResponseEntity<?> deletePericia(@PathVariable long id)
    {
        return formularioService
                .listPericiaById(id)
                .map(data -> {
                    formularioService.deletePericia(data);
                    return ResponseEntity.status(202).build();
                }).orElse(
                        ResponseEntity.notFound().build()
                );
    }

    @PutMapping("/pericias/{id}")
    public ResponseEntity<PericiaResponseDTO> updatePericia(@PathVariable long id, @RequestBody Pericia p)
    {
        if(!Objects.equals(id, p.getId()))
        {
            return ResponseEntity.badRequest().build();
        }

        return formularioService
                .listPericiaById(id)
                .map(data -> {
                    formularioService.updatePericia(p);
                    PericiaResponseDTO responseDTO = new PericiaResponseDTO(p);
                    responseDTO.addLinks(p.getId());
                    return ResponseEntity.ok().body(responseDTO);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pericias_medicas")
    public List<PericiaMedicaResponseDTO> findAllPericiasMedicas()
    {
        List<PericiaMedica> periciasMedicas = formularioService.listAllPericiasMedicas();
        List<PericiaMedicaResponseDTO> listDTO = new ArrayList<PericiaMedicaResponseDTO>();

        for(PericiaMedica pm: periciasMedicas)
        {
            PericiaMedicaResponseDTO responseDTO = new PericiaMedicaResponseDTO(pm);
            responseDTO.addLinks(pm.getId());
            listDTO.add(responseDTO);
        }

        return listDTO;
    }

    @GetMapping("/pericias_medicas/{id}")
    public ResponseEntity<PericiaMedicaResponseDTO> listPericiaMedicaByID(@PathVariable long id)
    {
        Optional<PericiaMedica> periciaMedica = formularioService.listPericiaMedicaById(id);

        if(periciaMedica.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            PericiaMedica pm = periciaMedica.get();
            PericiaMedicaResponseDTO responseDTO = new PericiaMedicaResponseDTO(pm);
            responseDTO.addLinks(pm.getId());
            return ResponseEntity.ok().body(responseDTO);
        }
    }

    @PostMapping("/pericias_medicas")
    public ResponseEntity<PericiaMedicaResponseDTO> insertPericiaMedica(@RequestBody PericiaMedicaRequestDTO periciaMedicaRequestDTO)
    {
        PericiaMedica periciaMedica = periciaMedicaRequestDTO.unpack();
        PericiaMedica pm = formularioService.insertPericiaMedica(periciaMedica);
        PericiaMedicaResponseDTO responseDTO = new PericiaMedicaResponseDTO(pm);
        responseDTO.addLinks(pm.getId());
        return ResponseEntity.created(URI.create("/"+pm.getId())).body(responseDTO);
    }

    @DeleteMapping("/pericias_medicas/{id}")
    public ResponseEntity<?> deletePericiaMedica(@PathVariable long id)
    {
        return formularioService
                .listPericiaMedicaById(id)
                .map(data -> {
                    formularioService.deletePericiaMedica(data);
                    return ResponseEntity.status(202).build();
                }).orElse(
                        ResponseEntity.notFound().build()
                );
    }

    @PutMapping("/pericias_medicas/{id}")
    public ResponseEntity<PericiaMedicaResponseDTO> updatePericia(@PathVariable long id, @RequestBody PericiaMedica pm) {
        if (!Objects.equals(id, pm.getId())) {
            return ResponseEntity.badRequest().build();
        }

        return formularioService
                .listPericiaMedicaById(id)
                .map(data -> {
                    formularioService.updatePericiaMedica(pm);
                    PericiaMedicaResponseDTO responseDTO = new PericiaMedicaResponseDTO(pm);
                    responseDTO.addLinks(pm.getId());
                    return ResponseEntity.ok().body(responseDTO);
                }).orElse(ResponseEntity.notFound().build());
    }
}
