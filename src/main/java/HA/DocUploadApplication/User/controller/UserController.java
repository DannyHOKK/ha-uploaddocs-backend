package HA.DocUploadApplication.User.controller;

import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.core.entity.User;
import HA.DocUploadApplication.core.utils.ResultVoUtil;
import HA.DocUploadApplication.core.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @RequestMapping("update")
    public ResultVO editUser(@RequestBody User user){
        try{
            String msg = userService.updateUser(user);
            return ResultVoUtil.success(msg);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }
}
