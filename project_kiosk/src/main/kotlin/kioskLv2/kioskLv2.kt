fun main() {
    println("00카페에 오신것을 환영합니다.")
    println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
    println("1.커피 2.음료 3.디저트 0.종료")

    when (readLine()!!.toInt()) {
        1 -> {
            println("1.아메리카노 2.카페모카 3.카페라떼 4.에스프레소 0.뒤로가기")
            coffeMenu(readLine()!!.toInt())
        }// 1번을 선택했을때 커피 메뉴를 보여주는 메소드 실행

        2 -> {
            println("1.오렌지주스 2.애플주스 3.아이스티 4.청포도에이드 0.뒤로가기")
            drinkMenu(readLine()!!.toInt())
        }

        3 -> {
            println("1.치즈케이크 2.망고빙수 3.애플파이 4.소금빵 0.뒤로가기")
            dessertMenu(readLine()!!.toInt())
        }

        0 -> println("종료합니다.")
    }
}

fun coffeMenu(x: Int) {
    when (x) {
        1 -> println("아메리카노를 선택하셨습니다.")
        2 -> println("카페모카를 선택하셨습니다.")
        3 -> println("카페라떼를 선택하셨습니다.")
        4 -> println("에스프레소를 선택하셨습니다.")
        0 -> main()
        else -> main()
    }
}


fun drinkMenu(y: Int) {
    when (y) {
        1 -> println("오렌지주스를 선택하셨습니다.")
        2 -> println("애플주스를 선택하셨습니다.")
        3 -> println("아이스티를 선택하셨습니다.")
        4 -> println("청포도에이드를 선택하셨습니다.")
        0 -> main()
        else -> main()
    }
}

fun dessertMenu(z: Int) {
    when (z) {
        1 -> println("치즈케이크를 선택하셨습니다.")
        2 -> println("망고빙수를 선택하셨습니다.")
        3 -> println("애플파이를 선택하셨습니다.")
        4 -> println("소금빵을 선택하셨습니다.")
        0 -> main()
        else -> main()
    }
}



class Americano{
    val name: String = "Americano"
    val price: Int = 3000
}

class Cafemocha{
    val name: String = "Cafemocha"
    val price: Int = 3500
}

class CafeLatte{
    val name: String = "CafeLatte"
    val price: Int = 4000
}

class Espresso{
    val name: String = "Espresso"
    val price: Int = 4500
}


class OrangeJuice{
    val name: String = "OrangeJuice"
    val price: Int = 2500
}

class AppleJuice{
    val name: String = "AppleJuice"
    val price: Int = 2500
}

class IceTea{
    val name: String = "IceTea"
    val price: Int = 2000
}

class WhitegrapeAde{
    val name: String = "WhitegrapeAde"
    val price: Int = 3000
}



class CheeseCake{
    val name: String = "CheeseCake"
    val price: Int = 4500
}

class MangoShavedIce{
    val name: String = "MangoShavedIce"
    val price: Int = 7000
}

class ApplePie{
    val name: String = "ApplePie"
    val price: Int = 6500
}

class SaltBread{
    val name: String = "SaltBread"
    val price: Int = 4000
}
