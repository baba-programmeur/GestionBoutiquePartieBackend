package sn.faty.Tech.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResponseMessage extends Exception {

    public  ResponseMessage(String erreur)
    {
        super(erreur);
    }
}
