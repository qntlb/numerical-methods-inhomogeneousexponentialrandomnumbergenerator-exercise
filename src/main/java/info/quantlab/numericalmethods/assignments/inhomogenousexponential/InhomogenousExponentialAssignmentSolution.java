package info.quantlab.numericalmethods.assignments.inhomogenousexponential;

import java.util.function.DoubleSupplier;

import info.quantlab.numericalmethods.lecture.randomnumbers.RandomNumberGenerator1D;

public class InhomogenousExponentialAssignmentSolution implements InhomogenousExponentialAssignment {

	/**
	 * Create a sequence having inhomogenous exponential distribution.
	 * 
	 * @param uniformSequence Uniform input sequence.
	 * @param times The boundaries of the intervals where the intensity is piecewise constant.
	 * @param intensities	The constant intensities. The array is one element larger that the array times.
	 * 						The first entry is from to 0 to times[0].
	 * 						The i-the entry is from times[i-1] to times[i].
	 * 						The last entry n is from times[n-1] to ∞
	 */
	public DoubleSupplier createRandomNumberGeneratorInhomogenousExponential(RandomNumberGenerator1D uniformSequence, double[] times, double[] intensities) {
		/*
		 * Replace the line below this comment with a construction of your implementation
		 */
		throw new UnsupportedOperationException("Method not implemented.");
	}
}
