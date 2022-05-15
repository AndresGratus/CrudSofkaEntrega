package co.com.sofka.crud.andres.sofkacrud2.dto;

//@JsonInclude(JsonInclude.Include.NON_NULL) //cuando reotrne los valores, si hay uno null que no lo muestre

/*
responde los datos
 */

public class ResponseDto {

    private Object data;

    private String mensaje;

    public ResponseDto(Object data, String mensaje) {
        this.data = data;
        this.mensaje = mensaje;
    }

    public ResponseDto(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}