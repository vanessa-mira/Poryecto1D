package mx.edu.utez.proyecto1D.service;

import mx.edu.utez.proyecto1D.controller.dto.RequestCalculadoraDTO;
import mx.edu.utez.proyecto1D.controller.dto.ResponseCalculadoraDTO;
import mx.edu.utez.proyecto1D.exception.customException.CustomBadRequestException;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    //para mandar a traer los datos que queremos utilizar en este caso en Request
    public ResponseCalculadoraDTO calculadora (RequestCalculadoraDTO data){
        //Para la respuesta de las operaciones
        ResponseCalculadoraDTO respuesta = new ResponseCalculadoraDTO();
        if(
                !data.getOperacion().equals("SUMA")
                && !data.getOperacion().equals("RESTA")
                && !data.getOperacion().equals("MULTIPLICACION")

        ){
            throw new CustomBadRequestException("La operacion solicitada no es valida");
        }
        switch (data.getOperacion()){
            case "SUMA":
                respuesta.setResultado(
                        data.getNum1() + data.getNum2()
                );
                break;

            case "RESTA":
                respuesta.setResultado(
                        data.getNum1() - data.getNum2()
                );
                break;

            case "MULTIPLICACION":
                respuesta.setResultado(
                        data.getNum1() * data.getNum2()
                );
                break;
        }
        respuesta.setOperacionRealizada(data.getOperacion());

        return respuesta;

    }
}
