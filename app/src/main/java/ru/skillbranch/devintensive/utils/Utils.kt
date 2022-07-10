package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder
object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        val parts: List<String>? = fullName?.split(" ")
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        when (firstName?.isBlank()) {
            true -> firstName = null
        }
        when (lastName?.isBlank()) {
            true -> lastName = null
        }
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val scnd = payload.indexOf(' ')+1
        val payload = payload.toLowerCase()
        var i = -1
        var answer = with(StringBuilder()) {
            for (c in payload) {
                i+=1
                when (c) {
                    'а' -> append('a')
                    'б' -> append('b')
                    'в' -> append('v')
                    'г' -> append('g')
                    'д' -> append('d')
                    'е' -> append('e')
                    'ё' -> append('e')
                    'ж' -> append("zh")
                    'з' -> append('z')
                    'и' -> append('i')
                    'й' -> append('i')
                    'к' -> append('k')
                    'л' -> append('l')
                    'м' -> append('m')
                    'н' -> append('n')
                    'о' -> append('o')
                    'п' -> append('p')
                    'р' -> append('r')
                    'с' -> append('s')
                    'т' -> append('t')
                    'у' -> append('u')
                    'ф' -> append('f')
                    'х' -> append('h')
                    'ц' -> append('c')
                    'ч' -> append("ch")
                    'ш' -> append("sh")
                    'щ' -> append("sh")
                    'ъ' -> append("")
                    'ы' -> append('i')
                    'ь' -> append("")
                    'э' -> append('e')
                    'ю' -> append("yu")
                    'я' -> append("ya")
                    else -> append(c)
                }
                if ((i == 0)||(i == scnd)) {
                }
            }
            toString().replace(" ", divider)
        }
        return answer
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var init: String? = null
        return with(StringBuilder()) {
            if((firstName!=null)&&(lastName!=null)){
                firstName?.elementAt(0).toString() + lastName?.elementAt(0).toString()}
            else if((firstName == null)&&(lastName!=null)){
                lastName.elementAt(0).toString()
            }
            else if((firstName != null)&&(lastName==null)){
                firstName.elementAt(0).toString()
            }
            else {
                null
            }
        }
    }
}