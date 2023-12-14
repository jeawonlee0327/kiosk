package kioskLv5

class DrinkItem(name: String, price: Int, info: String) : MenuItem(name, price, info) {
    override fun displayInfo() {
        println("$name 입니다. 가격은 $price 원입니다.")
    }
}