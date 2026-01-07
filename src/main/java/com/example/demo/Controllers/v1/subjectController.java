package com.example.demo.Controllers.v1;

import com.example.demo.entities.Subject;
import com.example.demo.services.Impl.SubjectServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subjects")
@AllArgsConstructor
public class subjectController {

    private final SubjectServiceImpl subjectServiceImpl;

    @GetMapping
    public List<Subject> getSubjects(){
        return subjectServiceImpl.getAllSubjects();
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject){
        return subjectServiceImpl.createSubject(subject) ;
    }

    @DeleteMapping({"id"})
    public void deleteSubject(@PathVariable Long id) {
        subjectServiceImpl.deleteSubject(id);
    }

    @PutMapping({"id"})
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject updatedSubject){
        return subjectServiceImpl.updateSubjectById(id, updatedSubject);
    }
}
