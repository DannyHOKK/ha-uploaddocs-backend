package HA.DocUploadApplication.User.controller;


import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.core.dto.SignUpDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
//
//    @PostMapping("/login")
//    public ResponseEntity<?> responseEntity(@RequestBody CredentialDTO credentialDTO){
//        return ResponseEntity.ok();
//    }

    @PostMapping("/signUp")
    public String signUp(@RequestBody SignUpDTO signUpDTO){
        try{
            userService.save(signUpDTO);
            return "Sign Up successfully";
        }catch (Exception e){
            logger.error("ERROR:",e);
            return "Sign Up fail";
        }

    }
}
