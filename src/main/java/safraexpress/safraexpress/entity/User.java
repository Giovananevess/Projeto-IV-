package safraexpress.safraexpress.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import safraexpress.safraexpress.dto.DadosUserDTO;
import safraexpress.safraexpress.enums.StatusEnum;
import safraexpress.safraexpress.enums.TipoUserEnum;
import java.util.List;


@Table(name = "tb_user")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private TipoUserEnum tipoUser;

    @Email
    private String email;

    private String telefone;

    @Embedded
    private Endereco endereco;

    @ManyToMany
    @JoinTable(
            name = "tb_user_pedido",
            joinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_pedido", referencedColumnName = "id")}
    )
    private List<Pedido> pedidos;

    public User(DadosUserDTO dto, List<Pedido> pedidos) {
        this.pedidos = pedidos;
        this.name = dto.name();
        this.tipoUser = getTipoUser();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.endereco = getEndereco();
    }

    public User(DadosUserDTO dto) {
        this.name = dto.name();
        this.tipoUser = getTipoUser();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.endereco = getEndereco();

    }

    public void update(DadosUserDTO dto) {
        if (dto.name() != null) {
            this.name = dto.name();
        }
        if (dto.email() != null) {
            this.email = dto.email();
        }
        if (dto.telefone() != null) {
            this.telefone = dto.telefone();
        }
    }



}
