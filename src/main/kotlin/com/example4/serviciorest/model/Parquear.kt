package com.example4.serviciorest.model

import javax.persistence.*

@Entity
@Table(name="parquear")
data class Parquear(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @PrimaryKeyJoinColumn val id:Long,

        @Column(name = "estado")
        val estado:String,
        @OneToOne
        @JoinColumn(name = "persona", referencedColumnName = "id")
        val persona: Persona

)