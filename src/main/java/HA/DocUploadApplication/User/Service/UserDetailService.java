package HA.DocUploadApplication.User.Service;

import HA.DocUploadApplication.User.Service.UserDetail;
import HA.DocUploadApplication.User.repository.UserRepository;
import HA.DocUploadApplication.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findAllByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not Found"+ username));

        return UserDetail.build(user);
    }

}