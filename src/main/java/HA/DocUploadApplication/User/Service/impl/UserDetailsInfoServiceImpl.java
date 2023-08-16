package HA.DocUploadApplication.User.Service.impl;

import HA.DocUploadApplication.User.Service.UserDetailsInfoService;
import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.User.repository.UserDetailsInfoRepository;
import HA.DocUploadApplication.core.dto.UserInfoDTO;
import HA.DocUploadApplication.core.entity.User;
import HA.DocUploadApplication.core.entity.UserDetailsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserDetailsInfoServiceImpl implements UserDetailsInfoService {

    @Autowired
    private UserDetailsInfoRepository userDetailsInfoRepository;
    @Autowired
    private UserService userService;

    @Override
    public String updateUser(UserInfoDTO userInfoDTO) {
        try {
            if (userInfoDTO.getEmail().isEmpty() || userInfoDTO.getUsername().isEmpty()) {
                return "Email/Username cant be empty";
            }
            User user = userService.findUserById(userInfoDTO.getId()).orElseThrow();

            user.setUsername(userInfoDTO.getUsername());
            user.setEmail(userInfoDTO.getEmail());
            userService.updateUser(user);

            UserDetailsInfo userDetailsInfo = userDetailsInfoRepository.findById(userInfoDTO.getId()).orElseThrow();

            userDetailsInfo.setMobile(userInfoDTO.getMobile());
            userDetailsInfo.setAddress(userInfoDTO.getAddress());
            userDetailsInfo.setPosition(userInfoDTO.getPosition());
            userDetailsInfo.setLastModifyDt(new Date());
            userDetailsInfo.setIcon(userDetailsInfo.getIcon());
            userDetailsInfoRepository.save(userDetailsInfo);

            return "";
        }catch (Exception e){
            return "Update Failed";
        }
    }

}
