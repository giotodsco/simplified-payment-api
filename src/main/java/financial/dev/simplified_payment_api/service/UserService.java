package financial.dev.simplified_payment_api.service;

import financial.dev.simplified_payment_api.model.User;
import financial.dev.simplified_payment_api.model.enuns.TipoUser;
import financial.dev.simplified_payment_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validarTransacao(User sender, BigDecimal amount) {
        if (sender.getTipoUser().equals(TipoUser.LOJISTA)) {
            throw new RuntimeException("Erro: Usuario lojista não pode fazer transações");
        }
        if (sender.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Erro: Saldo insuficiente");
        }

    }

    public User findUserById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    public User save(User user){
        return repository.save(user);
    }
}
