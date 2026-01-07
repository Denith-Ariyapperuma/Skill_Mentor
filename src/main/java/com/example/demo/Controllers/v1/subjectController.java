package com.example.demo.Controllers.v1;

import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subjects")

public class subjectController {

    private final List<String> Subjects = new ArrayList<>(){{;
        add("Math");
        add("History");
        add("English");
    }};

    @GetMapping
    public String getSubjects(){
        return Subjects.toString();
    }

    @PostMapping
    public String createSubject(@RequestBody String subject){
        Subjects.add(subject);
        return "Create a new subject:" +subject;
    }

    @DeleteMapping
    public String deleteSubject(@RequestBody String subject) {
        Subjects.remove(subject);
        return "Delete a subject successfully :" +subject;
    }

    @PutMapping({"index"})
    public String updateSubject(@RequestBody String oldSubject, @RequestBody String newSubject) {
        int index = Subjects.indexOf(oldSubject);
        if (index != -1) {
            Subjects.set(index, newSubject);
            return "Update an existing subject: " +newSubject;
        } else {
            return "Subject not found:" +oldSubject;
        }
    }
}
