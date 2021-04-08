package com.exercise.mutantes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.mutantes.beans.StatusSummary;
import com.exercise.mutantes.repositories.StatusRepository;
import com.exercise.mutantes.services.StatusService;

@Service
public class StatusServicesImpl implements StatusService {
	
	@Autowired
	private StatusRepository statusRepository;
	
	public StatusSummary getStatus() {
		
		StatusSummary statusSummary = statusRepository.findStatusSummary();
		
		return statusSummary;
	}

}
