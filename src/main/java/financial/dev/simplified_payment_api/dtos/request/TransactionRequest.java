package financial.dev.simplified_payment_api.dtos.request;

import financial.dev.simplified_payment_api.model.User;

import java.math.BigDecimal;

public record TransactionRequest(BigDecimal amount, Long sender, Long receiver){
}
