package com.exercise.mutantes.process.general;

import com.exercise.mutantes.process.DNAProcessContext;

public class ProcessDiagonal extends MutantProcess {

	public ProcessDiagonal(DNAProcessContext context) {
		super(context);
	}

	@Override
	public void searchMutanteSequences() {
		char[][] dna = context.getDna();

		boolean match = findMutantSequence(Coordinate.at(dna, 0, 0));
		if (match) {
			return;
		}
		for (int row = 1; row <= dna.length - context.getSequenceToMudant(); row++) {
			match = findMutantSequence(Coordinate.at(dna, row, 0, row))
					|| findMutantSequence(Coordinate.at(dna, 0, row, row));
			if (match) {
				break;
			}
		}

	}

	@Override
	public void moveNext(Coordinate coordinate) {
		coordinate.row++;
		coordinate.column++;
		coordinate.subIndex++;
		coordinate.lastChar = coordinate.curruntChar;
		coordinate.curruntChar = coordinate.dna[coordinate.row][coordinate.column];
	}

	@Override
	public boolean hasNext(Coordinate coordinate, int actualSequence) {
		int subIndex = coordinate.subIndex;
		int available = coordinate.size - subIndex;
		return available + actualSequence >= context.getSequenceToMudant()
				&& Math.max(coordinate.column, coordinate.row) + 1 < coordinate.size;
	}

}
