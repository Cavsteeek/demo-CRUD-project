package com.cavsteek.bookseller.service;


import com.cavsteek.bookseller.model.DeliveryInfo;

import java.util.List;

public interface DeliveryInfoService {

    DeliveryInfo saveDeliveryInfo(Long formId, String sNo, Integer numOfP);

    List<DeliveryInfo> getDeliveryInfo();
}
