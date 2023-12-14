import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    showMenu()
}

fun showMenu() {
    println("[도화 카페에 오신것 을 환영합니다]")
    println("[1]커피 [2]음료 [3]디저트 [4]장바구니확인 [0]종료")
    try {
        val input = readLine()!!.toInt()

        when (input) {
            1 -> {
                println("아래 커피 메뉴 중 한 가지를 선택해 주세요.")
                println("[1]아메리카노 | 3000원 | 풍부한 향과 맛을 가진 전통적인 커피 음료입니다.")
                println("[2]카페모카 | 3500원 | 초콜릿, 스팀 우유가 조합된 음료로 달콤하면서도 진한 맛을 제공합니다.")
                println("[3]카페라떼 | 4000원 | 에스프레소와 스팀 우유가 혼합된 부드러운 커피 음료입니다.")
                println("[4]에스프레소 | 4500원 | 에스프레소는 진하고 강한 맛을 가진 짧은 커피 음료입니다.")
                println("[0]뒤로가기")
                val selectedCoffe = coffeeMenu(readLine()!!.toInt())
                addTOCart(selectedCoffe)
            }

            2 -> {
                println("아래 음료 메뉴 중 한 가지를 선택해 주세요.")
                println("[1]오렌지주스 | 2500원 | 신선하고 달콤한 오렌지의 맛을 갖춘 과일 주스입니다.")
                println("[2]애플주스 | 2500원 | 애플주스는 신선한 사과의 달콤하고 상큼한 맛을 담은 과일 주스입니다.")
                println("[3]아이스티 | 2000원 | 차를 차갑게 식혀서 얼음과 함께 마시는 음료로, 다양한 향과 맛을 즐길 수 있습니다.")
                println("[4]청포도에이드 | 3000원 | 청포도의 상큼하고 달콤한 맛을 갖춘 청량음료입니다.")
                println("[0]뒤로가기")
                val selectedDrink = drinkMenu(readLine()!!.toInt())
                addTOCart(selectedDrink)
            }

            3 -> {
                println("아래 디저트 메뉴 중 한 가지를 선택해 주세요.")
                println("[1]치즈케이크 | 4500원 | 부드럽고 크리미한 텍스처를 가진 케이크 입니다.")
                println("[2]망고빙수 | 7000원 | 얇게 갈아 만든 얼음 위에 싱싱한 망고 조각과 망고 시럽을 올린 얼음 빙수 입니다.")
                println("[3]애플파이 | 6500원 | 바삭한 파이 크러스트로 둘러싸인 신선한 사과, 설탕, 계피 등의 재료로 만든 파이 입니다.")
                println("[4]소금빵 | 4500원 | 부드러운 빵 속에 소금이 뿌려져 구운 빵으로, 달콤하면서도 소금의 간이 어울리는 빵입니다.")
                println("[0]뒤로가기")
                val selectedDessert = dessertMenu(readLine()!!.toInt())
                addTOCart(selectedDessert)
            }

            4 -> {
                println("장바구니에 담긴 메뉴를 확인합니다.")
                displayCart()
                println("위와 같이 주문하시겠습니까?")
                println("[1]주문합니다. [2]메뉴판으로 이동합니다. [3]장바구니를 비웁니다.")
                order(readLine()!!.toInt())
            }

            0 -> println("키오스크를 종료합니다.")

            else -> {
                println(" 잘못된 번호를 입력했어요. 다시 입력해주세요.")
                showMenu()
            }
        }
    } catch (e: NumberFormatException) {
        println("숫자를 입력해주세요. 다시 시도하세요.")
        showMenu()
    }
}

fun coffeeMenu(x: Int): Menu {
    println("커피 메뉴 입니다")
    return when (x) {
        1 -> CoffeeMenu("아메리카노", 3000)
        2 -> CoffeeMenu("카페모카", 3500)
        3 -> CoffeeMenu("카페라떼", 4000)
        4 -> CoffeeMenu("에스프레소", 4500)
        else -> CoffeeMenu("잘못된 입력입니다", 0)
    }
}

