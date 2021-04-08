package com.exercise.mutantes.process.general;

import com.exercise.mutantes.process.DNAProcessContext;

public class ProcessDiagonalInverse extends ProcessDiagonal {

	public ProcessDiagonalInverse(DNAProcessContext context) {
		super(context);
	}

	@Override
	public void searchMutanteSequences() {
		char[][] dna = context.getDna();

		int fistIndexRow = dna.length - 1;
		int fistIndexColumn = 0;
		boolean match = findMutantSequence(Coordinate.at(dna, fistIndexRow, fistIndexColumn));
		if (match) {
			return;
		}
		for (int row = 1; row <= dna.length - context.getSequenceToMudant(); row++) {
			match = findMutantSequence(Coordinate.at(dna, fistIndexRow - row, 0, row))
					|| findMutantSequence(Coordinate.at(dna, fistIndexRow, row, row));
			if (match) {
				break;
			}
		}

	}

	@Override
	public void moveNext(Coordinate coordinate) {
		coordinate.row--;
		coordinate.column++;
		coordinate.subIndex++;
		coordinate.lastChar = coordinate.curruntChar;
		coordinate.curruntChar = coordinate.dna[coordinate.row][coordinate.column];
	}

	@Override
	public boolean hasNext(Coordinate coordinate, int actualSequence) {
		int index = coordinate.subIndex;
		int available = coordinate.size - index;
		return available + actualSequence >= context.getSequenceToMudant() && coordinate.row - 1 >= 0;
	}

}
