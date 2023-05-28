package safraexpress.safraexpress.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModelObject extends ResposeModel {
    private Object object;

    public ResponseModelObject (String message, Object object) {
        this.setMessage(message);
        this.setObject(object);
    }

}