fun drinkMenu(y: Int): Menu {
    println("음료 메뉴 입니다")
    return when (y) {
        1 -> DrinkMenu("오렌지주스", 2500)
        2 -> DrinkMenu("애플주스", 2500)
        3 -> DrinkMenu("아이스티", 2000)
        4 -> DrinkMenu("청포도에이드", 3000)
        else -> DrinkMenu("잘못된 입력입니다", 0)
    }
}

fun dessertMenu(z: Int): Menu {
    println("디저트 메뉴 입니다.")
    return when (z) {
        1 -> DessertMenu("치즈케이크", 4500)
        2 -> DessertMenu("망고빙수", 7000)
        3 -> DessertMenu("애플파이", 6500)
        4 -> DessertMenu("소금빵", 4000)
        else -> DessertMenu("잘못된 입력입니다", 0)
    }
}


abstract class Menu() {
    var name = ""
    var price = 0
    abstract fun displayInfo()
}

class CoffeeMenu() : Menu() {
    override fun displayInfo() {
        println("${name} 입니다. 가격은 ${price} 입니다.")
    }

    constructor(name: String, price: Int) : this() {
        super.name = name
        super.price = price
    }
}

class DrinkMenu() : Menu() {
    override fun displayInfo() {
        println("${name} 입니다. 가격은 ${price} 입니다.")
    }

    constructor(name: String, price: Int) : this() {
        super.name = name
        super.price = price
    }
}

class DessertMenu() : Menu() {
    override fun displayInfo() {
        println("${name} 입니다. 가격은 ${price} 입니다.")
    }

    constructor(name: String, price: Int) : this() {
        super.name = name
        super.price = price
    }
}


val shoppingCart = mutableListOf<Menu>()
fun addTOCart(itemCart: Menu) {
    shoppingCart.add(itemCart)
    println("${itemCart.name}을 장바구니에 담았습니다. 가격은${itemCart.price}원 입니다.")
    showMenu()
}

fun displayCart() {
    println("장바구니 내역:")
    for (item in shoppingCart) {
        println("${item.name} ${item.price}원")
    }
    var totalPrice = 0
    for (item in shoppingCart) {
        totalPrice += item.price
    }
    println("총 가격: ${totalPrice} 원")
}

fun order(a: Int) {
    when (a) {
        1 -> {
            println("결제를 진행하겠습니다. 금액을 넣어 주십시요.")
            pay(readLine()!!.toInt())
        }

        2 -> {
            println("메뉴판으로 돌아갑니다.")
            showMenu()
        }

        3 -> {
            println("장바구니를 비웁니다.")
            shoppingCart.clear()
            showMenu()
        }
    }
}

fun pay(putMoney: Int) {
    var totalPrice = 0
    for (item in shoppingCart) {
        totalPrice += item.price
    }
    val count = putMoney - totalPrice

    if (count >= 0) { // 구매)

        val now = LocalDateTime.now() // java.time 패키지를 사용해 LocalDateTime.now() 사용하여 현재 시간을 얻어오고
        val formattedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) // 시간정보를 원하는 형식으로 출력하도록 지정한다.

        println("결제가 완료되었습니다. 거스름돈은 ${count}원 입니다.")
        println("맛있당카페를 이용해주셔서 감사합니다 :) (${formattedNow})")
        shoppingCart.clear() // 결제 완료 후 장바구니 비우기
    } else {
        println("넣은 금액은 ${putMoney}원으로 ${Math.abs(count)}원이 부족해서 주문할 수 없습니다.")
        println("[1]결제를 재시도 합니다. [2]메뉴판으로 돌아갑니다.")
        when (readLine()!!.toInt()) {
            1 -> order(1) // 결제를 다시 시도
            2 -> order(2) // 메뉴판으로 이동
        }
    }
}