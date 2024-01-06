package HA.DocUploadApplication.User.controller;


import HA.DocUploadApplication.User.Service.UserDetail;
import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.User.repository.UserRepository;
import HA.DocUploadApplication.core.dto.CredentialDTO;
import HA.DocUploadApplication.core.dto.JwtResponseDTO;
import HA.DocUploadApplication.core.dto.SignUpDTO;
import HA.DocUploadApplication.core.utils.JwtUtils;
import HA.DocUploadApplication.core.utils.ResultVoUtil;
import HA.DocUploadApplication.core.vo.ResultVO;
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
@CrossOrigin(origins = "https://dannyhkk.site")
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
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResultVO responseEntity(@RequestBody CredentialDTO credentialDTO){

        try {
            if (credentialDTO.getUsername() == null || credentialDTO.getPassword() == null){
                return ResultVoUtil.validFail("Please input credential");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(credentialDTO.getUsername(), credentialDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = JwtUtils.buildJwt(authentication);
            UserDetail userDetail = (UserDetail) authentication.getPrincipal();
            JwtResponseDTO jwtResponseDTO = new JwtResponseDTO(jwt, userDetail.getId(),userDetail.getUsername(),userDetail.getEmail());

            return ResultVoUtil.success("login successfully", jwtResponseDTO);
        }catch (Exception e){
            return ResultVoUtil.error("Username or Password incorrect");
        }
    }


    @PostMapping("/signup")
    public ResultVO signUp(@RequestBody SignUpDTO signUpDTO) {
        try {
            if (signUpDTO.equals("{}")){
                return ResultVoUtil.validFail("RequestBody is empty");
            }

            String errorMsg = userService.signUp(signUpDTO);

            if (errorMsg != null){
                return ResultVoUtil.error(errorMsg);
            }
            return ResultVoUtil.success("Sign up success");
        } catch (Exception e) {
            logger.error("Error:", e);
            return ResultVoUtil.error("Sign up failed");
        }
    }


}

