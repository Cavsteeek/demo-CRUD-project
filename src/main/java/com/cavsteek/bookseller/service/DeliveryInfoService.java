package com.cavsteek.bookseller.service;


import com.cavsteek.bookseller.dto.DeliveryInfoDto;
import com.cavsteek.bookseller.model.DeliveryInfo;

import java.util.List;

public interface DeliveryInfoService {


    DeliveryInfo saveDeliveryInfo(Long formId, DeliveryInfoDto deliveryInfoDto);

    List<DeliveryInfo> getDeliveryInfo();
}
