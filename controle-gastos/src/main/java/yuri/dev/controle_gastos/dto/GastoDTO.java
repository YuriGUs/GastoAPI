package yuri.dev.controle_gastos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GastoDTO(String descricao, BigDecimal valor, LocalDate data) {
}
