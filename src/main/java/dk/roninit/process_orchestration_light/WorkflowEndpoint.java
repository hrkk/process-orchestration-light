package dk.roninit.process_orchestration_light;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WorkflowEndpoint {

    private final WorkflowService workflowService;

    @PostMapping("/workflow/process")
    public ResponseEntity<ProcessResult> process(@RequestBody WorkflowRequest workflowRequest) {
        List<String> tasks = workflowRequest.tasks();
        ProcessResult processResult = workflowService.processWorkflow(tasks);
        return ResponseEntity.ok(processResult);
    }

}
