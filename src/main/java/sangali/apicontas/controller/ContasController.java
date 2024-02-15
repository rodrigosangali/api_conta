package sangali.apicontas.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sangali.apicontas.conta.Conta;
import sangali.apicontas.conta.ContaRepository;
import sangali.apicontas.conta.DadosConta;
import sangali.apicontas.conta.DadosListagemConta;

import java.util.List;

@RestController
@RequestMapping("contas")
public class ContasController {

    @Autowired
    private ContaRepository contaRepository;

    @PostMapping
    @Transactional
    public void cadastrarContas(@RequestBody DadosConta conta){

        contaRepository.save(new Conta(conta));

    }

    @GetMapping
    public List<DadosListagemConta> listarContas() {
        return contaRepository.findAll().stream().map(DadosListagemConta::new).toList();
    }

}
