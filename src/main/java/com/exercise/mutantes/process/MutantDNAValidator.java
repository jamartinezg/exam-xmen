package com.exercise.mutantes.process;

import java.util.LinkedList;
import java.util.List;

import com.exercise.mutantes.process.general.MutantProcess;
import com.exercise.mutantes.process.general.ProccessVertical;
import com.exercise.mutantes.process.general.ProcessDiagonal;
import com.exercise.mutantes.process.general.ProcessDiagonalInverse;
import com.exercise.mutantes.process.general.ProcessHorizontal;

public class MutantDNAValidator {

	private DNAProcessContext context;
	
	List<MutantProcess> processors = new LinkedList<>();

	public MutantDNAValidator(char[][] dna, int countSequencesMatchMutant, int sequenceToMudant) {
		context = DetectorMutantBuilder
			.newInstance()
			.withDNA(dna)
			.withCountSequencesMatchMutant(countSequencesMatchMutant)
			.withSequenceToMudant(sequenceToMudant)
			.getContext();

		MutantProcess horizontal = new ProcessHorizontal(context);
		registerProcessor(horizontal);
		MutantProcess vertical = new ProccessVertical(context);
		registerProcessor(vertical);
		MutantProcess diagnonal = new ProcessDiagonal(context);
		registerProcessor(diagnonal);
		MutantProcess diagnonalInverse = new ProcessDiagonalInverse(context);
		registerProcessor(diagnonalInverse);
	}

	private void registerProcessor(MutantProcess processor) {
		processors.add(processor);
	}

	public boolean isMutante() {
		for (MutantProcess processor : processors) {
			processor.searchMutanteSequences();
			if (processor.hasMatchSequencesMutant()) {
				break;
			}
		}
		return context.getMatchs() >= context.getCountSequencesMatchMutant();
	}

}
