package com.example4.serviciorest.RestController

import com.example4.serviciorest.Controller.PersonController
import com.example4.serviciorest.Utils.Constans
import com.example4.serviciorest.exception.ControllerException
import com.example4.serviciorest.exception.NotFoundException
import com.example4.serviciorest.model.Persona
import com.example4.serviciorest.repository.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constans.URL_BASE_PERSONAS)
class PersonaRestController {

    @Autowired
    val personController: PersonController?=null

    @GetMapping("")
    fun  list():ResponseEntity<List<Persona>>{
        return try {
            ResponseEntity(personController!!.list(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @GetMapping("/{id}")
    fun load(@PathVariable("id")idPersona: Long):ResponseEntity<Persona>{
        return try {
            ResponseEntity(personController!!.load(idPersona), HttpStatus.OK)
        }catch (e:ControllerException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)

        }catch (e:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)

        }
    }
    @PostMapping("")
    fun insert(@RequestBody persona: Persona): ResponseEntity<Any>{
        return try{
            personController!!.save(persona)
            val responseHeader = HttpHeaders()
            responseHeader.set("location",Constans.URL_BASE_PERSONAS+"/"+persona.id)
            ResponseEntity(responseHeader,HttpStatus.CREATED)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @PutMapping("")
    fun update(@RequestBody persona: Persona):ResponseEntity<Any>{
        return  try {
            personController!!.save(persona)
            ResponseEntity(HttpStatus.OK)
        }catch (e:ControllerException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @DeleteMapping("{id}")
    fun delete(@PathVariable("id")idPersona: Long): ResponseEntity<Any>{
        return try {
            personController!!.delete(idPersona)
            ResponseEntity(HttpStatus.OK)
        }catch (e:ControllerException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e:ControllerException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }

    }

}