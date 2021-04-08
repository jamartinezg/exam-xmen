package com.exercise.mutantes.process;

public class DetectorMutantBuilder {

	private DNAProcessContext context;

	DetectorMutantBuilder() {
		this.context = new DNAProcessContext();
	}

	public static DetectorMutantBuilder newInstance() {
		return new DetectorMutantBuilder();
	}

	public DetectorMutantBuilder withDNA(char[][] dna) {
		this.context.setDna(dna);
		return this;
	}

	public DetectorMutantBuilder withSequenceToMudant(int sequenceToMudant) {
		this.context.setSequenceToMudant(sequenceToMudant);
		return this;
	}

	public DetectorMutantBuilder withCountSequencesMatchMutant(int countSequencesMatchMutant) {
		this.context.setCountSequencesMatchMutant(countSequencesMatchMutant);
		return this;
	}

	public DNAProcessContext getContext() {
		return this.context;
	}
}
