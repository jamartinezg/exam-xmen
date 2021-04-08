package com.exercise.mutantes.process.general;

import com.exercise.mutantes.process.DNAProcessContext;

public class ProcessHorizontal extends MutantProcess {
	public ProcessHorizontal(DNAProcessContext context) {
		super(context);
	}

	@Override
	public void searchMutanteSequences() {
		char[][] dna = context.getDna();
		for (int row = 0; row < dna.length; row++) {
			boolean match = findMutantSequence(Coordinate.at(dna, row, 0));
			if (match) {
				break;
			}
		}
	}

	@Override
	public void moveNext(Coordinate coordinate) {
		coordinate.column++;
		coordinate.subIndex++;
		coordinate.lastChar = coordinate.curruntChar;
		coordinate.curruntChar = coordinate.dna[coordinate.row][coordinate.column];
	}

	@Override
	public boolean hasNext(Coordinate coordinate, int actualSequence) {
		return coordinate.column + 1 <= coordinate.safeIndex;
	}

}
