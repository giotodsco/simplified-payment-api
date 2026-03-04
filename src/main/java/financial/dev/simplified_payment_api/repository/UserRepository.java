package financial.dev.simplified_payment_api.repository;

import financial.dev.simplified_payment_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
