package com.exercise.mutantes.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusSummary {
	
	
	@JsonProperty("count_mutant_dna")
	private Long mutantCount;
	
	@JsonProperty("count_human_dna")
	private Long humanCount;
	
	@JsonProperty("ratio")
	private Double ratio;
	
	@JsonIgnore
	private Long total;
	
	
	public StatusSummary(Long mutantCount, Long humanCount) {
		super();
		this.mutantCount = mutantCount;
		this.humanCount = humanCount;
		this.total = mutantCount + humanCount;
		
		if (this.mutantCount != null && this.mutantCount > 0 && this.total != null && this.total > 0) {
			this.ratio = this.mutantCount.doubleValue() / this.total.doubleValue();
		} else {
			this.ratio = 0.0;
		}
			
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

	/**
	 * @return the ratio
	 */
	public Double getRatio() {
		return ratio;
	}

	/**
	 * @param ratio the ratio to set
	 */
	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	} 	
}
