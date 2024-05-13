package com.cavsteek.bookseller.service.impl;

import com.cavsteek.bookseller.model.DeliveryInfo;
import com.cavsteek.bookseller.model.Form;
import com.cavsteek.bookseller.repository.DeliveryInfoRepository;
import com.cavsteek.bookseller.repository.FormRepository;
import com.cavsteek.bookseller.service.DeliveryInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryInfoServiceImpl implements DeliveryInfoService {
    private final DeliveryInfoRepository deliveryInfoRepository;
    private final FormRepository formRepository;

    @Override
    public DeliveryInfo saveDeliveryInfo(Long formId, String sNo, Integer numOfP) {
        try {
            DeliveryInfo deliveryInfo = new DeliveryInfo();
            Form form = formRepository.findById(formId).orElseThrow(() -> new RuntimeException("Not found"));
            deliveryInfo.setSerialNo(sNo);
            deliveryInfo.setNumberOfPieces(numOfP);
            deliveryInfo.setForm(form);
            return deliveryInfoRepository.save(deliveryInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save: " + e.getMessage());
        }
    }

    @Override
    public List<DeliveryInfo> getDeliveryInfo(){
        try {
            return deliveryInfoRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to get Info" + e.getMessage());
        }
    }

}
