package Objects;

import java.util.ArrayList;
import java.util.List;

public class Step {
    private String stepLetter;
    private List<Step> previousSteps = new ArrayList<>();
    private boolean completed = false;
    private int stepTimeRemaining;

    private boolean inProgress = false;

    public Step(String stepLetter) {
        this.stepLetter = stepLetter;
        this.stepTimeRemaining = (int)stepLetter.charAt(0) - 4;
    }

    public boolean allPreviousStepsCompleted() {
        boolean allComplete = true;
        for (Step step : previousSteps) {
            if (!step.isCompleted()) {
                allComplete = false;
                break;
            }
        }

        return allComplete;
    }

    public String getStepLetter() {
        return stepLetter;
    }

    public void setStepLetter(String stepLetter) {
        this.stepLetter = stepLetter;
    }

    public List<Step> getPreviousSteps() {
        return previousSteps;
    }

    public void setPreviousSteps(List<Step> previousSteps) {
        this.previousSteps = previousSteps;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getStepTimeRemaining() {
        return stepTimeRemaining;
    }

    public void setStepTimeRemaining(int stepTimeRemaining) {
        this.stepTimeRemaining = stepTimeRemaining;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }
}
