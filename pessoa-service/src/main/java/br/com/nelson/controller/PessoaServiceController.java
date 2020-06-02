package br.com.nelson.controller;

import br.com.nelson.model.PessoaModel;
import br.com.nelson.model.ResponseModel;
import br.com.nelson.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class PessoaServiceController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public @ResponseBody ResponseModel salvar(@RequestBody PessoaModel pessoaModel) {

        try {

            pessoaRepository.save(pessoaModel);

            return new ResponseModel(1, "Registro salvo com sucesso");

        } catch (Exception e) {

            return new ResponseModel(0, e.getMessage());
        }
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.PUT)
    public @ResponseBody ResponseModel atualizar(@RequestBody PessoaModel pessoaModel) {

        try{

            pessoaRepository.save(pessoaModel);

            return new ResponseModel(1, "Registro atualizado com sucesso");

        } catch (Exception e) {

            return new ResponseModel(0, e.getMessage());

        }
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public @ResponseBody List<PessoaModel> consultar() {

       return pessoaRepository.findAll();

    }

    @RequestMapping(value = "/pessoa/{codigo}", method = RequestMethod.GET)
    public @ResponseBody PessoaModel buscar(@PathVariable("codigo") Integer codigo) {

        Optional<PessoaModel> pessoaModelOptional = pessoaRepository.findById(codigo);

        return pessoaModelOptional.get();
    }

    @RequestMapping(value = "/pessoa/{codigo}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo) {

        Optional<PessoaModel> pessoaModelOptional = pessoaRepository.findById(codigo);

        try {

            pessoaRepository.delete(pessoaModelOptional.get());

            return new ResponseModel(1, "Registro excluído com sucesso");

        } catch (Exception e) {

            return new ResponseModel(0, e.getMessage());
        }
    }

}
