package kioskLv3

fun main() {
    println("00카페에 오신 것을 환영합니다.")

    showMenu()
}

fun showMenu(){
    println("아래 메뉴판을 보시고 메뉴를 선택해 주세요")
    println("1.커피 2.음료 3.디저트 4. 장바구니확인 0.종료")
    when (readLine()!!.toInt()) {
    1 -> { // 1번을 선택했을때 커피 메뉴를 보여준다
        println("아래 커피 메뉴 중 한 가지를 선택해 주세요.")
        println("1.아메리카노 | 3000원 | 풍부한 향과 맛을 가진 전통적인 커피 음료입니다.")
        println("2.카페모카 | 3500원 | 초콜릿, 스팀 우유가 조합된 음료로 달콤하면서도 진한 맛을 제공합니다.")
        println("3.카페라떼 | 4000원 | 에스프레소와 스팀 우유가 혼합된 부드러운 커피 음료입니다.")
        println("4.에스프레소 | 4500원 | 에스프레소는 진하고 강한 맛을 가진 짧은 커피 음료입니다.")
        println("0.뒤로가기")
        val selectedCoffee = coffeMenu(readLine()!!.toInt()) //선택한 메뉴를 입력받아 selectedCoffee객체를 만든다.
        addToCart(selectedCoffee) // selectedCoffee객체를 addToCart(장바구니)에 추가한다.
    }

    2 -> { // 2번을 선택했을때 음료 메뉴를 보여준다
        println("아래 음료 메뉴 중 한 가지를 선택해 주세요.")
        println("1.오렌지주스 | 2500원 | 신선하고 달콤한 오렌지의 맛을 갖춘 과일 주스입니다.")
        println("2.애플주스 | 2500원 | 애플주스는 신선한 사과의 달콤하고 상큼한 맛을 담은 과일 주스입니다.")
        println("3.아이스티 | 2000원 | 차를 차갑게 식혀서 얼음과 함께 마시는 음료로, 다양한 향과 맛을 즐길 수 있습니다.")
        println("4.청포도에이드 | 3000원 | 청포도의 상큼하고 달콤한 맛을 갖춘 청량음료입니다.")
        println("0.뒤로가기")
        val selectedDrink = drinkMenu(readLine()!!.toInt()) //선택한 메뉴를 입력받아 selectedDrink객체를 만든다.
        addToCart(selectedDrink) // selectedDrink객체를 addToCart(장바구니)에 추가한다.
    }

    3 -> { // 3번을 선택했을때 커피 메뉴를 보여준다
        println("아래 디저트 메뉴 중 한 가지를 선택해 주세요.")
        println("1.치즈케이크 | 4500원 | 부드럽고 크리미한 텍스처를 가진 케이크 입니다.")
        println("2.망고빙수 | 7000원 | 얇게 갈아 만든 얼음 위에 싱싱한 망고 조각과 망고 시럽을 올린 얼음 빙수 입니다.")
        println("3.애플파이 | 6500원 | 바삭한 파이 크러스트로 둘러싸인 신선한 사과, 설탕, 계피 등의 재료로 만든 파이 입니다.")
        println("4.소금빵 | 4500원 | 부드러운 빵 속에 소금이 뿌려져 구운 빵으로, 달콤하면서도 소금의 간이 어울리는 빵입니다.")
        println("0.뒤로가기")
        val selectedDessert = dessertMenu(readLine()!!.toInt()) //선택한 메뉴를 입력받아 selectedDessert객체를 만든다.
        addToCart(selectedDessert) // selectedDessert객체 addToCart(장바구니)에 추가한다.
    }

    4 -> {println("장바구니에 담긴 메뉴를 확인합니다.")
        displayCart()
        println("위와 같이 주문하시겠습니까?")
        println("1.주문합니다 2.취소합니다.")
    }

    else -> println("잘못된 번호를 입력했어요 다시 입력해주세요.")
    }

}


fun coffeMenu(x: Int) :MenuItem{
    return when (x) {
        1 -> MenuItem("아메리카노", 3000)
        2 -> MenuItem("카페모카",3500)
        3 -> MenuItem("카페라떼",4000)
        4 -> MenuItem("에스프레소",4500)
        else -> MenuItem("",0)
    }
}


fun drinkMenu(y: Int) :MenuItem{
    return when (y) {
        1 -> MenuItem("오렌지주스",2500)
        2 -> MenuItem("애플주스",2500)
        3 -> MenuItem("아이스티",2000)
        4 -> MenuItem("청포도에이드",3000)
        else -> MenuItem("",0)
    }
}

fun dessertMenu(z: Int) :MenuItem{
    return when (z) {
        1 -> MenuItem("치즈케이크",4500)
        2 -> MenuItem("망고빙수",7000)
        3 -> MenuItem("애플파이",6500)
        4 -> MenuItem("소금빵",4000)
        else -> MenuItem("",0)
    }
}

open class MenuItem(val name:String, val price:Int)


// 장바구니에 담은 후 메뉴화면으로 돌아간다.
val shoppingCart = mutableListOf<MenuItem>() //수정 가능한 배열인 빈 장바구니를 하나 만들어 준다.

fun addToCart(item: MenuItem) {
    shoppingCart.add(item) // 장바구니에 아이템을 넣고,
    println("${item.name}을(를) 장바구니에 담았습니다.") //장바구니에 넣었다는 문구를 출력하고
    showMenu() // 메뉴보기로 돌아간다.
}

// 장바구니에 담긴 내역과 총 가격을 보여준다.
fun displayCart() {
        println("장바구니 내역:")
        for ((index, item) in shoppingCart.withIndex()) {
            println("${item.name} ${item.price}원")
        }
        val totalPrice = shoppingCart.sumBy { it.price }
        println("총 가격: $totalPrice 원")
    }