package ru.nsu.laptev

/**
 * Класс DSL для конфигурации приложения.
 * Позволяет задавать задачи и студентов в config.groovy.
 */
class ConfigDSL {
    List<Task> tasks = []
    List<Student> students = []

    /**
     * Метод для добавления новой таски (лабораторной работы)
     * @param closure
     * @return
     */
    def task(Closure closure) {
        def task = new Task()
        closure.delegate = task //свойства и методы должны относиться к объекту task."
        closure.resolveStrategy = Closure.DELEGATE_FIRST // всегда искать свойства в Таске(в делегейте), а потом в окружайющей среде. Пока не очень понимаю что значит окр. среду
        closure() // выполняем все что нужно
        tasks << task // закидываем в список
    }

    /**
     * Метод для добавления студента.
     * @param closure замыкание, задающее свойства студента
     */
    def student(Closure closure) {
        def student = new Student()
        closure.delegate = student
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        students << student
    }
}

/**
 * Класс для представления задачи.
 */
class Task {
    String id
    String name
    String softDeadLine
    String hardDeadLine
    int maxPoints
}

/**
 * Класс для представления студента.
 */
class Student {
    String githubNick
    String fullName
    String repoUrl
}
