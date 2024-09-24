package dk.roninit.process_orchestration_light;

import java.util.List;

public record WorkflowRequest(List<String> tasks) {}
