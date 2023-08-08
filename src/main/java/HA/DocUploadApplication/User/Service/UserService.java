package HA.DocUploadApplication.User.Service;

import HA.DocUploadApplication.core.dto.SignUpDTO;
import HA.DocUploadApplication.core.entity.User;

import java.util.Map;

public interface UserService{

    String signUp(SignUpDTO signUpDTO);

    Map<String,String> retrieveUserData(Integer id);

    String updateUser(User user);
}
