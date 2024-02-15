package sangali.apicontas.conta;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Builder
@Table(name = "conta")
@Entity(name = "Conta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private String descricao;
    private BigDecimal valor;

    public Conta(DadosConta conta) {
        this.data = conta.data();
        this.descricao = conta.descricao();
        this.valor = conta.valor();
    }
}
