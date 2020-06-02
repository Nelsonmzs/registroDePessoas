package br.com.nelson.service;


import br.com.nelson.model.PessoaModel;

import java.util.List;

public interface PessoaService {

    PessoaModel save(PessoaModel pessoaModel);

    void delete(PessoaModel pessoaModel);

    PessoaModel findOne(Integer id);

    List<PessoaModel> findAll();
}
