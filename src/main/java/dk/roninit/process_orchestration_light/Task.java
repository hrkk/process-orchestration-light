package dk.roninit.process_orchestration_light;
// ValidationProces



public interface Task {

    String getTaskId();

    default TaskResult execute(ProcessContext context) {
        return TaskResult.builder()
            .detail("MISSING IMPLEMENTATION")
            .taskId("MISSING IMPLEMENTATION")
            .build();
    }

}
