package HA.DocUploadApplication.User.controller;

import HA.DocUploadApplication.User.Service.UserDetailsInfoService;
import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.core.dto.UserInfoDTO;
import HA.DocUploadApplication.core.entity.User;
import HA.DocUploadApplication.core.utils.ResultVoUtil;
import HA.DocUploadApplication.core.vo.ResultVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDetailsInfoService userDetailsInfoService;
    @Autowired
    private UserService userService;

    @PostMapping("/update")
    @ResponseBody
    public ResultVO editUser(HttpServletRequest request, @RequestPart("image") MultipartFile file, @RequestParam("userinfo") String userInfo) throws IOException, SerialException, SQLException{
        try{

            byte[] bytes = file.getBytes();
            Blob blob = new SerialBlob(bytes);
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            ObjectMapper objectMapper = new ObjectMapper();
            userInfoDTO = objectMapper.readValue(userInfo,UserInfoDTO.class);
            if (userInfoDTO == null){
                return ResultVoUtil.error("Cannot be empty");
            }
            userInfoDTO.setIcon(blob);
            String errMsg = userDetailsInfoService.updateUser(userInfoDTO);
            return ResultVoUtil.success("Save successfully");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PostMapping("/getUser")
    @ResponseBody
    public ResultVO getUser(@RequestParam Long id){
        try{
            User user = userService.findUserById(id).orElseThrow();
            return ResultVoUtil.success(user);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PostMapping("/deleteUser")
    @ResponseBody
    public ResultVO deleteUser(@RequestParam Long id){
        try{
            String msg = userService.deleteUserById(id);
            if(!msg.isEmpty()){
                return ResultVoUtil.error(msg);
            }
            return ResultVoUtil.success("delete Successfully");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }
}
