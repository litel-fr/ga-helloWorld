package com.ltl.ga;

import org.jenetics.*;
import org.jenetics.engine.Engine;
import org.jenetics.engine.EvolutionResult;
import org.jenetics.util.CharSeq;
import org.jenetics.util.Factory;

import java.util.concurrent.Callable;

/**
 * Handle interactions with the Jenetics lib.
 */
public class JeneticsCaller implements Callable<String> {

    private static final CharSeq ALLOWED_CHARS = new CharSeq("abcdefghijklmnopqrstuvwxyz ".toCharArray());
    private int popSize = 50; //initial population size
    private int maxSize = 1000; //engine stream size

    @Override
    public String call() throws Exception {
        //create genetic algorithm engine
        Engine<CharacterGene, Integer> engine = getEngine();
        //run engine and collect result
        Genotype<CharacterGene> fittestGenotype = engine.stream()
                .limit(maxSize)
                .collect(EvolutionResult.toBestGenotype());
        //stringify result
        String result = fittestGenotype.getChromosome().as(CharacterChromosome.class).toString();
        return result;
    }

    /**
     * Fluent setter
     * @param popSize
     * @return
     */
    public JeneticsCaller popSize(int popSize) {
        this.popSize = popSize;
        return this;
    }

    /**
     * Fluent setter
     * @param maxSize
     * @return
     */
    public JeneticsCaller maxSize(int maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    private Engine<CharacterGene, Integer> getEngine() {
        Factory<Genotype<CharacterGene>> genotypeFactory = getGenotypeFactory();
        return Engine
                    .builder(new FitnessFunction(), genotypeFactory)
                    .populationSize(popSize)
                    .build();
    }

    private Factory<Genotype<CharacterGene>> getGenotypeFactory() {
        CharacterChromosome chromosome = CharacterChromosome.of(getCorrectSizeEmptyString(), ALLOWED_CHARS);
        return Genotype.of(chromosome);
    }

    private String getCorrectSizeEmptyString() {
        return FitnessFunction._TARGET.replaceAll(".", " ");
    }


}
