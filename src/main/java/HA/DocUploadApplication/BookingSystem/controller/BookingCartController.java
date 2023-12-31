package HA.DocUploadApplication.BookingSystem.controller;

import HA.DocUploadApplication.BookingSystem.Service.BookingCartService;
import HA.DocUploadApplication.core.entity.BookingCart;
import HA.DocUploadApplication.core.utils.ResultVoUtil;
import HA.DocUploadApplication.core.dto.BookingCartDTO;
import HA.DocUploadApplication.core.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get")
    private ResultVO getBookingCart(@RequestParam Long userId){
        try{

            List<BookingCart> bookingCart = bookingCartService.findBookingCartDetails(userId);
            if (bookingCart == null){
                return ResultVoUtil.error("Get BookingCart Failed");
            }
            return ResultVoUtil.success("Get BookingCart Successfully", bookingCart);
        }catch (Exception e){
            return ResultVoUtil.error("Failed to get shopping cart");
        }
    }

    @PostMapping("/deleteCart")
    private ResultVO deleteBookingCart(@RequestParam Integer cartId){
        try{
            String errMsg = bookingCartService.deleteByCartId(cartId);
            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error("Failed to delete shopping cart");
            }
            return ResultVoUtil.success("delete BookingCart Successfully");
        }catch (Exception e){
            return ResultVoUtil.error("Failed to delete shopping cart");
        }
    }

}
