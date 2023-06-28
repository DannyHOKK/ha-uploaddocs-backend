package HA.DocUploadApplication.User.controller;

import HA.DocUploadApplication.User.Service.UserService;
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

    private Logger logger = LoggerFactory.getLogger(DataController.class);

    @GetMapping("/showTable")
    public Map<String, String> showDataTable(@RequestParam Integer id){
        try {
            Map<String,String> userData = userService.retrieveUserData(id);
            return userData;
        }catch (Exception e){
            logger.error("error msg:" + e);
            return null;
        }
    }
}