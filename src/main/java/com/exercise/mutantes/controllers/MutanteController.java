
package com.exercise.mutantes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.mutantes.beans.DNAvalidation;
import com.exercise.mutantes.beans.GeneralRequest;
import com.exercise.mutantes.beans.GeneralResponse;
import com.exercise.mutantes.beans.StatusSummary;
import com.exercise.mutantes.services.MutantService;
import com.exercise.mutantes.services.StatusService;

@RestController
@RequestMapping("/api/mutants")
public class MutanteController {
	
	@Autowired
	 private MutantService mutantService;
	
	@Autowired
	private StatusService statusService;
	
    @PostMapping("/mutant")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<GeneralResponse> isMutant( @RequestBody GeneralRequest<DNAvalidation> request) {
    	
    	ResponseEntity<GeneralResponse> response;
    	
    	Boolean isMutant = mutantService.isDNAMutant(request.getParams());

    	if (isMutant) { 
    		response = new ResponseEntity<GeneralResponse>(new GeneralResponse(isMutant), HttpStatus.OK);
    		
    	}else {
    		response = new ResponseEntity<GeneralResponse>(new GeneralResponse(isMutant), HttpStatus.FORBIDDEN);
    	}
    	
        return response ;
    }
    
    @GetMapping("/stats")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<GeneralResponse> stats() {
    	
    	ResponseEntity<GeneralResponse> response;
    	
    	StatusSummary statusSummary= statusService.getStatus();
    	
    	response = new ResponseEntity<GeneralResponse>(new GeneralResponse(statusSummary), HttpStatus.OK);
    	
        return response ;
    }

   
}
