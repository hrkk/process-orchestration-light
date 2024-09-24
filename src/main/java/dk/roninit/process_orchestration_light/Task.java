package dk.roninit.process_orchestration_light;

public interface Task {

    String getTaskId();

    default TaskResult execute() {
        return TaskResult.builder()
            .detail("MISSING IMPLEMENTATION")
            .taskId("MISSING IMPLEMENTATION")
            .build();
    }

}
