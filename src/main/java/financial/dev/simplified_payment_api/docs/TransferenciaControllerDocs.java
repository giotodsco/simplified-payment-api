package financial.dev.simplified_payment_api.docs;

import financial.dev.simplified_payment_api.dtos.request.TransactionRequest;
import financial.dev.simplified_payment_api.dtos.response.TransactionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name="Gerencia as transferencias",
description = "Cria as transferencias entre usuarios e lista as mesmas")
public interface TransferenciaControllerDocs {

    @Operation(summary = "Realiza as transferencias",
            description = "Realiza as transferencias com os IDs da conta e valor")
    @ApiResponse(
            responseCode = "201",
            description = "Transação criada"
    )

    ResponseEntity<TransactionResponse> transferencia(@RequestBody TransactionRequest request);


    @Operation(summary = "Retorna todas as transferencias",
            description = "Retorna todas as transferencias feitas, em forma de lista")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de transferencias retornada"
    )

    ResponseEntity<List<TransactionResponse>> allTranferencias();
}
