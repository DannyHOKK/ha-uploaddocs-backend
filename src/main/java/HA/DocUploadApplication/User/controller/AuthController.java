package HA.DocUploadApplication.User.controller;


import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.core.dto.SignUpDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

//    @PostMapping("/login")
//    public ResponseEntity<?> responseEntity(@RequestBody CredentialDTO credentialDTO){
//        return ResponseEntity.ok();
//    }


    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpDTO signUpDTO) {
        try {
            if (signUpDTO.equals("{}")){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("RequestBody is empty");
            }

            String errorMsg = userService.signUp(signUpDTO);

            if (errorMsg != null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Sign up successful");
        } catch (Exception e) {
            logger.error("Error:", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sign up failed");
        }
    }


}

