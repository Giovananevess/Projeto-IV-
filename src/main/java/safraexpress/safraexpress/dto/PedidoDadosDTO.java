package safraexpress.safraexpress.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import safraexpress.safraexpress.entity.StatusEnum;

public record PedidoDadosDTO(

        @NotEmpty(message = "O campo não pode estar vazio")
        String description,

        @NotNull
        StatusEnum status

) {
}
