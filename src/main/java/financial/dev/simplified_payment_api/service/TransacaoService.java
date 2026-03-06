package financial.dev.simplified_payment_api.service;

import financial.dev.simplified_payment_api.dtos.request.TransactionRequest;
import financial.dev.simplified_payment_api.dtos.response.TransactionResponse;
import financial.dev.simplified_payment_api.model.Transaction;
import financial.dev.simplified_payment_api.model.User;
import financial.dev.simplified_payment_api.model.enuns.TipoUser;
import financial.dev.simplified_payment_api.repository.TransactionRepository;
import financial.dev.simplified_payment_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransacaoService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService service;

    @Autowired
    private RestTemplate restTemplate;


    public TransactionResponse transferencia(TransactionRequest request){
        User sender = service.findUserById(request.sender());
        User receiver = service.findUserById(request.receiver());

        service.validarTransacao(sender, request.amount());
        boolean isAuthorized = this.authorizeTransacao(sender, request.amount());
        if(!isAuthorized){
            throw new RuntimeException("Não autorizada");
        }

        Transaction transaction = new Transaction();
        transaction.setAmount(request.amount());
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setHoraTransaction(LocalDateTime.now());


        sender.setBalance(sender.getBalance().subtract(request.amount()));
        receiver.setBalance(receiver.getBalance().add(request.amount()));

        service.save(sender);
        service.save(receiver);
        transactionRepository.save(transaction);

        return new TransactionResponse(transaction);
    }
    public boolean authorizeTransacao(User sender, BigDecimal amount){
        ResponseEntity<Map> authorizationResponse = restTemplate.
                getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);

        if(authorizationResponse.getStatusCode() == HttpStatus.OK){
            String message = (String) authorizationResponse.getBody().get("status");
            return "success".equalsIgnoreCase(message);
        } else return false;
    }
}
