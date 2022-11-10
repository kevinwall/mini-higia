package br.jus.jfrn.minihigia.service;

import br.jus.jfrn.minihigia.model.Periciando;
import br.jus.jfrn.minihigia.model.Perito;
import br.jus.jfrn.minihigia.repository.PericiandoRepository;
import br.jus.jfrn.minihigia.repository.PeritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private PeritoRepository peritoRepository;

    private PericiandoRepository periciandoRepository;

    public UsuarioService(PeritoRepository peritoRepository, PericiandoRepository periciandoRepository)
    {
        this.peritoRepository = peritoRepository;
        this.periciandoRepository = periciandoRepository;
    }
    public Perito insertPerito(Perito perito)
    {
        return peritoRepository.save(perito);
    }

    public Perito updatePerito(Perito perito)
    {
        return peritoRepository.saveAndFlush(perito);
    }

    public void deletePerito(Perito perito)
    {
        peritoRepository.delete(perito);
    }


    public void deletePeritoById(long id)
    {
        peritoRepository.deleteById(id);
    }

    public List<Perito> listAllPeritos()
    {
        return peritoRepository.findAll();
    }

    public Optional<Perito> listPeritoById(long id)
    {
        return peritoRepository.findById(id);
    }

    public Periciando insertPericiando(Periciando periciando)
    {
        periciando.getRepresentante().setPericiando(periciando);
        return periciandoRepository.save(periciando);
    }

    public Periciando updatePericiando(Periciando periciando)
    {
        return periciandoRepository.saveAndFlush(periciando);
    }

    public void deletePericiando (Periciando periciando)
    {
        periciandoRepository.delete(periciando);
    }


    public void deletePericiandoById(long id)
    {
        periciandoRepository.deleteById(id);
    }

    public List<Periciando> listAllPericiandos()
    {
        return periciandoRepository.findAll();
    }

    public Optional<Periciando> listPericiandoById(long id)
    {
        return periciandoRepository.findById(id);
    }
}
