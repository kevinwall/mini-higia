package br.jus.jfrn.minihigia.controller;

import br.jus.jfrn.minihigia.dto.request.PericiandoRequestDTO;
import br.jus.jfrn.minihigia.dto.request.PeritoRequestDTO;
import br.jus.jfrn.minihigia.dto.response.PericiandoResponseDTO;
import br.jus.jfrn.minihigia.dto.response.PeritoResponseDTO;
import br.jus.jfrn.minihigia.model.Periciando;
import br.jus.jfrn.minihigia.model.Perito;
import br.jus.jfrn.minihigia.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService)
    {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/peritos")
    public List<PeritoResponseDTO> findAllPeritos()
    {
        List<Perito> peritos = usuarioService.listAllPeritos();
        List<PeritoResponseDTO> listDTO = new ArrayList<PeritoResponseDTO>();

        for(Perito p : peritos)
        {
            PeritoResponseDTO responseDTO = new PeritoResponseDTO(p);
            responseDTO.addLinks(p.getId());
            listDTO.add(responseDTO);
        }

        return listDTO;
    }

    @GetMapping("/peritos/{id}")
    public ResponseEntity<PeritoResponseDTO> listPeritoByID(@PathVariable long id)
    {
        Optional<Perito> perito = usuarioService.listPeritoById(id);

        if(perito.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            Perito p = perito.get();
            PeritoResponseDTO responseDTO = new PeritoResponseDTO(p);
            responseDTO.addLinks(p.getId());
            return ResponseEntity.ok().body(responseDTO);
        }
    }

    @PostMapping("/peritos")
    public ResponseEntity<PeritoResponseDTO> insertPerito(@RequestBody PeritoRequestDTO peritoRequestDTO)
    {
        Perito perito = peritoRequestDTO.unpack();
        Perito p = usuarioService.insertPerito(perito);
        PeritoResponseDTO responseDTO = new PeritoResponseDTO(p);
        responseDTO.addLinks(p.getId());
        return ResponseEntity.created(URI.create("/"+p.getId())).body(responseDTO);
    }

    @DeleteMapping("/peritos/{id}")
    public ResponseEntity<?> deletePerito(@PathVariable long id)
    {
        return usuarioService
                .listPeritoById(id)
                .map(data -> {
                    usuarioService.deletePerito(data);
                    return ResponseEntity.status(202).build();
                }).orElse(
                        ResponseEntity.notFound().build()
                );
    }

    @PutMapping("/peritos/{id}")
    public ResponseEntity<PeritoResponseDTO> updatePerito(@PathVariable long id, @RequestBody Perito p)
    {
        if(!Objects.equals(id, p.getId()))
        {
            return ResponseEntity.badRequest().build();
        }

        return usuarioService
                .listPeritoById(id)
                .map(data -> {
                    usuarioService.updatePerito(p);
                    PeritoResponseDTO responseDTO = new PeritoResponseDTO(p);
                    responseDTO.addLinks(p.getId());
                    return ResponseEntity.ok().body(responseDTO);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/periciandos")
    public List<PericiandoResponseDTO> findAllPericiandos()
    {
        List<Periciando> periciandos = usuarioService.listAllPericiandos();
        List<PericiandoResponseDTO> listDTO = new ArrayList<PericiandoResponseDTO>();

        for(Periciando p : periciandos)
        {
            PericiandoResponseDTO responseDTO = new PericiandoResponseDTO(p);
            responseDTO.addLinks(p.getId());
            listDTO.add(responseDTO);
        }

        return listDTO;
    }

    @GetMapping("/periciandos/{id}")
    public ResponseEntity<PericiandoResponseDTO> listPericiandoByID(@PathVariable long id)
    {
        Optional<Periciando> periciando = usuarioService.listPericiandoById(id);

        if(periciando.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            Periciando p = periciando.get();
            PericiandoResponseDTO responseDTO = new PericiandoResponseDTO(p);
            responseDTO.addLinks(p.getId());
            return ResponseEntity.ok().body(responseDTO);
        }
    }

    @PostMapping("/periciandos")
    public ResponseEntity<PericiandoResponseDTO> insertPericiando(@RequestBody PericiandoRequestDTO periciandoRequestDTO)
    {
        Periciando periciando = periciandoRequestDTO.unpack();
        Periciando p = usuarioService.insertPericiando(periciando);
        PericiandoResponseDTO responseDTO = new PericiandoResponseDTO(p);
        responseDTO.addLinks(p.getId());
        return ResponseEntity.created(URI.create("/"+p.getId())).body(responseDTO);
    }

    @DeleteMapping("/periciandos/{id}")
    public ResponseEntity<?> deletePericiando(@PathVariable long id)
    {
        return usuarioService
                .listPericiandoById(id)
                .map(data -> {
                    usuarioService.deletePericiando(data);
                    return ResponseEntity.status(202).build();
                }).orElse(
                        ResponseEntity.notFound().build()
                );
    }

    @PutMapping("/periciandos/{id}")
    public ResponseEntity<PericiandoResponseDTO> updatePericiando(@PathVariable long id, @RequestBody Periciando p)
    {
        if(!Objects.equals(id, p.getId()))
        {
            return ResponseEntity.badRequest().build();
        }

        return usuarioService
                .listPericiandoById(id)
                .map(data -> {
                    usuarioService.updatePericiando(p);
                    PericiandoResponseDTO responseDTO = new PericiandoResponseDTO(p);
                    responseDTO.addLinks(p.getId());
                    return ResponseEntity.ok().body(responseDTO);
                }).orElse(ResponseEntity.notFound().build());
    }
}
