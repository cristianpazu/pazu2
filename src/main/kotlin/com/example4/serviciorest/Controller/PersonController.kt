package com.example4.serviciorest.Controller

import com.example4.serviciorest.model.Persona

interface PersonController {
    fun list(): List<Persona>
    fun load(idPersona: Long):Persona
    fun save(persona: Persona):Persona
    fun delete(idPersona: Long)

}