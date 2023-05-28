package safraexpress.safraexpress.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import safraexpress.safraexpress.dto.PedidoDadosDTO;
import safraexpress.safraexpress.service.PedidoService;

@RestController
@RequestMapping("/pedido")

public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody @Valid PedidoDadosDTO dto) {
        return pedidoService.register(dto);
    }

}
