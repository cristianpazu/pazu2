package com.example4.serviciorest.Controller

import com.example4.serviciorest.model.Parquear

interface ParquearControlloer {
    fun list(): List<Parquear>
    fun load(idPersona: Long): Parquear
    fun save(persona: Parquear): Parquear
    fun delete(idPersona: Long)
}