package safraexpress.safraexpress.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import safraexpress.safraexpress.entity.TipoUserEnum;

import java.util.List;

public record DadosUserDTO(
        @NotEmpty(message = "Digite um nome")
        String name,

        @NotEmpty
        @Email
        String email,

        @NotEmpty(message = "Digite um numero")
        String telefone,

        @NotNull
        TipoUserEnum tipouser,

        @JsonProperty("pedidos")
        List<Long> pedidoIds

) {

}
