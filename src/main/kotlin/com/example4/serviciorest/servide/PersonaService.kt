package com.example4.serviciorest.servide

import com.example4.serviciorest.Controller.PersonController
import com.example4.serviciorest.exception.ControllerException
import com.example4.serviciorest.exception.NotFoundException
import com.example4.serviciorest.model.Persona
import com.example4.serviciorest.repository.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*

@Service
class PersonaService: PersonController {

    @Autowired
    val personaRepository: PersonaRepository?=null
    @Throws(ControllerException::class)
    override fun list(): List<Persona> {
        try {
            return personaRepository!!.findAll()
        }catch (e:Exception){
            throw ControllerException(e.message)
        }
    }
    @Throws(ControllerException::class,NotFoundException::class)

    override fun load(idPersona: Long): Persona {
        val op: Optional<Persona>
        try {
            op = personaRepository!!.findById(idPersona)
        } catch (e: Exception) {
            throw ControllerException(e.message)
        }
        if (!op.isPresent) {
                throw NotFoundException("no se encontro a la persona$idPersona")
            }
            return op.get()
        }



    @Throws(ControllerException::class)
    override fun save(persona: Persona): Persona {
        try {
return personaRepository!!.save(persona)
        }catch (e:Exception){
            throw ControllerException(e.message)
        }
         }

    override fun delete(idPersona: Long) {
        val op: Optional<Persona>
    try {
        op= personaRepository!!.findById(idPersona)

    }   catch (e:Exception){
        throw ControllerException(e.message)
    }
        if (!op.isPresent) {
            throw NotFoundException("no se encontro a la persona$idPersona")
        }else{
            try {
                personaRepository!!.deleteById(idPersona)
            }catch (e:Exception){
                throw ControllerException(e.message)
            }
        }

    }
}