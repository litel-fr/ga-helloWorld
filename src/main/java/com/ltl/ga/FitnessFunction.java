package com.ltl.ga;

import org.apache.commons.text.similarity.LevenshteinDistance;
import org.jenetics.*;

import java.util.function.Function;


public class FitnessFunction implements Function<Genotype<CharacterGene>, Integer> {

    public static final String _TARGET = "hello world";

    /**
     * Fitness function based on Levenshtein distance between the Chromosome and an arbitrary string
     *
     * @param chromosomes
     * @return score from Integer.MIN_VALUE to 0, the closest to zero the better
     */
    @Override
    public Integer apply(final Genotype<CharacterGene> chromosomes) {
        String characterChromosomeString = chromosomes.getChromosome().as(CharacterChromosome.class).toString();
        Integer result = getDistance(characterChromosomeString);
        return -result;
    }

    /**
     * Get Levenshtein distance between _TARGET and an arbitrary string
     * @param str the arbitrary string
     * @return
     */
    public static Integer getDistance(final String str) {
        LevenshteinDistance distance = new LevenshteinDistance();
        return distance.apply(str, _TARGET);
    }

}
