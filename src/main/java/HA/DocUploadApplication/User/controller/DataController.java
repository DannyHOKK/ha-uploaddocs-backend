package HA.DocUploadApplication.User.controller;

import HA.DocUploadApplication.User.Service.UserService;
import HA.DocUploadApplication.core.utils.ResultVoUtil;
import HA.DocUploadApplication.core.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DataController {

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(DataController.class);

    @GetMapping("/showTable")
    public ResultVO showDataTable(@RequestParam Integer id){
        try {
            // have not complete
            return ResultVoUtil.success("show success");
        }catch (Exception e){
            logger.error("error msg:" + e);
            return ResultVoUtil.error(e);
        }
    }

    @GetMapping("/checkUpdate")
    public ResultVO update(){
        try {
            return ResultVoUtil.success("update successfully");
        }catch (Exception e){
            logger.error("error msg:" + e);
            return ResultVoUtil.error("update fail");
        }
    }
}
