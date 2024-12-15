package com.example.duraitask.service;

import com.example.duraitask.model.Form;
import com.example.duraitask.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FormServiceImpl implements FormService{
    @Autowired
    FormRepository formRepository;
    public void addtaskService(Form t) {
        formRepository.save(t);
    }

    public List<Form> displaytaskService() {
        return formRepository.findAll();
    }

    public Form searchbyid(int id) {
        return formRepository.findById(id).orElse(null);
    }
}
