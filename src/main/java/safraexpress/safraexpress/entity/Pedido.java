package safraexpress.safraexpress.entity;
import jakarta.persistence.*;
import lombok.*;
import safraexpress.safraexpress.dto.PedidoDadosDTO;
import java.time.LocalDate;
import java.util.List;

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

        @Enumerated(EnumType.STRING)
        private StatusEnum status;

        private LocalDate date;


        @ManyToMany
        @JoinTable(
                name = "tb_pedido_user",
                joinColumns = {@JoinColumn(name = "id_pedido", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id")}
        )
        private List<User> users;

        public Pedido(PedidoDadosDTO dto, List<User> users) {
                this.users = users;
                this.description = dto.description();
                this.status = dto.status();
                this.date = LocalDate.now();
        }
        public Pedido(PedidoDadosDTO dto) {
                this.description = dto.description();
                this.status = dto.status();
                this.date = LocalDate.now();
        }

}
