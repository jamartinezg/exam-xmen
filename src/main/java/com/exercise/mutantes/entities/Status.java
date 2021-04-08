package com.exercise.mutantes.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable = true)
	private Long mutantCount;

    @Column(nullable = true)
	private Long humanCount;
    
    public Status() {
    	super();
    }

	public Status(UUID id, Long mutantCount, Long humanCount) {
		super();
		this.id = id;
		this.mutantCount = mutantCount;
		this.humanCount = humanCount;
	}

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the mutantCount
	 */
	public Long getMutantCount() {
		return mutantCount;
	}

	/**
	 * @param mutantCount the mutantCount to set
	 */
	public void setMutantCount(Long mutantCount) {
		this.mutantCount = mutantCount;
	}

	/**
	 * @return the humanCount
	 */
	public Long getHumanCount() {
		return humanCount;
	}

	/**
	 * @param humanCount the humanCount to set
	 */
	public void setHumanCount(Long humanCount) {
		this.humanCount = humanCount;
	}
}
