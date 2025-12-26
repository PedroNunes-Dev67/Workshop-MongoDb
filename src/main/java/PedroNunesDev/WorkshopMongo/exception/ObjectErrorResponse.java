package PedroNunesDev.WorkshopMongo.exception;

import java.io.Serializable;
import java.time.Instant;

public class ObjectErrorResponse implements Serializable {

    private Instant moment;
    private Integer status;
    private String message;
    private String path;

    public ObjectErrorResponse() {
    }

    public ObjectErrorResponse(Instant moment, Integer status, String message, String path) {
        this.moment = moment;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
