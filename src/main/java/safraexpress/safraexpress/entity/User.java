package safraexpress.safraexpress.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import safraexpress.safraexpress.dto.DadosUserDTO;


@Table(name = "tb_user")
@Entity
@Getter
@NoArgsConstructor
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 90)
    private String name;

    @Email
    private String email;

    private String telefone;

    @Enumerated(EnumType.STRING)
    private TipoUserEnum tipouser;

//    @Embedded
//    private Endereco endereco;

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;


    //    @ManyToMany
//    @JoinTable(
//            name = "tb_user_pedido",
//            joinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "id_pedido", referencedColumnName = "id")}
//    )
//    private List<Pedido> pedidos;
//
//    public User(DadosUserDTO dto, List<Pedido> pedidos) {
//        this.pedidos = pedidos;
//        this.name = dto.name();
//        this.email = dto.email();
//        this.telefone = dto.telefone();
//        this.tipouser = dto.tipouser();
//        this.endereco = getEndereco();
//    }
    public User(DadosUserDTO dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.tipouser = dto.tipouser();
//        this.endereco = new Endereco(dto.endereco());
        this.cep = dto.cep();
    }

}