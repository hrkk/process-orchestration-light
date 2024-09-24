package dk.roninit.process_orchestration_light;

import lombok.Builder;
import lombok.Data;
import lombok.With;

@Builder(toBuilder = true)
@With
@Data
public class ProcessContext {
    private  String data1;
    private  String data2;
}
