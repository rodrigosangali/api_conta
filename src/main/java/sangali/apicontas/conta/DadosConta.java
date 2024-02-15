package sangali.apicontas.conta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosConta(
    LocalDate data,
    String descricao,
    BigDecimal valor){

}
