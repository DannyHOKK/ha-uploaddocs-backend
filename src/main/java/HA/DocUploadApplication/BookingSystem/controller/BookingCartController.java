package HA.DocUploadApplication.BookingSystem.controller;

import HA.DocUploadApplication.BookingSystem.Service.BookingCartService;
import HA.DocUploadApplication.core.entity.BookingCart;
import HA.DocUploadApplication.core.utils.ResultVoUtil;
import HA.DocUploadApplication.core.vo.ResultVO;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking/cart")
@CrossOrigin
public class BookingCartController {

    @Autowired
    private BookingCartService bookingCartService;

    @PostMapping("/create")
    private ResultVO createBookingCart(@RequestBody(required = true)BookingCart bookingCart){
        try{
            bookingCartService.save(bookingCart);
            return ResultVoUtil.success("");
        }catch (Exception e){
            return ResultVoUtil.error("Failed to create shopping cart");
        }
    }
}
