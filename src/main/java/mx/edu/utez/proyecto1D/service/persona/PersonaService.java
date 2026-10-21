package mx.edu.utez.proyecto1D.service.persona;

import mx.edu.utez.proyecto1D.exception.customException.CustomNotFoundException;
import mx.edu.utez.proyecto1D.model.persona.Persona;
import mx.edu.utez.proyecto1D.model.persona.dto.RequestUpdatePersonaDTO;
import mx.edu.utez.proyecto1D.repository.persona.PersonaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;
     public PersonaService(PersonaRepository personaRepository){
         this.personaRepository = personaRepository;
     }
    @Transactional
     public Persona updatePersona(Long id, RequestUpdatePersonaDTO payload){
         Persona persona = personaRepository.findById(id).orElseThrow(() -> new CustomNotFoundException("La persona con id" + id + " no existe"));
         persona.setNombre(payload.getNombres());
         persona.setPrimerApellido(payload.getPrimerApellido());
         persona.setSegundoApellido(payload.getSegundoApellido());
         persona.setCorreo(payload.getCorreo());
         persona.setCurp(payload.getCurp());
         persona.setFechaNacimiento(payload.getFechaNacimiento());

        return personaRepository.save(persona);
    }
}
