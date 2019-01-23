package com.pccoer.jobfair.controller;

import com.pccoer.jobfair.model.JobApplicant;
import com.pccoer.jobfair.repository.JobApplicantRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class JobApplicantController {
    
    @Autowired
    JobApplicantRepository repository;
    
    @GetMapping("/applicant")
    public List<JobApplicant> getJobApplicantList()
    {
        return repository.findAll();
    }
	
    @GetMapping("/applicant/{id}")
	JobApplicant getOneJobApplicant(@PathVariable Long id) {

		return repository.findById(id).orElse(new JobApplicant());
			//.orElseThrow(() -> new ApplicantNotFoundException(id));
	}

    @PostMapping("/applicant")
	JobApplicant newApplicant(@RequestBody JobApplicant newJobApplicant) {
		return repository.save(newJobApplicant);
	}
        
    @PutMapping("/applicant/{id}")
	JobApplicant replaceApplicant(@RequestBody JobApplicant newJobApplicant, @PathVariable Long id) {
    	if(newJobApplicant.getId() ==  null) {
    		return new JobApplicant();
    	} else {
    		return repository.save(newJobApplicant);
    	}
    		

//		return repository.findById(id)
//			.map(x -> {
//				x.setFirstName(newJobApplicant.getFirstName());
//				x.setJobRole(newJobApplicant.getJobRole());
//                                System.out.println("in map function");
//				return repository.save(x);
//			})
//			.orElseGet(() -> {
//				newJobApplicant.setId(id);
//                                System.out.println("in else function");
//				return repository.save(newJobApplicant);
//			});
	}
        
    @DeleteMapping("/applicant/{id}")
	void deleteApplicant(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
