package dk.roninit.process_orchestration_light;

import org.springframework.stereotype.Component;

@Component
public class Task2 implements Task {
    @Override
    public String getTaskId() {
        return "Task2";
    }


    @Override
    public TaskResult execute(ProcessContext context) {
        context.setData2(getTaskId()+ " data2");
        return TaskResult.builder()
            .detail(getTaskId()+" executed")
            .taskId(getTaskId())
            .build();
    }
}
