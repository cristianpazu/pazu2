package com.example4.serviciorest.repository

import com.example4.serviciorest.model.Parquear
import com.example4.serviciorest.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParquearRepository : JpaRepository<Parquear, Long> {
}