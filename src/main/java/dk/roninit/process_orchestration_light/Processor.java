package dk.roninit.process_orchestration_light;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// A generic processor class that can be used to process tasks
public class Processor {
    private final Map<String, Task> tasks;

    public Processor(Map<String, Task> tasks) {
        this.tasks = Collections.unmodifiableMap(tasks);
    }

    public ProcessResult process() {
        // Process each task
        List<TaskResult> taskResults = new ArrayList<>();
        tasks.values().forEach(task -> {
            TaskResult result = task.execute();
            taskResults.add(result);
        });
        return new ProcessResult(taskResults);
    }
}
