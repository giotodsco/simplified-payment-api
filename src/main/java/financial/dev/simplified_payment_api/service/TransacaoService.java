package financial.dev.simplified_payment_api.service;

import financial.dev.simplified_payment_api.model.Transaction;
import financial.dev.simplified_payment_api.model.enuns.TipoUser;
import financial.dev.simplified_payment_api.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void validarTransacao(Transaction transaction){
        if(transaction.getSender().getTipoUser().equals(TipoUser.LOJISTA)){
            throw new RuntimeException("Erro: Usuario lojista não pode fazer transações");
        }
        if(transaction.getSender().getBalance().doubleValue() <= 0){
            throw new RuntimeException("Erro: Saldo insuficiente");
        }
        if(transaction.getAmount().doubleValue() <= 0){
            throw new RuntimeException("Erro: Valor da transação tem que ser maior que 0");
        }
    }
}
