package dk.roninit.process_orchestration_light;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record ProcessResult(List<TaskResult> taskResults) {
}
