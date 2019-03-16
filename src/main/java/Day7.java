import Objects.Day7.Step;
import Objects.Day7.Worker;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Day7 {

//    private static List<String> input = Arrays.asList("Step C must be finished before step A can begin.",
//            "Step C must be finished before step F can begin.",
//            "Step A must be finished before step B can begin.",
//            "Step A must be finished before step D can begin.",
//            "Step B must be finished before step E can begin.",
//            "Step D must be finished before step E can begin.",
//            "Step F must be finished before step E can begin.");

    private static List<String> input = Arrays.asList("Step P must be finished before step R can begin.",
            "Step V must be finished before step J can begin.",
            "Step O must be finished before step K can begin.",
            "Step S must be finished before step W can begin.",
            "Step H must be finished before step E can begin.",
            "Step K must be finished before step Y can begin.",
            "Step B must be finished before step Z can begin.",
            "Step N must be finished before step G can begin.",
            "Step W must be finished before step I can begin.",
            "Step L must be finished before step Y can begin.",
            "Step U must be finished before step Q can begin.",
            "Step R must be finished before step Z can begin.",
            "Step Z must be finished before step E can begin.",
            "Step C must be finished before step I can begin.",
            "Step I must be finished before step Q can begin.",
            "Step D must be finished before step E can begin.",
            "Step A must be finished before step J can begin.",
            "Step G must be finished before step Y can begin.",
            "Step M must be finished before step T can begin.",
            "Step E must be finished before step X can begin.",
            "Step F must be finished before step T can begin.",
            "Step X must be finished before step J can begin.",
            "Step Y must be finished before step J can begin.",
            "Step T must be finished before step Q can begin.",
            "Step J must be finished before step Q can begin.",
            "Step E must be finished before step Y can begin.",
            "Step A must be finished before step T can begin.",
            "Step P must be finished before step H can begin.",
            "Step W must be finished before step R can begin.",
            "Step Y must be finished before step Q can begin.",
            "Step W must be finished before step M can begin.",
            "Step O must be finished before step M can begin.",
            "Step H must be finished before step R can begin.",
            "Step N must be finished before step L can begin.",
            "Step V must be finished before step W can begin.",
            "Step S must be finished before step Q can begin.",
            "Step D must be finished before step J can begin.",
            "Step W must be finished before step E can begin.",
            "Step V must be finished before step Y can begin.",
            "Step O must be finished before step C can begin.",
            "Step B must be finished before step T can begin.",
            "Step W must be finished before step T can begin.",
            "Step G must be finished before step T can begin.",
            "Step D must be finished before step T can begin.",
            "Step P must be finished before step E can begin.",
            "Step P must be finished before step J can begin.",
            "Step G must be finished before step E can begin.",
            "Step Z must be finished before step M can begin.",
            "Step K must be finished before step T can begin.",
            "Step H must be finished before step U can begin.",
            "Step P must be finished before step T can begin.",
            "Step W must be finished before step A can begin.",
            "Step A must be finished before step F can begin.",
            "Step F must be finished before step Y can begin.",
            "Step H must be finished before step M can begin.",
            "Step T must be finished before step J can begin.",
            "Step O must be finished before step S can begin.",
            "Step P must be finished before step M can begin.",
            "Step X must be finished before step T can begin.",
            "Step S must be finished before step J can begin.",
            "Step H must be finished before step C can begin.",
            "Step B must be finished before step W can begin.",
            "Step K must be finished before step N can begin.",
            "Step E must be finished before step T can begin.",
            "Step S must be finished before step Y can begin.",
            "Step C must be finished before step G can begin.",
            "Step R must be finished before step D can begin.",
            "Step N must be finished before step U can begin.",
            "Step O must be finished before step L can begin.",
            "Step B must be finished before step F can begin.",
            "Step S must be finished before step F can begin.",
            "Step X must be finished before step Y can begin.",
            "Step S must be finished before step D can begin.",
            "Step R must be finished before step E can begin.",
            "Step S must be finished before step A can begin.",
            "Step S must be finished before step X can begin.",
            "Step A must be finished before step G can begin.",
            "Step E must be finished before step F can begin.",
            "Step P must be finished before step A can begin.",
            "Step A must be finished before step M can begin.",
            "Step E must be finished before step Q can begin.",
            "Step H must be finished before step W can begin.",
            "Step W must be finished before step U can begin.",
            "Step F must be finished before step Q can begin.",
            "Step I must be finished before step J can begin.",
            "Step H must be finished before step G can begin.",
            "Step I must be finished before step G can begin.",
            "Step P must be finished before step X can begin.",
            "Step I must be finished before step D can begin.",
            "Step R must be finished before step X can begin.",
            "Step S must be finished before step I can begin.",
            "Step Y must be finished before step T can begin.",
            "Step R must be finished before step G can begin.",
            "Step I must be finished before step X can begin.",
            "Step B must be finished before step D can begin.",
            "Step X must be finished before step Q can begin.",
            "Step F must be finished before step X can begin.",
            "Step V must be finished before step R can begin.",
            "Step C must be finished before step J can begin.",
            "Step L must be finished before step Q can begin.",
            "Step K must be finished before step B can begin.");

    public static void partOne() {
        System.out.println("Day Seven, Part One:");

        HashMap<String, Step> stepLetterToSteps = generateSteps();

        printPartOneOutput(stepLetterToSteps.values());
    }

    private static void printPartOneOutput(Collection<Step> steps) {
        StringBuilder output = new StringBuilder();

        Step nextStep = getNextStep(steps);
        while (nextStep != null) {
            nextStep.setCompleted(true);
            output.append(nextStep.getStepLetter());
            nextStep = getNextStep(steps);
        }

        System.out.println(output);
    }

    public static void partTwo() {
        System.out.println("Day Seven, Part Two:");

        List<Worker> workers = Arrays.asList(new Worker(),
                new Worker(),
                new Worker(),
                new Worker(),
                new Worker());

        Collection<Step> steps = generateSteps().values();

        assignStepsToWorkers(workers, steps);

        int totalTime = 0;

        while (workersBusy(workers)) {
            //System.out.println(totalTime);
            //logWorkers(workers);
            decrementRemainingTime(workers);
            totalTime++;
            assignStepsToWorkers(workers, steps);
        }

        System.out.println(totalTime);
    }

    private static void assignStepsToWorkers(List<Worker> workers, Collection<Step> steps) {
        for (Worker worker : workers) {
            if (worker.getStep() == null) {
                Step step = getNextStep(steps);
                worker.setStep(step);
                if (step != null) {
                    step.setInProgress(true);
                }
            }
        }
    }

    private static boolean workersBusy(List<Worker> workers) {
        boolean workersBusy = false;

        for (Worker worker : workers) {
            if (worker.getStep() != null) {
                workersBusy = true;
                break;
            }
        }

        return workersBusy;
    }

    private static void decrementRemainingTime(List<Worker> workers) {
        workers.forEach(Worker::decrementStepTimeAndMarkComplete);
    }

    private static void logWorkers(List<Worker> workers) {
        workers.forEach(Worker::log);
    }

    private static Step getNextStep(Collection<Step> steps) {
        Step nextStep = null;

        for (Step step : steps) {
            if (!step.isCompleted()
                    && !step.isInProgress()
                    && step.allPreviousStepsCompleted()) {
                if (nextStep == null
                        || step.getStepLetter().compareTo(nextStep.getStepLetter()) < 0) {
                    nextStep = step;
                }
            }
        }

        return nextStep;
    }

    private static HashMap<String, Step> generateSteps() {
        HashMap<String, Step> stepLetterToSteps = new HashMap<>();

        for (String str : input) {
            createAndAddOrUpdateStepAndRequiredStep(str, stepLetterToSteps);
        }

        return stepLetterToSteps;
    }

    private static void createAndAddOrUpdateStepAndRequiredStep(String str, HashMap<String, Step> stepLetterToSteps) {
        String requiredStepLetter = str.substring(str.indexOf("Step ") + "Step ".length(), str.indexOf(" must"));
        String stepLetter = str.substring(str.indexOf("before step ") + "before step ".length(), str.indexOf(" can"));

        Step requiredStep = stepLetterToSteps.get(requiredStepLetter);
        if (requiredStep == null) {
            requiredStep = new Step(requiredStepLetter);
            stepLetterToSteps.put(requiredStepLetter, requiredStep);
        }

        Step step = stepLetterToSteps.get(stepLetter);
        if (step == null) {
            step = new Step(stepLetter);
            stepLetterToSteps.put(stepLetter, step);
        }
        step.getPreviousSteps().add(requiredStep);
    }
}
