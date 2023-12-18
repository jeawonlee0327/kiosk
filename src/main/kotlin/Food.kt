package org.example

class Food (name: String, price: Int, category: String) {
     var name:String = name
     var price:Int = price
     var category:String = category


    fun displayFoods() {
        println(" $name | $price")
    }

    fun addcart() {
        println("이 메뉴를 장바구니에 추가하시겠습니까? 1. 확인 2. 취소")
        var addcart = 0

        while (true){
            try {
                addcart = readLine()!!.toInt()
                if (addcart == 1) {
                    println("${name}가 장바구니에 추가되었습니다.")
                    mycart.add(this) //선택한 메뉴 객체 생성, 리스트에 추가
                    println("---------------------------------")
                    showMenu()
                } else {
                    println("---------------------------------")
                    showMenu()
                }
            } catch (e:NumberFormatException) {
                println("숫자를 입력하시오.")
            } catch (e:KotlinNullPointerException) {
                println("숫자를 입력하시오.")
            }
        }
    }

}
