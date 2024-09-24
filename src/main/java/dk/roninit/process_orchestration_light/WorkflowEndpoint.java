package dk.roninit.process_orchestration_light;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class WorkflowEndpoint {

    private final WorkflowService workflowService;

    @GetMapping("/workflow/process")
    public ResponseEntity<ProcessResult> process() {
        ProcessResult processResult = workflowService.processWorkflow();
        return ResponseEntity.ok(processResult);
    }

}
