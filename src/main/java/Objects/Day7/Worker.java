package Objects.Day7;

public class Worker {
    private Step step;

    public void log() {
        System.out.println(step != null ? step.getStepLetter() : "");
    }

    public void decrementStepTimeAndMarkComplete() {
        if (step != null) {
            int newTimeRemaining = step.getStepTimeRemaining();
            newTimeRemaining--;
            step.setStepTimeRemaining(newTimeRemaining);
            if (newTimeRemaining == 0) {
                step.setCompleted(true);
                step = null;
            }
        }
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }
}
