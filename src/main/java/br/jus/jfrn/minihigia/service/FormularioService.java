package br.jus.jfrn.minihigia.service;

import br.jus.jfrn.minihigia.model.Comorbidade;
import br.jus.jfrn.minihigia.model.Pericia;
import br.jus.jfrn.minihigia.model.PericiaMedica;
import br.jus.jfrn.minihigia.repository.PericiaMedicaRepository;
import br.jus.jfrn.minihigia.repository.PericiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormularioService
{
    private PericiaRepository periciaRepository;
    private PericiaMedicaRepository periciaMedicaRepository;

    public FormularioService(PericiaRepository periciaRepository, PericiaMedicaRepository periciaMedicaRepository)
    {
        this.periciaRepository = periciaRepository;
        this.periciaMedicaRepository = periciaMedicaRepository;
    }

    public Pericia insertPericia(Pericia pericia)
    {
        pericia.getPerito().setPericia(pericia);
        pericia.getPericiando().setPericia(pericia);

        if(pericia.getPericiando().getRepresentante() != null){
            pericia.getPericiando().getRepresentante().setPericiando(pericia.getPericiando());
        }

        return periciaRepository.save(pericia);
    }

    public Pericia updatePericia(Pericia pericia)
    {
        return periciaRepository.saveAndFlush(pericia);
    }

    public void deletePericia(Pericia pericia)
    {
        periciaRepository.delete(pericia);
    }

    public void deletePericiaById(long id)
    {
        periciaRepository.deleteById(id);
    }

    public List<Pericia> listAllPericias()
    {
        return periciaRepository.findAll();
    }

    public Optional<Pericia> listPericiaById(long id)
    {
        return periciaRepository.findById(id);
    }

    public PericiaMedica insertPericiaMedica(PericiaMedica periciaMedica)
    {
        periciaMedica.getPerito().setPericia(periciaMedica);
        periciaMedica.getPericiando().setPericia(periciaMedica);
        periciaMedica.getDoenca().setPericiaMedica(periciaMedica);

        if(!periciaMedica.getComorbidades().isEmpty())
        {
            for(Comorbidade c : periciaMedica.getComorbidades())
            {
                c.setPericiaMedica(periciaMedica);
            }
        }

        if(periciaMedica.getPericiando().getRepresentante() != null){
            periciaMedica.getPericiando().getRepresentante().setPericiando(periciaMedica.getPericiando());
        }

        return periciaMedicaRepository.save(periciaMedica);
    }

    public PericiaMedica updatePericiaMedica(PericiaMedica periciaMedica)
    {
        return periciaMedicaRepository.saveAndFlush(periciaMedica);
    }

    public void deletePericiaMedica(PericiaMedica periciaMedica)
    {
        periciaMedicaRepository.delete(periciaMedica);
    }

    public void deletePericiaMedicaById(long id)
    {
        periciaMedicaRepository.deleteById(id);
    }

    public List<PericiaMedica> listAllPericiasMedicas()
    {
        return periciaMedicaRepository.findAll();
    }

    public Optional<PericiaMedica> listPericiaMedicaById(long id)
    {
        return periciaMedicaRepository.findById(id);
    }
}
