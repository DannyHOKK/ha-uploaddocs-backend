package HA.DocUploadApplication.User.Service;

import HA.DocUploadApplication.core.dto.UserInfoDTO;

import java.sql.Blob;


public interface UserDetailsInfoService {
    String updateUser(UserInfoDTO user);

    Blob getIcon(Long id);
}
