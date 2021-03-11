package com.example.androiddesignpatterns

/**
 * 数据类Modal
 */
data class Student(private var name: String, private var age: Int) {

    fun getName(): String = this.name
    fun setName(newName: String) = { name = newName }()
    fun getAge(): Int = this.age
    fun setAge(newAge: Int) = { age = newAge }()
}

/**
 * 视图层 View
 */
class View {

    fun showView(name: String, age: Int) = println("name:$name,age:$age")
}

/**
 * 控制器 Controller
 */
class Controller(private var view: View, private var modal: Student) {

    fun setName(newName: String) = modal.setName(newName)
    fun setAge(newAge: Int) = modal.setAge(newAge)
    fun getName(): String = modal.getName()
    fun getAge(): Int = modal.getAge()
    fun updateView() {
        println("更新视图:------------")
        view.showView(modal.getName(), modal.getAge())
    }

}

/**
 * kotlin MVC模式
 * @author IWH
 * android默认的开发模式就是MVC，activity属于控制器负责XML与Modal的处理
 */
fun main() {
    val view = View()
    val modal = Student("iwh", 20)
    val controller = Controller(view, modal)
    view.showView(controller.getName(), controller.getAge())
    controller.setAge(21)
    controller.setName("jack")
    controller.updateView()
    main2()


}

/**
 * 使用kotlin特性
 */
fun main2() {
    View().apply outer@{
        Student("iwh", 20).apply inner@{
            with(Controller(this@outer, this@inner)) last@{
                this@outer.showView(this.getName(), this.getAge())
                setName("jack")
                setAge(21)
                updateView()
            }
        }
    }
}