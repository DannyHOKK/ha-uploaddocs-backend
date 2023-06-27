package HA.DocUploadApplication.User.Service.impl;

import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.User.repository.UserRepository;
import HA.DocUploadApplication.core.dto.SignUpDTO;
import HA.DocUploadApplication.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String signUp(SignUpDTO signUpDTO) {
        String checkName = userRepository.checkExitName(signUpDTO.getName());
        if (checkName != null){
            return "Name existed";
        }
        String checkUserName = userRepository.checkExitUserName(signUpDTO.getUsername());
        if (checkUserName != null){
            return "Username existed";
        }
        String checkEmail = userRepository.checkEmail(signUpDTO.getEmail());
        if (checkEmail != null){
            return "Email existed";
        }

        String pwd = passwordEncoder.encode(signUpDTO.getPassword());

        User user = new User(signUpDTO.getName(),signUpDTO.getUsername(),signUpDTO.getEmail(),pwd,"ROLE_USER");
        userRepository.save(user);
        return null;
    }
}
