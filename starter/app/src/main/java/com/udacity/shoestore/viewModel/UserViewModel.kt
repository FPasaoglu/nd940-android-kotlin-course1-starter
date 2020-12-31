package com.udacity.shoestore.viewModel

import androidx.lifecycle.ViewModel
import com.udacity.shoestore.model.User

class UserViewModel : ViewModel() {

    private val userList: MutableList<User> = mutableListOf(
        User("google", "google@google.com", "+012345", "1234"),
        User("Furkan", "furkan@gmail.com", "+90533321013", "1234"),
        User("Hande", "hande@outlook.com", "+7632199875", "1234"),
        User("GG", "ggle@google.com", "+517654392", "1234"),
        User("h", "h", "+00998877", "1234")
    )


    var userName = String()
    var email = String()
    var password = String()
    var phone = String()


    fun isLoginSuccess(): Boolean {
        userList.forEach {
            if (it.email.equals(email) && it.password.equals(password)) {
                setUser(it)
                return true
            }
        }
        return false
    }

    fun isSignUpSuccess(): Boolean {
        if (email.isNotBlank() && password.isNotBlank() && phone.isNotBlank() && userName.isNotBlank()) {
            userList.add(getUser())
            return true
        } else {
            return false
        }

    }

    fun getUser(): User {
        return User(userName, email, phone, password)
    }

    fun setUser(user: User) {
        userName = user.username
        email = user.email
        phone = user.phone
        password = user.password

    }

    fun clearUser() {
        setUser(User("","","",""))
    }
}