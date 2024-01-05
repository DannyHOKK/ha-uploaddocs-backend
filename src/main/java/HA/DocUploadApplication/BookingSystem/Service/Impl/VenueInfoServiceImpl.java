package HA.DocUploadApplication.BookingSystem.Service.Impl;

import HA.DocUploadApplication.BookingSystem.Service.VenueInfoService;
import HA.DocUploadApplication.BookingSystem.repository.VenueInfoRepository;
import HA.DocUploadApplication.core.entity.VenueInfo;
import HA.DocUploadApplication.core.dto.VenueInfoDTO;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class VenueInfoServiceImpl implements VenueInfoService {

    @Autowired
    private VenueInfoRepository venueInfoRepository;

    private Logger logger = LoggerFactory.getLogger(VenueInfoServiceImpl.class);

    @Override
    public VenueInfo getVenueById(Integer venueId) {
        VenueInfo venueInfo = venueInfoRepository.findById(venueId).orElseThrow();
        if (ObjectUtils.isNotEmpty(venueInfo)){
            return venueInfo;
        }else {
            return null;
        }
    }

    @Override
    public String save(VenueInfoDTO venueInfoDTO, MultipartFile multipartFile) {

        try {
            VenueInfo venueInfo = new VenueInfo(venueInfoDTO);
            if (multipartFile.isEmpty()){
                return "Please upload photo";
            }
            byte[] photo = multipartFile.getBytes();
            venueInfo.setPhoto(photo);
            venueInfoRepository.save(venueInfo);
            return "";
        }catch (Exception e){
            logger.error("testing: " + e.getMessage());
            return "Failed to upload";
        }

    }

    @Override
    public List<VenueInfo> getVenueList() {
        List<VenueInfo> venueInfoList =venueInfoRepository.findAll();
        return venueInfoList;
    }
}
