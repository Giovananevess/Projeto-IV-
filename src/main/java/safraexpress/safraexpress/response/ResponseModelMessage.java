package safraexpress.safraexpress.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModelMessage extends ResposeModel {
    public ResponseModelMessage (String message) {
        this.setMessage(message);
    }

}
