package financial.dev.simplified_payment_api.model;

import financial.dev.simplified_payment_api.dtos.request.UserRequest;
import financial.dev.simplified_payment_api.model.enuns.TipoUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUser tipoUser;

    private BigDecimal balance;

    public User(UserRequest userRequest){
        this.nomeCompleto = userRequest.name();
        this.email = userRequest.email();
        this.cpf = userRequest.cpf();
        this.senha = userRequest.senha();
        this.tipoUser = userRequest.tipoUser();
        this.balance = userRequest.balance();
    }

}
