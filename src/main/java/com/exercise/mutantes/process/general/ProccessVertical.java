package com.exercise.mutantes.process.general;

import com.exercise.mutantes.process.DNAProcessContext;

public class ProccessVertical extends MutantProcess {

	public ProccessVertical(DNAProcessContext context) {
		super(context);
	}

	@Override
	public void searchMutanteSequences() {
		char[][] dna = context.getDna();
		for (int column = 0; column < dna.length; column++) {
			boolean match = findMutantSequence(Coordinate.at(dna, 0, column));
			if (match) {
				break;
			}
		}
	}

	@Override
	public void moveNext(Coordinate coordinate) {
		coordinate.row++;
		coordinate.subIndex++;
		coordinate.lastChar = coordinate.curruntChar;
		coordinate.curruntChar = coordinate.dna[coordinate.row][coordinate.column];
	}

	@Override
	public boolean hasNext(Coordinate coordinate, int actualSequence) {
		return coordinate.row + 1 <= coordinate.safeIndex;
	}

}
