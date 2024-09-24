package dk.roninit.process_orchestration_light;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// A generic processor class that can be used to process tasks
@Log4j2
public class Processor {
    private final Map<String, Task> tasks;

    public Processor(Map<String, Task> tasks) {
        this.tasks = Collections.unmodifiableMap(tasks);
    }

    public ProcessResult process(List<String> processInstanceTasks, ProcessContext context) {
        // Process each task
        List<TaskResult> taskResults = new ArrayList<>();

        // processInstanceTasks is a list of task IDs that need to be processed in that order
        processInstanceTasks.forEach(taskId -> {
            Task task = tasks.get(taskId);
            if (task == null) {
                log.debug("Task with ID {} not found", taskId);
            } else {
                TaskResult result = task.execute(context);
                taskResults.add(result);
            }
        });

        return new ProcessResult(taskResults, context);
    }
}
