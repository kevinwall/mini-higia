package br.jus.jfrn.minihigia.service;

import br.jus.jfrn.minihigia.model.Comorbidade;
import br.jus.jfrn.minihigia.model.Doenca;
import br.jus.jfrn.minihigia.repository.ComorbidadeRepository;
import br.jus.jfrn.minihigia.repository.DoencaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoencaService
{
    private DoencaRepository doencaRepository;

    private ComorbidadeRepository comorbidadeRepository;

    public DoencaService(DoencaRepository doencaRepository, ComorbidadeRepository comorbidadeRepository)
    {
        this.doencaRepository = doencaRepository;
        this.comorbidadeRepository = comorbidadeRepository;
    }

    public Doenca insertDoenca(Doenca doenca)
    {
        return doencaRepository.save(doenca);
    }

    public Doenca updateDoenca(Doenca doenca)
    {
        return doencaRepository.saveAndFlush(doenca);
    }

    public void deleteDoenca(Doenca doenca)
    {
        doencaRepository.delete(doenca);
    }


    public void deleteDoencaById(long id)
    {
        doencaRepository.deleteById(id);
    }

    public List<Doenca> listAllDoencas()
    {
        return doencaRepository.findAll();
    }

    public Optional<Doenca> listDoencaById(long id)
    {
        return doencaRepository.findById(id);
    }

    public Comorbidade insertComorbidade(Comorbidade comorbidade)
    {
        return comorbidadeRepository.save(comorbidade);
    }

    public Comorbidade updateComorbidade(Comorbidade comorbidade)
    {
        return comorbidadeRepository.saveAndFlush(comorbidade);
    }

    public void deleteComorbidade(Comorbidade comorbidade)
    {
        comorbidadeRepository.delete(comorbidade);
    }


    public void deleteComorbidadeById(long id)
    {
        comorbidadeRepository.deleteById(id);
    }

    public List<Comorbidade> listAllComorbidades()
    {
        return comorbidadeRepository.findAll();
    }

    public Optional<Comorbidade> listComorbidadeById(long id)
    {
        return comorbidadeRepository.findById(id);
    }
}
