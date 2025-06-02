# numerical-methods-inhomogeneousexponentialrandomnumbergenerator-exercise

This exercise is related to random number generation:

## Random Number Generation: ICDF Method for Inhomogeneous Exponential Distribution

1) Implement a class that implements the interface `DoubleSupplier` of the package `java.util.function.DoubleSupplier` that generates a sequence of random drawings of
an **inhomogeneous exponential distribution** with piece-wise constant intensities (see below how we provide the
piece-wise constant intensities).

```
@FunctionalInterface
public interface DoubleSupplier {

    /**
     * Gets a result.
     *
     * @return a result
     */
    double getAsDouble();
}
```


2) When done with 1) implement the method `createRandomNumberGeneratorInhomogenousExponential` of the class `InhomogenousExponentialAssignmentSolution`,
such that it allows to create an object of the class you have implemented in 1).

```
public DoubleSupplier createRandomNumberGeneratorInhomogenousExponential(RandomNumberGenerator1D uniformSequence, double[] times, double[] intensities)
```

**Note**: The arguments `times` and `intensities` that are provided to you have the following interpretation:

- The length of the array `intensities` is `times.length + 1`.
- `intensities[0]` is the intensity for the time period from `0` to `times[0]`.
- `intensities[i]` is the intensity for the time period from `times[i-1]` to `times[i]`.
- `intensities[n]` is the intensity for the time period from `times[n-1]` to `Double.INFINITY`.

where `n = intensities.length-1`, i.e., `n = times.length`.


A class like `InhomogenousExponentialAssignmentSolution` is called a *Factory*, because it allows to create objects. It allows us to create an object of *your* class, without knowing the name of your class. We will use this method to test your implementation.

*Hint*: This is a trivial task. If your class in 1) is named `RandomNumberGeneratorInhomogenousExponential` and if
it has a constructor `RandomNumberGeneratorInhomogenousExponential(RandomNumberGenerator1D uniformSequence, double[] times, double[] intensities)`, then the body of the implementation of the factory class
is just

```
public DoubleSupplier createRandomNumberGeneratorInhomogenousExponential(RandomNumberGenerator1D uniformSequence, double[] times, double[] intensities) 	{
	return new RandomNumberGeneratorInhomogenousExponential(uniformSequence, times, intensities);
}
```

You can test your implementation by running the unit test in `src/test/java`.

## Main Task

The main task of this exercise is to provide the inversion of the distribution function
of an inhomogeneous exponential distribution with a piece-wise constant intensity.

The most involved step is the inversion of the function t &mapsto; &Lambda;(t), where

- &Lambda;(t) = &lambda;<sub>0</sub> &middot; t for t < t<sub>0</sub>
- &Lambda;(t<sub>i</sub>) = &lambda;<sub>0</sub> &middot; (t<sub>0</sub>-0) + &lambda;<sub>1</sub> &middot; (t<sub>1</sub>-t<sub>0</sub>) + ... + &lambda;<sub>i</sub> &middot; (t<sub>i</sub>-t<sub>i-1</sub>)
- &Lambda;(t) = &Lambda;(t<sub>i-1</sub>) + &lambda;<sub>i</sub> &middot; (t-t<sub>i-1</sub>) &emsp; for t<sub>i-1</sub> < t < t<sub>i</sub> &emsp; (in between to times)
- &Lambda;(t) = &Lambda;(t<sub>n-1</sub>) + &lambda;<sub>n</sub> &middot; (t-t<sub>n-1</sub>) &emsp; for t<sub>n-1</sub> < t &emsp; (after the last time)

using the times t<sub>0</sub>, t<sub>1</sub>, ..., t<sub>n-1</sub> and the intensities &lambda;<sub>0</sub>, &lambda;<sub>1</sub>, ..., &lambda;<sub>n-1</sub>, &lambda;<sub>n</sub>.
