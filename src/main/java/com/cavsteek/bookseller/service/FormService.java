package com.cavsteek.bookseller.service;

import com.cavsteek.bookseller.model.Form;

import java.util.List;

public interface FormService {
    void saveForm(Form form);

    List<Form> getFormInfo();
}
