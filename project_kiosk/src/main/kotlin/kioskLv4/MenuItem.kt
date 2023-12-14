package kioskLv4

// CoffeeItem, DrinkItem, DessertItem을 상속시키기 위해 추상클래스 MenuItem을 만들었다 (Lv3미션)
abstract class MenuItem(){
    var name = ""
    var price = 0
    abstract fun displayInfo()
}