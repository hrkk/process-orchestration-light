package dk.roninit.process_orchestration_light;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// The WorkflowService class is a service class that is used to orchestrate the workflow of the application.
@Service
public class WorkflowService {

    private final Processor processor;

    public WorkflowService(Collection<Task> injectedSpringBeanTasks) {

        Map<String, Task> tasks = injectedSpringBeanTasks.stream().collect(Collectors.toMap(Task::getTaskId, v -> v));
        this.processor = new Processor(tasks);
    }

    public ProcessResult processWorkflow(List<String> processInstanceTasks) {
        // Process the processInstanceTasks
        var context = ProcessContext.builder().build();
        ProcessResult processResult = processor.process(processInstanceTasks, context);

        // Print the results
        processResult.taskResults().forEach(taskResult -> {
            System.out.println("Task ID: " + taskResult.taskId());
            System.out.println("Task detail: " + taskResult.detail());
            System.out.println();
        });

        System.out.println("Context= " + context);

        return processResult;
    }
}
