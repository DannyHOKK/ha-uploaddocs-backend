package HA.DocUploadApplication.BookingSystem.controller;

import HA.DocUploadApplication.BookingSystem.Service.BookingCartService;
import HA.DocUploadApplication.core.entity.BookingCart;
import HA.DocUploadApplication.core.utils.ResultVoUtil;
import HA.DocUploadApplication.core.dto.BookingCartDTO;
import HA.DocUploadApplication.core.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking/cart")
@CrossOrigin
public class BookingCartController {

    @Autowired
    private BookingCartService bookingCartService;

    @PostMapping("/create")
    private ResultVO createBookingCart(@RequestBody BookingCartDTO bookingCart){
        try{

            BookingCart bookingCart1 = bookingCartService.save(bookingCart);
            if (bookingCart1 == null){
                return ResultVoUtil.error("Create Failed");
            }
            return ResultVoUtil.success("Create Successfully", bookingCart1);
        }catch (Exception e){
            return ResultVoUtil.error("Failed to create shopping cart");
        }
    }
}
