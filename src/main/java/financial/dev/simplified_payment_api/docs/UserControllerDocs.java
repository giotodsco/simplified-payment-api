package financial.dev.simplified_payment_api.docs;

import financial.dev.simplified_payment_api.dtos.request.UserRequest;
import financial.dev.simplified_payment_api.dtos.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Gerencia os usuarios",
description = "Cria os usuarios e os lista")
public interface UserControllerDocs {

    @Operation(summary = "Cria um usuario",
            description = "Cria um usuario com as determinas informações passadas")
    @ApiResponse(
            responseCode = "201",
            description = "Usuario criado"
    )

    ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request);

    @Operation(summary = "Lista usuarios",
            description = "Pega todos os usuarios e os lista")
    @ApiResponse(
            responseCode = "200",
            description = "Usuario criado"
    )
    ResponseEntity<List<UserResponse>> listarAll();
}
