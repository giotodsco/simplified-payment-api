package financial.dev.simplified_payment_api.controller;

import financial.dev.simplified_payment_api.docs.UserControllerDocs;
import financial.dev.simplified_payment_api.dtos.request.UserRequest;
import financial.dev.simplified_payment_api.dtos.response.UserResponse;
import financial.dev.simplified_payment_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerDocs {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> listarAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarAll());
    }
}
