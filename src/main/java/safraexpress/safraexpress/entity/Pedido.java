package safraexpress.safraexpress.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Table(name = "tb_pedido")
@Entity
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Pedido {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "description", unique = true, nullable = false, columnDefinition = "Text")
        private String description;

        private String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));



}
