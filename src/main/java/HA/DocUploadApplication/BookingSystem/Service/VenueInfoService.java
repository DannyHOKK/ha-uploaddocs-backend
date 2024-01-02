package HA.DocUploadApplication.BookingSystem.Service;

import HA.DocUploadApplication.core.entity.VenueInfo;
import HA.DocUploadApplication.core.dto.VenueInfoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VenueInfoService {

    VenueInfo getVenueById(Integer venueId);

    String save(VenueInfoDTO venueInfoDTO, MultipartFile multipartFile);

    List<VenueInfo> getVenueList();
}
