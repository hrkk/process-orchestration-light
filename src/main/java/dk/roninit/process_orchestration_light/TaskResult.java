package dk.roninit.process_orchestration_light;

import lombok.Builder;
import lombok.With;

@Builder(toBuilder = true)
@With
public record TaskResult(String taskId, String detail) {

}
