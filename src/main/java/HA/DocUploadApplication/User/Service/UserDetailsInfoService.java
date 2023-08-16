package HA.DocUploadApplication.User.Service;

import HA.DocUploadApplication.core.dto.UserInfoDTO;
import HA.DocUploadApplication.core.entity.UserDetailsInfo;


public interface UserDetailsInfoService {
    String updateUser(UserInfoDTO userInfoDTO);
}
