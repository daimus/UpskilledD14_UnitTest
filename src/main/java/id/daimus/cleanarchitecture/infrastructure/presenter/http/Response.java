package id.daimus.cleanarchitecture.infrastructure.presenter.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Response {
    private Object data;
    private Object page;
    private Object errors;
    private int httpCode = 200;

    public Response(Object dataParam){
        System.out.println(dataParam);
        System.out.println(dataParam.getClass());
        this.data = dataParam;
    }

    public void setData(Object data) {
        System.out.println(data);
        System.out.println(data.getClass());
        System.out.println(data.getClass().getName());

        this.data = data;
    }

    public ResponseEntity<Object> getResponse(){
        Map<String, Object> response = new HashMap<String, Object>();
        // Data Handler
        if (this.data != null){
            response.put("data", this.data);
        } else {
            if (this.httpCode == 200 && this.errors == null){
                this.httpCode = 404;
            }
        }
        // Meta Handler
        Map<String, Object> meta = new HashMap<String, Object>();
        meta.put("code", httpCode);
        if (this.errors != null){
            meta.put("errors", this.errors);
            if (this.httpCode < 400){
                this.httpCode = 500;
            }
        }
        response.put("meta", meta);

        return new ResponseEntity<Object>(response, HttpStatusCode.valueOf(httpCode));
    }
}
