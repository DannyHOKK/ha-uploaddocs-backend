package HA.DocUploadApplication.User.Service.impl;

import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.User.repository.UserRepository;
import HA.DocUploadApplication.core.dto.SignUpDTO;
import HA.DocUploadApplication.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private EntityManager entityManager;

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

    @Override
    public Map<String,String> retrieveUserData(Integer id) {

        Map<String, String> userData = userRepository.findUserById(id);
        return userData;
    }
}
