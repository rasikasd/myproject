/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pccoer.jobfair.repository;

import com.pccoer.jobfair.model.JobApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rasika
 */
public interface JobApplicantRepository extends JpaRepository<JobApplicant, Long>{
    
}
