package br.com.nelson.service;

import br.com.nelson.model.PessoaModel;
import br.com.nelson.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public PessoaModel save(PessoaModel pessoaModel) {
     return pessoaRepository.save(pessoaModel);
    }

    @Override
    public void delete(PessoaModel pessoaModel) {
        pessoaRepository.delete(pessoaModel);
    }

    @Override
    public PessoaModel findOne(Integer id) {
        return pessoaRepository.findById(id).get();
    }

    @Override
    public List<PessoaModel> findAll() {
        return pessoaRepository.findAll();
    }
}
