package com.ltl;

import com.ltl.ga.FitnessFunction;
import com.ltl.ga.JeneticsCaller;

import java.util.logging.Logger;

/**
 * Simple example of genetic algorithm (GA). The displayed string is generated via GA and aims to get closer to a target
 * string (FitnessFunction._TARGET)
 */
public class Main {

    private static final Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) throws Exception {
        //change popSize and maxSize if you want to change final Levenshtein distance
        String callResult = new JeneticsCaller().popSize(50).maxSize(5000).call();
        logger.info(String.format("result '%s', Levenshtein distance : %s", callResult, FitnessFunction.getDistance(callResult)));
    }
}
