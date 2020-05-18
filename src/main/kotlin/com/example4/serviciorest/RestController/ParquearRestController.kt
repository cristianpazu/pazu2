package com.example4.serviciorest.RestController

import com.example4.serviciorest.Controller.ParquearControlloer
import com.example4.serviciorest.Controller.PersonController
import com.example4.serviciorest.Utils.Constans
import com.example4.serviciorest.exception.ControllerException
import com.example4.serviciorest.exception.NotFoundException
import com.example4.serviciorest.model.Parquear
import com.example4.serviciorest.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(Constans.URL_BASE_PARQUEAR)
class ParquearRestController {

    @Autowired
    val parquearControlloer:ParquearControlloer?=null
    //val parquearControlloer: ParquearControlloer?=null

    @GetMapping("/get")
    fun  list(): ResponseEntity<List<Parquear>> {
        return try {
            ResponseEntity(parquearControlloer!!.list(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @GetMapping("/{id}")
    fun load(@PathVariable("id")idParquear: Long): ResponseEntity<Parquear> {
        return try {
            ResponseEntity(parquearControlloer!!.load(idParquear), HttpStatus.OK)
        }catch (e: ControllerException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)

        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)

        }
    }
    @PostMapping("/insert")
    fun insert(@RequestBody parquear: Parquear): ResponseEntity<Any> {
        return try{
            parquearControlloer!!.save(parquear)
            val responseHeader = HttpHeaders()
            responseHeader.set("location",Constans.URL_BASE_PERSONAS+"/"+parquear.id)
            ResponseEntity( parquearControlloer!!.save(parquear), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @PutMapping("/update")
    fun update(@RequestBody parquear: Parquear): ResponseEntity<Any> {
        return  try {
            parquearControlloer!!.save(parquear)
            ResponseEntity(HttpStatus.OK)
        }catch (e: ControllerException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id")idparquear: Long): ResponseEntity<Any> {
        return try {
            parquearControlloer!!.delete(idparquear)
            ResponseEntity(HttpStatus.OK)
        }catch (e: ControllerException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: ControllerException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }

    }

}
