package financial.dev.simplified_payment_api.controller;

import financial.dev.simplified_payment_api.docs.TransferenciaControllerDocs;
import financial.dev.simplified_payment_api.dtos.request.TransactionRequest;
import financial.dev.simplified_payment_api.dtos.response.TransactionResponse;
import financial.dev.simplified_payment_api.service.TransacaoService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/transfer")
public class TransactionController implements TransferenciaControllerDocs {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransactionResponse> transferencia(@RequestBody TransactionRequest request){
        log.info("Transação ");
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.transferencia(request));
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponse>> allTranferencias(){
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.listarAll());
    }
}
