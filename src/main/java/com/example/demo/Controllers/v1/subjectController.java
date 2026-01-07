package com.example.demo.Controllers.v1;

import com.example.demo.dto.SubjectDTO;
import com.example.demo.entities.Subject;
import com.example.demo.services.Impl.SubjectServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subjects")
@AllArgsConstructor
public class subjectController {

    private final SubjectServiceImpl subjectServiceImpl;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<Subject> getSubjects(){
        return subjectServiceImpl.getAllSubjects();
    }

    @GetMapping({"{id}"})
    public Subject getSubjectById(@PathVariable Long id){
        return subjectServiceImpl.getSubjectById(id);
    }

    @PostMapping
    public Subject createSubject(@RequestBody SubjectDTO subject){
        Subject subjectnew = modelMapper.map(subject, Subject.class);
        return subjectServiceImpl.createSubject(subjectnew);
    }

    @DeleteMapping({"{id}"})
    public void deleteSubject(@PathVariable Long id) {
        subjectServiceImpl.deleteSubject(id);
    }

    @PutMapping({"{id}"})
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject updatedSubject){
        return subjectServiceImpl.updateSubjectById(id, updatedSubject);
    }
}
