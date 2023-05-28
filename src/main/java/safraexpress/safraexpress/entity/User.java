package safraexpress.safraexpress.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import safraexpress.safraexpress.dto.DadosUserDTO;
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

    @Column(nullable = false)
    @Length(max = 90)
    private String name;

    @Email
    private String email;

    private String telefone;

    @Enumerated(EnumType.STRING)
    private TipoUserEnum tipouser;

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
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.tipouser = dto.tipouser();
        this.endereco = getEndereco();
    }

    public User(DadosUserDTO dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.tipouser = dto.tipouser();
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
