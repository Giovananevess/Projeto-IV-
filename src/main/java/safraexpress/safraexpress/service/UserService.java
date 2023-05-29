package safraexpress.safraexpress.service;

import com.google.gson.Gson;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import safraexpress.safraexpress.dto.DadosUserDTO;
import safraexpress.safraexpress.entity.User;
import safraexpress.safraexpress.repository.PedidoRepository;
import safraexpress.safraexpress.repository.UserRepository;
import safraexpress.safraexpress.response.ResponseModelMessage;
import safraexpress.safraexpress.response.ResponseModelObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    public ResponseEntity<?> register(@RequestBody @Valid User user) throws Exception {

        if (userRepository.existsByName(user.getName())) {
            return new ResponseEntity<>(new ResponseModelMessage("Esse usuário já está cadastrado"), HttpStatus.BAD_REQUEST);
        }
        URL url = new URL("https://viacep.com.br/ws/" + user.getCep() + "/json/?callback=callback_name");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String cep = "";
        StringBuilder jsonCep = new StringBuilder();
        while ((cep = br.readLine()) != null) {
            jsonCep.append(cep);
        }
        System.out.println(jsonCep.toString());
//        User userAux = new Gson().fromJson(String.valueOf(jsonCep), User.class);
//        user.setCep(userAux.getCep());
//        user.setLogradouro(userAux.getLogradouro());
//        user.setComplemento(userAux.getComplemento());
//        user.setBairro(userAux.getBairro());
//        user.setLocalidade(userAux.getLocalidade());
//        user.setUf(userAux.getUf());
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseModelObject("Usuário cadastrado com sucesso", user), HttpStatus.OK);
    }


}
