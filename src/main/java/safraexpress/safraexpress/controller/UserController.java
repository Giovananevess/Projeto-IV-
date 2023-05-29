package safraexpress.safraexpress.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import safraexpress.safraexpress.dto.DadosUserDTO;
import safraexpress.safraexpress.entity.User;
import safraexpress.safraexpress.service.UserService;
import java.net.MalformedURLException;

@RestController
@RequestMapping("user")

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody @Valid User dto) throws Exception {
        return userService.register(dto);
    }

}