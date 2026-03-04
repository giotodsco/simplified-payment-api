package financial.dev.simplified_payment_api.dtos.response;

import financial.dev.simplified_payment_api.model.User;
import financial.dev.simplified_payment_api.model.enuns.TipoUser;

import java.math.BigDecimal;

public record UserResponse (Long id, String nomeCompleto, String email, String cpf, TipoUser tipoUser, BigDecimal balance) {
    public UserResponse(User user){
        this(
                user.getId(),
                user.getNomeCompleto(),
                user.getEmail(),
                user.getCpf(),
                user.getTipoUser(),
                user.getBalance()
        );
    }
}
