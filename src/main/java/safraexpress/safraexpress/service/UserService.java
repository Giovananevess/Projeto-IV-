package safraexpress.safraexpress.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import safraexpress.safraexpress.dto.DadosUserDTO;
import safraexpress.safraexpress.entity.Pedido;
import safraexpress.safraexpress.entity.User;
import safraexpress.safraexpress.repository.PedidoRepository;
import safraexpress.safraexpress.repository.UserRepository;
import safraexpress.safraexpress.response.ResponseModelMessage;
import safraexpress.safraexpress.response.ResponseModelObject;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    public ResponseEntity<?> register(@RequestBody @Valid DadosUserDTO dto) {
        List<Pedido> pedidos = pedidoRepository.findByIdIn(dto.pedidoIds());
        if (userRepository.existsByName(dto.name())) {
            return new ResponseEntity<>(new ResponseModelMessage("Esse usuário já está cadastrado"), HttpStatus.BAD_REQUEST);
        }
        User user = new User(dto);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseModelObject("Usuário cadastrado com sucesso", user), HttpStatus.OK);
    }


}

