package PedroNunesDev.WorkshopMongo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ObjectErrorResponse> objectErrorResponseResponseEntity(ObjectNotFoundException e, HttpServletRequest request){

        Instant moment = Instant.now();
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = e.getMessage();

        return ResponseEntity.status(status).body(
                new ObjectErrorResponse(moment,status.value(),message, request.getRequestURI())
        );
    }
}
