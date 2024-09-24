package dk.roninit.process_orchestration_light;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

// The WorkflowService class is a service class that is used to orchestrate the workflow of the application.
@Service
public class WorkflowService {

    private final Processor processor;

    public WorkflowService() {

        // Create a map of tasks
        Map<String, Task> tasks = Map.of(
                "Task1", new Task1(),
                "Task2", new Task2()
        );
        this.processor = new Processor(tasks);
    }

    public void processWorkflow() {
        // Process the tasks
        ProcessResult processResult = processor.process();

        // Print the results
        processResult.taskResults().forEach(taskResult -> {
            System.out.println("Task ID: " + taskResult.taskId());
            System.out.println("Task detail: " + taskResult.detail());
            System.out.println();
        });
    }

    public static void main(String[] args) {
        WorkflowService workflowService = new WorkflowService();
        workflowService.processWorkflow();
    }
}
