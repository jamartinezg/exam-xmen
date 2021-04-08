package com.exercise.mutantes.services.impl;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.mutantes.beans.DNAvalidation;
import com.exercise.mutantes.entities.Status;
import com.exercise.mutantes.process.MutantDNAValidator;
import com.exercise.mutantes.repositories.StatusRepository;
import com.exercise.mutantes.services.MutantService;

@Service
public class MutantServiceImpl implements MutantService {
	
	@Autowired
	private StatusRepository statusRepository;
	
	private static final Logger log = LoggerFactory.getLogger(MutantService.class);
	private static final int DEFAULT_SEQUENCE_SIZE_MUTANT = 4;
	private static final int DEFAULT_COUNT_SEQUENCES_MATCH_MUTANT = 2;
	private static final Pattern NITROGENOUS_BASE_PATTERN = Pattern.compile("[atcg]+", Pattern.CASE_INSENSITIVE);
	
	
	public boolean isDNAMutant(DNAvalidation dnaValidation) {
		log.debug("MutantServiceImpl - Start '{}' is a mutant' DNA", dnaValidation);
		
		Boolean isMutant = executeValidationDNA(dnaValidation);
		
		registerDNA(isMutant);
		
		return isMutant;		
	}

	private void registerDNA(Boolean isMutant) {
		Status status = new Status();
		
		if (isMutant) {	
			status.setMutantCount(1L);
		} else {
			statusRepository.save(status);
			status.setHumanCount(1L);
		}
		
		statusRepository.save(status);
	}

	private Boolean executeValidationDNA(DNAvalidation dnaValidation) {		
		Boolean isMutant = Boolean.FALSE;
				
		if (dnaValidation.getDna().size() <= DEFAULT_SEQUENCE_SIZE_MUTANT) {
			log.debug("Size is less {} of valid DNA mutant.", DEFAULT_SEQUENCE_SIZE_MUTANT);
		} else {
			char[][] dna;
			try {
				dna = loadDNAStructure(dnaValidation);
				MutantDNAValidator mutantDNAValidator = new MutantDNAValidator(dna, DEFAULT_COUNT_SEQUENCES_MATCH_MUTANT, DEFAULT_SEQUENCE_SIZE_MUTANT);
				
				isMutant = mutantDNAValidator.isMutante();	
			} catch (Exception e) {
				log.error("MutantServiceImpl - error with validadte DNA" + e.getMessage());
			}
		}
		return isMutant;
	}
	
	private char[][] loadDNAStructure(DNAvalidation dnaValidation) throws Exception {
		log.debug("Load the DNA structure in a array[][]");
		int vectorLength = dnaValidation.getDna().size();
		char[][] dna = new char[vectorLength][vectorLength];

		for (int i = 0; i < vectorLength; i++) {
			String dnaRow = dnaValidation.getDna().get(i);
			validateDNAConsistency(vectorLength, dnaRow);
			dna[i] = dnaRow.toUpperCase().toCharArray();
		}
		return dna;
	}
	
	private void validateDNAConsistency(int vectorLength, String dnaRow) throws Exception {
		if (dnaRow.length() != vectorLength) {
			throw new Exception("The length of the DNA sequences must be the same size. Expected " + vectorLength + ", found ");
		} else if (!NITROGENOUS_BASE_PATTERN.matcher(dnaRow).matches()) {
			throw new Exception("The only valid characters are A, T, C e G. Found invalida char in " + dnaRow);
		}
	}
}
