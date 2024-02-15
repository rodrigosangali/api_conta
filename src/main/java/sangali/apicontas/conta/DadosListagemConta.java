package sangali.apicontas.conta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemConta(
        LocalDate data,
        String descricao,
        BigDecimal valor) {

    public DadosListagemConta(Conta conta){
        this(conta.getData(), conta.getDescricao(), conta.getValor());
    }
}
