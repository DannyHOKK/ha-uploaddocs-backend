package HA.DocUploadApplication.User.controller;

import HA.DocUploadApplication.User.Service.UserDetailsInfoService;
import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.core.dto.UserInfoDTO;
import HA.DocUploadApplication.core.entity.User;
import HA.DocUploadApplication.core.utils.ResultVoUtil;
import HA.DocUploadApplication.core.vo.ResultVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDetailsInfoService userDetailsInfoService;
    @Autowired
    private UserService userService;

    @PostMapping( value = "/update" , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseBody
    public ResultVO editUser(HttpServletRequest request, @RequestPart(value = "image", required = false) MultipartFile file, @RequestParam("userinfo") String userInfo) throws IOException, SerialException, SQLException{
        try{

            UserInfoDTO userInfoDTO = new UserInfoDTO();
            ObjectMapper objectMapper = new ObjectMapper();
            userInfoDTO = objectMapper.readValue(userInfo,UserInfoDTO.class);

            if (file != null){
                byte[] bytes = file.getBytes();
                Blob blob = new SerialBlob(bytes);
                userInfoDTO.setIcon(blob);
            }

            String errMsg = userDetailsInfoService.updateUser(userInfoDTO);
            return ResultVoUtil.success("Save successfully");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PostMapping( value = "/getIcon")
    @ResponseBody
    public ResultVO getIcon(@RequestParam Long id) throws IOException, SerialException, SQLException{
        try{
            Blob blob = userDetailsInfoService.getIcon(id);
            byte[] image = null;
            image = blob.getBytes(1, (int) blob.length());
            return ResultVoUtil.success(image);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }


    @PostMapping("/getUser")
    @ResponseBody
    public ResultVO getUser(@RequestParam Long id){
        try{
            User user = userService.findUserById(id).orElseThrow();
            UserInfoDTO userInfoDTO = new UserInfoDTO(user);
            return ResultVoUtil.success(userInfoDTO);
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
