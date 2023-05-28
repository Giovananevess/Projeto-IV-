package safraexpress.safraexpress.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record DadosUserDTO(
        @NotEmpty(message = "Digite um nome")
        String name,

        @Email
        String email,

        @NotEmpty(message = "Digite um numero")
        String telefone

) {
}
