package dk.roninit.process_orchestration_light;

import org.springframework.stereotype.Component;

@Component
public class Task2 implements Task {
    @Override
    public String getTaskId() {
        return "Task2";
    }


    @Override
    public TaskResult execute() {
        return TaskResult.builder()
            .detail(getTaskId()+" executed")
            .taskId(getTaskId())
            .build();
    }
}
