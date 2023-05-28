package safraexpress.safraexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import safraexpress.safraexpress.dto.PedidoDadosDTO;
import safraexpress.safraexpress.entity.Pedido;
import safraexpress.safraexpress.entity.User;
import safraexpress.safraexpress.repository.PedidoRepository;
import safraexpress.safraexpress.repository.UserRepository;
import safraexpress.safraexpress.response.ResponseModelMessage;
import safraexpress.safraexpress.response.ResponseModelObject;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> register(@RequestBody PedidoDadosDTO dto) {
        if (pedidoRepository.existsByDescription(dto.description())){
            return new ResponseEntity<>(new ResponseModelMessage("Esse pedido já existe"), HttpStatus.BAD_REQUEST);
        }
        Pedido pedido = new Pedido(dto);
        pedidoRepository.save(pedido);
        return new ResponseEntity<>(new ResponseModelObject("Pedido cadastrado", pedido), HttpStatus.OK);
    }
}
