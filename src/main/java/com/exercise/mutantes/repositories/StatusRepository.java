package com.exercise.mutantes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exercise.mutantes.beans.StatusSummary;
import com.exercise.mutantes.entities.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
	
	@Query(" SELECT new com.exercise.mutantes.beans.StatusSummary (  "
		 + "         count(mutantCount),                             "
		 + "         count(humanCount)                               "
		 + "     ) "
		 + "  FROM Status status")
	StatusSummary findStatusSummary();
	
}
