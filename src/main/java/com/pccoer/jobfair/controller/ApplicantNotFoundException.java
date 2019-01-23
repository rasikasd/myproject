/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pccoer.jobfair.controller;

/**
 *
 * @author rasika
 */
public class ApplicantNotFoundException extends RuntimeException {
    ApplicantNotFoundException(Long id)
    {
        super("Could not find Job Applicant " + id);
    }
}
