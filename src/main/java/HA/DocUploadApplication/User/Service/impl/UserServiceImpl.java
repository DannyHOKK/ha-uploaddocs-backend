package HA.DocUploadApplication.User.Service.impl;

import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.User.repository.UserRepository;
import HA.DocUploadApplication.core.dto.SignUpDTO;
import HA.DocUploadApplication.core.entity.User;
import HA.DocUploadApplication.core.entity.UserDetailsInfo;
import io.netty.util.internal.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Optional;

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

        String checkUserName = userRepository.checkExitUserName(signUpDTO.getUsername());
        if (checkUserName != null){
            return "Username existed";
        }
        String checkEmail = userRepository.checkEmail(signUpDTO.getEmail());
        if (checkEmail != null){
            return "Email existed";
        }

        String pwd = passwordEncoder.encode(signUpDTO.getPassword());
        UserDetailsInfo userDetailsInfo = new UserDetailsInfo();
        userDetailsInfo.setCreateDt(new Date());
        userDetailsInfo.setLastModifyDt(new Date());
        User user = new User(signUpDTO.getUsername(),signUpDTO.getEmail(),pwd,"ROLE_USER",userDetailsInfo);
        userRepository.save(user);
        return null;
    }



    @Override
    public String updateUser(User user) {
        try {
            User originalUser = userRepository.findById(user.getId()).orElseThrow();
            if (!ObjectUtils.isEmpty(user)){
                originalUser.setUsername(user.getUsername());
                originalUser.setEmail(user.getEmail());
            }else {
                return "Username/Email cant be empty";
            }
            userRepository.save(originalUser);
            return "";
        }catch (Exception e){
            return "Save Failed";
        }
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public String deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
            return "";
        }catch (Exception e){
            return "Delete Failed";
        }
    }

}
