package financial.dev.simplified_payment_api.dtos.request;

import financial.dev.simplified_payment_api.model.enuns.TipoUser;

import java.math.BigDecimal;

public record UserRequest(String name, String email, String cpf, String senha, TipoUser tipoUser, BigDecimal balance) {
}
