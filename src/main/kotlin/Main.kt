/**

— Измените класс Person так,
чтобы он содержал список телефонов и список почтовых адресов, связанных с человеком.

— Теперь в телефонной книге могут храниться записи о нескольких людях.
Используйте для этого наиболее подходящую структуру данных.

— Команда AddPhone теперь должна добавлять новый телефон к записи соответствующего человека.

— Команда AddEmail теперь должна добавлять новый email к записи соответствующего человека.

— Команда show должна принимать в качестве аргумента имя человека
и выводить связанные с ним телефоны и адреса электронной почты.

— Добавьте команду find,
которая принимает email или телефон и выводит список людей,
для которых записано такое значение.
 */
fun main() {
    var userInput: String = ""
    println("-- help - помощь по программе.")
    println("-- show - показывает все телефоны и email введённого userName.")
    println("-- find - показывает всех людей, у которых записан введённый телефон или email.")
    println("-- add userName phone numberPhone - добавить пользователю номер телефона.")
    println("-- add userName email emailAddress - добавить пользователю адрес электронной почты.")
    println("-- exit - выход из программы.")
    while (userInput != "exit") {
        println("Введите команду:")
        print(">>: ")

        userInput = readlnOrNull().toString();

        try {
            when (val command = readCommand(userInput)) {
                is Command.Exit -> println("Выход из программы")
                is Command.Help -> println(command.message)
                is Command.Show -> command.execute(phoneBook)
                is Command.Find -> command.execute(phoneBook)
                is Command.AddPhoneNumber -> command.execute(phoneBook)
                is Command.AddEmailAddress -> command.execute(phoneBook)
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}