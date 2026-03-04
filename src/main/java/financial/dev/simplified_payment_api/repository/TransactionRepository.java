package financial.dev.simplified_payment_api.repository;

import financial.dev.simplified_payment_api.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
