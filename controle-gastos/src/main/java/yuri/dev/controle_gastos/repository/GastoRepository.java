package yuri.dev.controle_gastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yuri.dev.controle_gastos.model.Gasto;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}
