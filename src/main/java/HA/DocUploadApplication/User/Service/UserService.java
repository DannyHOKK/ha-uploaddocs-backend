package HA.DocUploadApplication.User.Service;

import HA.DocUploadApplication.core.dto.SignUpDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void save(SignUpDTO signUpDTO);
}
