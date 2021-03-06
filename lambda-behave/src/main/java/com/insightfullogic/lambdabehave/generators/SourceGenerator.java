package com.insightfullogic.lambdabehave.generators;

import com.insightfullogic.lambdabehave.impl.generators.RandomNumberGenerator;

/**
 * A source of information which generators use. Generators should
 * deterministically generate test cases based upon the source
 * generator.
 *
 * @see com.insightfullogic.lambdabehave.generators.Generator
 */
public interface SourceGenerator {

    /**
     * creates a source generator that returns random numbers.
     *
     * @return the source generator
     */
    public static SourceGenerator randomNumbers() {
        return new RandomNumberGenerator();
    }

    /**
     * Generate an int which is &lt;= maxValue.
     *
     * @param maxValue the maximum value of the int
     * @return the generated int
     */
    int generateInt(int maxValue);

    /**
     * Gets the seed state required to generate the sequence of numbers.
     *
     * @return the seed required to generate the sequence of numbers
     */
    long getSeed();

    /**
     * Generate a boolean value, based upon the current source
     * of information.
     *
     * @return either true or false
     */
    default boolean generateBoolean() {
        return generateInt(2) == 0;
    }

}
