package HA.DocUploadApplication.User.controller;


import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.User.repository.UserRepository;
import HA.DocUploadApplication.core.dto.CredentialDTO;
import HA.DocUploadApplication.core.dto.SignUpDTO;
import HA.DocUploadApplication.core.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> responseEntity(@RequestBody CredentialDTO credentialDTO){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(credentialDTO.getUsername(), credentialDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String password = passwordEncoder.encode(credentialDTO.getPassword());

        return ResponseEntity.ok(authentication);
    }


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

