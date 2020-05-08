package com.example4.serviciorest.servide

import com.example4.serviciorest.Controller.ParquearControlloer
import com.example4.serviciorest.exception.ControllerException
import com.example4.serviciorest.exception.NotFoundException
import com.example4.serviciorest.model.Parquear
import com.example4.serviciorest.model.Persona
import com.example4.serviciorest.repository.ParquearRepository
import com.example4.serviciorest.repository.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*

@Service
class ParquearService: ParquearControlloer {
    @Autowired
    val parquearRepository: ParquearRepository?=null
    @Throws(ControllerException::class)
    override fun list(): List<Parquear> {
        try {
            return parquearRepository!!.findAll()
        }catch (e: Exception){
            throw ControllerException(e.message)
        }
    }
    @Throws(ControllerException::class, NotFoundException::class)

    override fun load(idParquear: Long): Parquear {
        val op: Optional<Parquear>
        try {
            op = parquearRepository!!.findById(idParquear)
        } catch (e: Exception) {
            throw ControllerException(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("no se encontro a la persona$idParquear")
        }
        return op.get()
    }



    @Throws(ControllerException::class)
    override fun save(parquear: Parquear): Parquear {
        try {
            return parquearRepository!!.save(parquear)
        }catch (e: Exception){
            throw ControllerException(e.message)
        }
    }

    override fun delete(idParquear: Long) {
        val op: Optional<Parquear>
        try {
            op= parquearRepository!!.findById(idParquear)

        }   catch (e: Exception){
            throw ControllerException(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("no se encontro a la persona$idParquear")
        }else{
            try {
                parquearRepository!!.deleteById(idParquear)
            }catch (e: Exception){
                throw ControllerException(e.message)
            }
        }

    }
}