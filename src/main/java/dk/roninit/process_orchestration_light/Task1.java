package dk.roninit.process_orchestration_light;

public class Task1 implements Task {
    @Override
    public String getTaskId() {
        return "Task1";
    }

    @Override
    public TaskResult execute() {
        return TaskResult.builder()
            .detail(getTaskId()+" executed")
            .taskId(getTaskId())
            .build();
    }
}
