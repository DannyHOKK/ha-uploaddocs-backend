package HA.DocUploadApplication.BookingSystem.controller;

import HA.DocUploadApplication.BookingSystem.Service.VenueInfoService;
import HA.DocUploadApplication.core.entity.VenueInfo;
import HA.DocUploadApplication.core.utils.ResultVoUtil;
import HA.DocUploadApplication.core.vo.ResultVO;
import HA.DocUploadApplication.core.dto.VenueInfoDTO;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/booking/venue")
@CrossOrigin
public class VenueInfoController {

    @Autowired
    private VenueInfoService venueInfoService;

    @PostMapping(value = "/createVenue", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResultVO createVenueInfo(@ModelAttribute VenueInfoDTO venueInfoDTO, @RequestPart(value = "bookingVenue")MultipartFile multipartFile){
        try {
            String errMsg = venueInfoService.save(venueInfoDTO, multipartFile);
            return ResultVoUtil.success();
        }catch (Exception e){
            return ResultVoUtil.error("Failed to Create VenueInfo");
        }
    }

    @GetMapping("/getVenue")
    public ResultVO getVenueInfoById(@RequestParam Integer venueId){
        try {
            VenueInfo venueInfo = venueInfoService.getVenueById(venueId);
            if (ObjectUtils.isEmpty(venueInfo)){
                return ResultVoUtil.error("Failed to get VenueInfo");
            }
            return ResultVoUtil.success(venueInfo);
        }catch (Exception e){
            return ResultVoUtil.error("Failed to get VenueInfo");
        }
    }
    @GetMapping("/getVenueList")
    public ResultVO getVenueInfoList(){
        try {
            List<VenueInfo> venueInfoList = venueInfoService.getVenueList();
            if (ObjectUtils.isEmpty(venueInfoList)){
                return ResultVoUtil.error("Failed to get VenueInfoList");
            }
            return ResultVoUtil.success(venueInfoList);
        }catch (Exception e){
            return ResultVoUtil.error("Failed to get VenueInfoList");
        }
    }
}
