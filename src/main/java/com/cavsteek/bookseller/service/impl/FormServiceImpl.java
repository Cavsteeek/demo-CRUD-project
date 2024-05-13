package com.cavsteek.bookseller.service.impl;

import com.cavsteek.bookseller.model.Form;
import com.cavsteek.bookseller.repository.FormRepository;
import com.cavsteek.bookseller.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {
    private FormRepository formRepository;

    @Override
    public void saveForm(Form form) {
        try {
            formRepository.save(form);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to save form" + e.getMessage());
        }
    }

    @Override
    public List<Form> getFormInfo(){
        try {
            return formRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to get Info" + e.getMessage());
        }
    }
}
