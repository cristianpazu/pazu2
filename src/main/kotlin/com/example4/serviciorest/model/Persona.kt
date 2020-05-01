package com.example4.serviciorest.model

import org.springframework.context.annotation.Primary
import javax.persistence.*

@Entity
@Table(name ="persona")
data class Persona(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @PrimaryKeyJoinColumn val id:Long,

        @Column(name = "nombre")
        val nombre:String,
        @Column(name = "apellido")
        val apellido:String,
        @Column(name = "cedula")
        val cedula:Int,
        @Column(name = "placa")
        val placa:String

        )


{





}