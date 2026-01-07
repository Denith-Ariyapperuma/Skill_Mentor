package com.example.demo.Controllers.v1;

import com.example.demo.dto.SubjectDTO;
import com.example.demo.entities.Subject;
import com.example.demo.services.Impl.SubjectServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subjects")
@AllArgsConstructor
public class subjectController extends AbstractController {

    private final SubjectServiceImpl subjectServiceImpl;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Page<Subject>> getSubjects(Pageable pageable){
        Page<Subject> subjects = subjectServiceImpl.getAllSubjects(pageable);
        return sendOkResponse(subjects);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id){
        Subject subject = subjectServiceImpl.getSubjectById(id);
        return sendOkResponse(subject);
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody SubjectDTO subject){
        Subject subjectNew = modelMapper.map(subject, Subject.class);
        Subject createdSubject = subjectServiceImpl.createSubject(subjectNew);
        return sendCreatedResponse(createdSubject);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Subject> deleteSubject(@PathVariable Long id) {
        subjectServiceImpl.deleteSubject(id);
        return sendNoContentResponse();
    }

    @PutMapping({"{id}"})
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject updatedSubject){
        return sendOkResponse(subjectServiceImpl.updateSubjectById(id, updatedSubject));
    }
}
