package com.example.demo.services;

import com.example.demo.entities.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();
    Subject createSubject(Subject subject);
    Subject getSubjectById(Long id);
    Subject updateSubjectById(Long id, Subject updatedSubject);
    void deleteSubject(Long id);
}
