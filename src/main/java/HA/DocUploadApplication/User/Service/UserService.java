package HA.DocUploadApplication.User.Service;

import HA.DocUploadApplication.core.dto.SignUpDTO;
import HA.DocUploadApplication.core.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService{

    String signUp(SignUpDTO signUpDTO);

    String updateUser(User user);

    Optional<User> findUserById(Long id);

    String deleteUserById(Long id);

    List<User> findAllUser();
}
