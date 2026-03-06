package financial.dev.simplified_payment_api.service;

import financial.dev.simplified_payment_api.dtos.request.NotificationRequest;
import financial.dev.simplified_payment_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotificacao(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationRequest notificationRequest = new NotificationRequest(email, message);

        ResponseEntity<String> sendNotificacaos = restTemplate.
                postForEntity("https://util.devi.tools/api/v1/notify", notificationRequest, String.class);

        if(!(sendNotificacaos.getStatusCode() == HttpStatus.OK)){
            throw new Exception("Erro ao notificar");
        }
    }
}
