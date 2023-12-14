package kioskLv4

class DessertItem():MenuItem(){
    override fun displayInfo(){
        println("${name} 입니다. 가격은 ${price} 입니다.")
    }
    constructor(name : String, price : Int) : this(){
        super.name = name
        super.price = price
    }
}