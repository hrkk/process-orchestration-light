package dk.roninit.process_orchestration_light;

import org.springframework.stereotype.Component;

@Component
public class Task1 implements Task {
    @Override
    public String getTaskId() {
        return "Task1";
    }

    @Override
    public TaskResult execute(ProcessContext context) {
        context.setData1(getTaskId()+ " data1");
        return TaskResult.builder()
            .detail(getTaskId()+" executed")
            .taskId(getTaskId())
            .build();
    }
}
