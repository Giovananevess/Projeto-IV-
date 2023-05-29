package safraexpress.safraexpress.dto;

import jakarta.validation.constraints.NotNull;
import safraexpress.safraexpress.entity.StatusEnum;

public record PedidoDadosDTO(

        String description,

        @NotNull
        StatusEnum status

) {
}
