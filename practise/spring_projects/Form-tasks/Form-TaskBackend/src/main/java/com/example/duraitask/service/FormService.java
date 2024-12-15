package com.example.duraitask.service;

import com.example.duraitask.model.Form;

import java.util.List;

public interface FormService {
    void addtaskService(Form t);
    List<Form> displaytaskService();
    Form searchbyid(int id);
}
