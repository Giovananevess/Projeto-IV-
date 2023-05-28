package safraexpress.safraexpress.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import safraexpress.safraexpress.enums.StatusEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Table(name = "tb_entrega")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "description", unique = true, nullable = false, columnDefinition = "Text")
    private String description;
    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));


}
