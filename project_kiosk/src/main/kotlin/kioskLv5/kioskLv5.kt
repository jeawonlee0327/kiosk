package kioskLv5

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.concurrent.thread


fun main() {

    thread {showMenu()} // 스레드를 생성해서

    val timer = Timer()

    timer.scheduleAtFixedRate(object : TimerTask() { // 프로그램을 종료할때까지 5초마다 현재 주문 대기수를 실시간으로 출력해준다 (Lv5)
    timer.scheduleAtFixedRate(object : TimerTask() { // 프로그램을 종료할때까지 5초마다 현재 주문 대기수를 실시간으로 출력해준다 (Lv5)
    timer.scheduleAtFixedRate(object : TimerTask() { // 프로그램을 종료할때까지 5초마다 현재 주문 대기수를 실시간으로 출력해준다 (Lv5)
    timer.scheduleAtFixedRate(object : TimerTask() { // 프로그램을 종료할때까지 5초마다 현재 주문 대기수를 실시간으로 출력해준다 (Lv5)
        override fun run() {
            println("$orderFormEmoji 현재 주문 대기수: ${(1..5).random()}")
        }
    }, 0, 5000)

}

// 메뉴 DB들
val americano = CoffeeItem("아메리카노", 3000, "풍부한 향과 맛을 가진 전통적인 커피 음료입니다.")
val cafemocha = CoffeeItem("카페모카", 3500, "초콜릿, 스팀 우유가 조합된 음료로 달콤하면서도 진한 맛을 제공합니다.")
val cafeLatte = CoffeeItem("카페라떼", 4000, "에스프레소와 스팀 우유가 혼합된 부드러운 커피 음료입니다.")
val espresso = CoffeeItem("에스프레소", 4500, "에스프레소는 진하고 강한 맛을 가진 짧은 커피 음료입니다.")

val orangeJuice = DrinkItem("오렌지주스", 2500, "신선하고 달콤한 오렌지의 맛을 갖춘 과일 주스입니다.")
val appleJuice = DrinkItem("애플주스", 2500, "애플주스는 신선한 사과의 달콤하고 상큼한 맛을 담은 과일 주스입니다.")
val iceTea = DrinkItem("아이스티", 2000, "차를 차갑게 식혀서 얼음과 함께 마시는 음료로, 다양한 향과 맛을 즐길 수 있습니다.")
val whitegrapeAde = DrinkItem("청포도에이드", 3000, "청포도의 상큼하고 달콤한 맛을 갖춘 청량음료입니다.")

val cheeseCake = DessertItem("치즈케이크", 4500, "부드럽고 크리미한 텍스처를 가진 케이크 입니다.")
val mangoShavedIce = DessertItem("망고빙수", 7000, "얇게 갈아 만든 얼음 위에 싱싱한 망고 조각과 망고 시럽을 올린 얼음 빙수 입니다.")
val applePie = DessertItem("애플파이", 6500, "바삭한 파이 크러스트로 둘러싸인 신선한 사과, 설탕, 계피 등의 재료로 만든 파이 입니다.")
val saltBread = DessertItem("소금빵", 4500, "부드러운 빵 속에 소금이 뿌려져 구운 빵으로, 달콤하면서도 소금의 간이 어울리는 빵입니다.")

//이모지들
val laughingEmoji = "😄"
val receiptEmoji = "💰"
val shoppingCartEmoji = "🛒"
val orderFormEmoji = "📃"

// 메뉴판 메소드 입니다.
fun showMenu() {
    println("맛있당카페에 오신 것을 환영합니다.")
    println("아래 메뉴판을 보시고 메뉴를 선택해 주세요")
    println("[1]커피 [2]음료 [3]디저트 [4]장바구니확인 [0]종료") // 대분류를 보여준다.

    try { // 숫자를 입력해야하는데 문자를 입력했을때 다시 입력할 수 있도록 try-catch 구문으로 예외를 처리 (Lv4미션)

        when (readLine()!!.toInt()) {
            1 -> { // 1번을 선택했을때 커피 메뉴를 보여준다
                println("아래 커피 메뉴 중 한 가지를 선택해 주세요.")
                println("[1]아메리카노 [2]카페모카 [3]카페라떼 [4]에스프레소 [0]뒤로가기")
                fun coffeMenu(x: Int): MenuItem {
                    return when (x) {
                        1 -> americano
                        2 -> cafemocha
                        3 -> cafeLatte
                        4 -> espresso
                        else -> CoffeeItem("", 0, "")
                    }
                }
                addToCart(coffeMenu(readLine()!!.toInt())) // 장바구니에 선택한 커피를 추가하는 함수(addToCart)를 실행한다.
            }

            2 -> { // 2번을 선택했을때 음료 메뉴를 보여준다
                println("아래 음료 메뉴 중 한 가지를 선택해 주세요.")
                println("[1]오렌지주스 [2]애플주스 [3]아이스티 [4]청포도에이드 [0]뒤로가기")
                fun drinkMenu(y: Int): MenuItem {
                    return when (y) {
                        1 -> orangeJuice
                        2 -> appleJuice
                        3 -> iceTea
                        4 -> whitegrapeAde
                        else -> DrinkItem("", 0, "")
                    }
                }
                addToCart(drinkMenu(readLine()!!.toInt())) // 장바구니에 선택한 음료를 추가하는 함수(addToCart)를 실행한다.
            }

            3 -> { // 3번을 선택했을때 커피 메뉴를 보여준다
                println("아래 디저트 메뉴 중 한 가지를 선택해 주세요.")
                println("[1]치즈케이크 [2]망고빙수 [3]애플파이 [4]소금빵 [0]뒤로가기")
                fun dessertMenu(z: Int): MenuItem {
                    return when (z) {
                        1 -> cheeseCake
                        2 -> mangoShavedIce
                        3 -> applePie
                        4 -> saltBread
                        else -> DessertItem("", 0, "")
                    }
                }
                addToCart(dessertMenu(readLine()!!.toInt())) // 장바구니에 선택한 디저트를 추가하는 함수(addToCart)를 실행한다.
            }

            4 -> {
                displayCart() //4번을 선택했을 시 장바구니 내역을 보여준다.
                println("위와 같이 주문하시겠습니까?")
                println("[1]주문합니다. [2]메뉴판으로 이동합니다. [3]장바구니를 비웁니다.")
                order(readLine()!!.toInt()) // 주문할지 여부를 묻는 order메소드를 호출한다.
            }

            0 -> println("키오스크를 종료합니다.")


            else -> {
                println(" 잘못된 번호를 입력했어요. 다시 입력해주세요.")
                showMenu() // 이 외의 모든 예외상황은 메뉴판으로 이동한다.
            }
        }
    } catch (e: NumberFormatException) { //try-catch 구문으로 숫자가 아닌 것을 입력할 시, 다시 입력하게끔 한다.
        println("숫자를 입력해주세요. 다시 시도하세요.")
        showMenu()
    }

}


val shoppingCart = arrayListOf<MenuItem>() //수정 가능한 배열인 빈 장바구니를 하나 만들어 준다.

// 장바구니에 물건을 더하는 메소드를 생성했다.
fun addToCart(item: MenuItem) {
    println("${item.name}는 ${item.info}") // 메뉴이름과 메뉴의상세정보를 출력한다.
    println("가격은 ${item.price}원 입니다. 장바구니에 넣으시겠습니까?")
    println("[1]예 [2]아니요")
    return when(readLine()!!.toInt()){
        1 -> {shoppingCart.add(item) // 장바구니에 아이템을 넣고,
            println("${item.name}을(를) 장바구니에 담았습니다.") //장바구니에 넣었다는 문구를 출력하고
            showMenu() // 메뉴판으로 돌아간다.
        }
        else -> showMenu() // 장바구니에 넣지 않을 경우 메뉴판으로 돌아간다.
    }
}

// 장바구니에 담긴 내역과 총 가격을 보여준다.
fun displayCart() {
    println("$shoppingCartEmoji 장바구니에 담긴 메뉴를 확인합니다.")
    for (item in shoppingCart) { // for문을 통해 장바구니(shoppingCart)에 담긴 내용물(item)들을 하나씩 찍어내서 보여준다.
        println("${item.name} ${item.price}원") // 이름과 가격을 보여준다.
    }
    var totalPrice = 0 // 결제해야할 총 금액을 초기화한다.
    for (item in shoppingCart) {
        totalPrice += item.price // for문을 통해 배열 안의 요소(장바구니 안의 물건들)의 가격을 다 더해준다.
    }
    println("${receiptEmoji} 총 가격은 ${totalPrice}원 입니다.") // 총 가격을 보여준다.
}

fun order(a: Int) { // 주문할지 여부를 물어본다.
    when (a) {
        1 -> {
            println("결제를 진행하겠습니다. 금액을 넣어 주십시요.")
            pay(readLine()!!.toInt()) // 주문에 동의하면 pay메소드를 호출한다.
        }

        2 -> {
            println("메뉴판으로 돌아갑니다.")
            showMenu() // 메뉴판으로 이동한다.
        }

        3 -> {
            println("장바구니를 비웁니다.")
            shoppingCart.clear() // 장바구니를 비우고
            showMenu() // 메뉴판으로 돌아간다.
        }
    }
}

// pay메소드는 결제 가능한 상태인지(금액이 부족한지,은행점검시간 인지) 확인 후 결제하고, 결제불가능한 상태(금액이 부족하거나, 은행점검시간)인 경우 메뉴판으로 이동한다.
fun pay(putMoney: Int) {
    var totalPrice = 0 // 결제해야할 총 금액을 초기화한다.
    for (item in shoppingCart) {
        totalPrice += item.price // for문을 통해 배열 안의 요소(장바구니 안의 물건들)의 가격을 다 더해준다.
    }
    val count = putMoney - totalPrice // 거스름돈은 = 넣은돈 - 장바구니 총 금액

    if (count >= 0) { // 만약 거스름돈이 0 이상 이라면 - > 구매 가능한 상태를 확인(Lv4미션)

        val now = LocalDateTime.now() // java.time 패키지를 사용해 LocalDateTime.now() 사용하여 현재 시간을 얻어오고
        val formattedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) // 시간정보를 원하는 형식으로 출력하도록 지정한다. (java 임포트)

        if (now.hour >= 23 && now.hour < 1) { // 은행 점검시간인지 확인하고 은행점검시간 이라면 해당 블록을 실행한다. (Lv5)
            println("현재 시각은 오후 ${now.hour}시 ${now.minute}분입니다. ") // 현재 시각을 보여주고
            println("은행 점검 시간은 오후 11시 ~ 오전 1시 이므로 결제할 수 없습니다.") //은행 점검시간을 안내한다.
        } else { // 은행 점검시간이 아니라면 정상 결제한다.
            println("결제가 완료되었습니다. 거스름돈은 ${count}원 입니다.") // 결제완료 안내문구와 거스름돈을 알려주고
            println("맛있당카페를 이용해주셔서 감사합니다 $laughingEmoji (${formattedNow})") // 최종인사와 결제된 시각을 표시한다. (Lv5)
            shoppingCart.clear() // 결제 완료 후 장바구니 비우기
            showMenu() // 다시 처음으로 간다 (계속 순환)
        }
    } else { // 만약 거스름돈이 0보다 작다면 -> 결제 불가 안내
        println("넣은 금액은 ${putMoney}원으로 ${Math.abs(count)}원이 부족해서 주문할 수 없습니다.") // 거스름돈인 count의 Math.abs메소드를 이용해 절대값을 보여준다.
        println("[1]결제를 재시도 합니다. [2]메뉴판으로 돌아갑니다.")
        when (readLine()!!.toInt()) { // 콘솔창의 입력값을 받아오고 1과 2의 경우를 나눈다.
            1 -> order(1) // 1일때 결제를 다시 시도
            2 -> order(2) // 2일때 메뉴판으로 이동
        }
    }
}