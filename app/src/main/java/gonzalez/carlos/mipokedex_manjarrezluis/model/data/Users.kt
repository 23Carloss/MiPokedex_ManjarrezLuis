package gonzalez.carlos.mipokedex_manjarrezluis.model.data

import gonzalez.carlos.mipokedex_manjarrezluis.model.preferences.domain.User

val validUsers = listOf<User>(
    User("Carlos", "luis@gmail.com", "552834"),
    User("Pancho", "pancho@gmail.com", "234567"),
)
fun getUserByMail(mail:String): User?{
    val users = validUsers.filter {
        it.email.equals(mail, ignoreCase = true)}
    return if(users.isEmpty()) null else users.first()
}

fun login(user: String, password: String): User?{
    var user = getUserByMail(user)
    user?.let {
        if(user.password.equals(password)){
            return user
        }
    }
    return null
}