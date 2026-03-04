package financial.dev.simplified_payment_api.dtos.response;

import financial.dev.simplified_payment_api.model.Transaction;
import financial.dev.simplified_payment_api.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(BigDecimal amount, User sender, User receiver, LocalDateTime horaTransacao){
    public TransactionResponse(Transaction transaction){
        this(
                transaction.getAmount(),
                transaction.getSender(),
                transaction.getReceiver(),
                transaction.getHoraTransaction()
        );
    }
}
