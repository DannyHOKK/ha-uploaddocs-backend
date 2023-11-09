package HA.DocUploadApplication.User.Service.impl;

import HA.DocUploadApplication.User.Service.UserDetailsInfoService;
import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.User.repository.UserDetailsInfoRepository;
import HA.DocUploadApplication.core.dto.UserInfoDTO;
import HA.DocUploadApplication.core.entity.User;
import HA.DocUploadApplication.core.entity.UserDetailsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
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
            User originalUser = userService.findUserById(userInfoDTO.getId()).orElseThrow();

            originalUser.setUsername(userInfoDTO.getUsername());
            originalUser.setEmail(userInfoDTO.getEmail());
            userService.updateUser(originalUser);

            UserDetailsInfo originalUserDetailsInfo = userDetailsInfoRepository.findById(userInfoDTO.getId()).orElseThrow();

            originalUserDetailsInfo.setMobile(userInfoDTO.getMobile());
            originalUserDetailsInfo.setAddress(userInfoDTO.getAddress());
            originalUserDetailsInfo.setPosition(userInfoDTO.getPosition());
            originalUserDetailsInfo.setLastModifyDt(new Date());
            if (userInfoDTO.getIcon() != null){
                originalUserDetailsInfo.setIcon(userInfoDTO.getIcon());
            }
            userDetailsInfoRepository.save(originalUserDetailsInfo);

            return "";
        }catch (Exception e){
            return "Update Failed";
        }
    }

    @Override
    public Blob getIcon(Long id) {
        UserDetailsInfo userDetailsInfo = userDetailsInfoRepository.findById(id).orElseThrow();

        return userDetailsInfo.getIcon();
    }

}
