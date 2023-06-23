package HA.DocUploadApplication.User.Service.impl;

import HA.DocUploadApplication.User.Service.UserDetail;
import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.User.repository.UserRepository;
import HA.DocUploadApplication.core.dto.SignUpDTO;
import HA.DocUploadApplication.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findAllByEmail(email);

        return UserDetail.build(user);
    }

    @Override
    public void save(SignUpDTO signUpDTO) {
        User user = new User(signUpDTO.getName(),signUpDTO.getUsername(),signUpDTO.getEmail(),signUpDTO.getPassword(),"ROLE_USER");
        userRepository.save(user);
    }
}
