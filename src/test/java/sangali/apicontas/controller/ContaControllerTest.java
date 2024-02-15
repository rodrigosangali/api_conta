package sangali.apicontas.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sangali.apicontas.conta.Conta;
import sangali.apicontas.conta.ContaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ContaControllerTest {

    @Mock
    ContaRepository contaRepository;
    @InjectMocks
    ContasController contasController;

    MockMvc mockMvc;

    List<Conta> listContas;

    @BeforeEach
    void setup(){
        // metodo basido de preencher um objeto
        Conta conta = new Conta(1L,LocalDate.now(), "testeCo", new BigDecimal(23));

        listContas = new ArrayList<>();

        listContas.add(conta);
        // utilizando o @builder na classe conta e adicionando
        listContas.add( Conta.builder()
                .id(2L)
                .data(LocalDate.now())
                .descricao("testeCA")
                .valor(new BigDecimal(45))
                .build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(contasController)
                .build();
    }


    @Test
    void deveListarContas() throws Exception {

        when(contaRepository.findAll()).thenReturn(listContas);

        // igual a status 200
        mockMvc.perform(get("/contas"))
                .andExpect(status().isOk());


    }

}
