package yuri.dev.controle_gastos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yuri.dev.controle_gastos.dto.GastoDTO;
import yuri.dev.controle_gastos.model.Gasto;
import yuri.dev.controle_gastos.service.GastoService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/gastos")
@RequiredArgsConstructor
public class GastoController {

    private final GastoService service;

    @PostMapping
    public Gasto cadastrar(@RequestBody GastoDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<Gasto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/total")
    public BigDecimal total() {
        return service.calcularTotal();
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Gasto> atualizar(@PathVariable Long id, @RequestBody GastoDTO dto) {
        Gasto gastoAtualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(gastoAtualizado);
    }
}
