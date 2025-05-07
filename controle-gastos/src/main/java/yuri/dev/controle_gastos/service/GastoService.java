package yuri.dev.controle_gastos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yuri.dev.controle_gastos.dto.GastoDTO;
import yuri.dev.controle_gastos.model.Gasto;
import yuri.dev.controle_gastos.repository.GastoRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GastoService {

    private final GastoRepository repository;

    public Gasto salvar(GastoDTO dto) {
        Gasto gasto = new Gasto(null, dto.descricao(), dto.valor(), dto.data());
        return repository.save(gasto);
    }

    public List<Gasto> listarTodos() {
        return repository.findAll();
    }

    public BigDecimal calcularTotal() {
        return repository.findAll().stream()
                .map(Gasto::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    public Gasto atualizar(Long id, GastoDTO dto) {
        Gasto gasto = repository.findById(id).orElseThrow(() -> new RuntimeException("Gasto não encontrado")); // Primeiro encontra pelo id

        // Depois atualiza os valores
        gasto.setDescricao(dto.descricao());
        gasto.setValor(dto.valor());
        gasto.setData(dto.data());

        return repository.save(gasto);
    }
}
