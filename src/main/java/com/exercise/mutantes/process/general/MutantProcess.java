package com.exercise.mutantes.process.general;

import com.exercise.mutantes.process.DNAProcessContext;

public abstract class MutantProcess {	
	protected final DNAProcessContext context;

	public MutantProcess(DNAProcessContext context) {
		this.context = context;
	}

	public abstract void searchMutanteSequences();

	public abstract void moveNext(Coordinate coordinate);

	public abstract boolean hasNext(Coordinate coordinate, int actualSequence);

	public boolean findMutantSequence(Coordinate coordidate) {
		char currentChar = coordidate.dna[coordidate.row][coordidate.column];
		int sequence = 1;
		while (hasNext(coordidate, sequence)) {
			moveNext(coordidate);

			if (currentChar != coordidate.curruntChar) {
				sequence = 1;
				currentChar = coordidate.curruntChar;
			} else if (++sequence >= context.getSequenceToMudant()) {
				this.newSequenceMatch();

				if (hasMatchSequencesMutant()) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}


	public void newSequenceMatch() {
		context.setMatchs(context.getMatchs() + 1);

	}

	public boolean hasMatchSequencesMutant() {
		int count = context.getCountSequencesMatchMutant();
		return context.getMatchs() >= count;
	}
}
