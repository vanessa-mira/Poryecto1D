package mx.edu.utez.proyecto1D.exception.customException;

public class CustomBadRequestException extends RuntimeException{ //paraq ue sea una excepcion no verificada
    public CustomBadRequestException(String mensaje){
        super(mensaje); //personalizada
    }
}
