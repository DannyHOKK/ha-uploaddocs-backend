package HA.DocUploadApplication.User.Service;

import HA.DocUploadApplication.core.dto.SignUpDTO;

import java.util.Map;

public interface UserService{

    String signUp(SignUpDTO signUpDTO);

    Map<String,String> retrieveUserData(Integer id);
}
