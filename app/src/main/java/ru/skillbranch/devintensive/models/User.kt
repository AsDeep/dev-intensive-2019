package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

class User(
    val id : String,
    var firstName : String?,
    var avatar : String?,
    var lastName : String?,
    var rating : Int = 0,
    var respect : Int = 0,
    var lastVisit : Date? = Date(),
    var isOnline : Boolean = false)
{
    constructor(id: String, firstName: String?, lastName: String?): this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )
    constructor(id:String): this(id,"John","Doe" )
    init {

        println("It's Alive!!! \n ${if (lastName==="Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName !!!!" }\n ")
    }
    fun printMe(): Unit {
        println("""
            
            id: $id
            firstName: $firstName
            avatar: $avatar
            lastName: $lastName
            rating: $rating
            respect: $respect
            lastVisit: $lastVisit
            isOnline: $isOnline
        """.trimIndent())
    }
    companion object Factory{
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User{
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            val initials = Utils.toInitials(firstName,lastName)
            println("Initials: $initials")
            return User("$lastId", firstName, lastName )
        }
    }

}