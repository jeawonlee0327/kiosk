package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.concurrent.thread

var menus = ArrayList<Menu>()
var foods = ArrayList<Food>()


fun main() {
    init()

    //8초마다 대기 인원 띄우기
    thread(start = true) {
        for(i in 1..10) {
            println("(현재 주문 대기 수 : ${i})")
            runBlocking { launch { delay(8000) } }
        }
    }
    println("카페에 오신 것을 환영 합니다.")

    //메뉴판으로 돌아올 수 있도록 따로 만들기
    showMenu()
}

//음식 저장
fun init () {
    //메인 메뉴
    menus.add(Menu("Coffee","커피의 다양한 풍미를 느껴보세요"))
    menus.add(Menu("Drink","신선한 과일의 맛을 느껴보세요"))
    menus.add(Menu("Dessert","달콤하고 특별한 간식을 즐겨보세요"))

    //세부메뉴
    foods.add(Food("아메리카노",3000, "Coffee"))
    foods.add(Food("카페모카",7000, "Coffee"))
    foods.add(Food("카페라떼",8000, "Coffee"))
    foods.add(Food("에스프레소",5000, "Coffee"))
    foods.add(Food("오렌지주스",8000, "Drink"))
    foods.add(Food("사과주스",9000, "Drink"))
    foods.add(Food("아이스티",6000, "Drink"))
    foods.add(Food("청포도에이드",9000, "Drink"))
    foods.add(Food("치즈케이크",9000, "Dessert"))
    foods.add(Food("망고빙수",9000, "Dessert"))
    foods.add(Food("애플파이",9000, "Dessert"))
    foods.add(Food("소금빵",9000, "Dessert"))


}

fun showMenu() {
    println("원하는 메뉴를 골라 번호를 입력 하시오.")
    println("--------[MENU]--------")
    showMenus() //menus 리스트에서 메뉴를 뽑아옴
    println("${menus.size + 1} 장바구니 확인")
    println("${menus.size + 2} 종료")
    var choice = 0

    //문자, 공백입력 예외처리
    while(true) {
        try {
            choice = readLine()!!.toInt()
            break
        } catch(e:java.lang.NumberFormatException) {
            println("숫자를 입력하세요")
        } catch (e:KotlinNullPointerException){
            println("숫자를 입력하세요")
        }
    }

    when (choice) {
        1 -> {
            println("--------[MENU]--------")
            println("장바구니에 담을 메뉴를 입력 하시오.")
            showCoffees() //foods 리스트에서 뽑아옴
            println("0 뒤로가기")
            var coffechoice = 0

            while(true) {
                try {
                    coffechoice = readLine()!!.toInt()
                    coffeeMenu(coffechoice)
                } catch(e:java.lang.NumberFormatException) {
                    println("숫자를 입력하세요")
                } catch (e:KotlinNullPointerException){
                    println("숫자를 입력하세요")
                }
            }
        }
        2 -> {
            println("--------[MENU]--------")
            println("장바구니에 담을 메뉴를 입력 하시오.")
            showDrinks()
            println("0 뒤로가기")
            var drinkchoice = 0

            while(true) {
                try {
                    drinkchoice = readLine()!!.toInt()
                    drinkMenu(drinkchoice)
                } catch(e:java.lang.NumberFormatException) {
                    println("숫자를 입력하세요")
                } catch (e:KotlinNullPointerException){
                    println("숫자를 입력하세요")
                }
            }
        }
        3 -> {
            println("--------[MENU]--------")
            println("장바구니에 담을 메뉴를 입력 하시오.")
            showDesserts()
            println("0 뒤로 가기")
            var dessertchoice = 0

            while(true) {
                try {
                    dessertchoice = readLine()!!.toInt()
                    dessertMenu(dessertchoice)
                } catch(e:java.lang.NumberFormatException) {
                    println("숫자를 입력하세요")
                } catch (e:KotlinNullPointerException){
                    println("숫자를 입력하세요")
                }
            }
        }
        4 -> displaycart()
        5 -> println("종료 합니다.")
        else -> {
            println("잘못된 번호입니다.")
            println("--------------------------")
            showMenu()
        }
    }
}

fun showMenus() {
    for((index, menu) in menus.withIndex()){
        println("${index+1} ${menu.name} | ${menu.content}")
    }
}

fun showCoffees() {

    var coffeeIndex = 1
    for (food in foods) {
        if (food.category == "Coffee")
            println("${coffeeIndex++} ${food.name} | ${food.price}")
    }
}

fun showDrinks(){
    var drinkindex = 1
    for(food in foods){
        if(food.category == "Drink")
            println("${drinkindex++} ${food.name} | ${food.price}")
    }
}

fun showDesserts(){
    var dessertindex = 1
    for(food in foods){
        if(food.category == "Dessert")
            println("${dessertindex++} ${food.name} | ${food.price}")
    }
}

//저장된 메뉴 불러오기
fun getFood(name: String) : Food {
    return foods.first { it.name == name }
}

fun coffeeMenu(coffechoice: Int) {
    when (coffechoice) {
        1 -> {
            val americano = getFood("아메리카노")
            americano.displayFoods() // 정보 표시
            americano.addcart() //장바구니에 담을지 결정
        }
        2 -> {
            val cafemocha = getFood("카페모카")
            cafemocha.displayFoods()
            cafemocha.addcart()
        }
        3 -> {
            val cafelatte = getFood("카페라떼")
            cafelatte.displayFoods()
            cafelatte.addcart()
        }
        4 -> {
            val espresso = getFood("에스프레소")
            espresso.displayFoods()
            espresso.addcart()
        }
        0 -> {
            println("--------------------------")
            showMenu()
        }
        else -> println("주문을 종료 합니다.")
    }
}

fun drinkMenu(drinkchoice: Int) {
    when (drinkchoice) {
        1 -> {
            val orangejuice = getFood("오렌지주스")
            orangejuice.displayFoods()
            orangejuice.addcart()
        }
        2 -> {
            val applejuice = getFood("사과주스")
            applejuice.displayFoods()
            applejuice.addcart()
        }
        3 -> {
            val icetea = getFood("아이스티")
            icetea.displayFoods()
            icetea.addcart()
        }
        4 -> {
            val ade = getFood("청포도에이드")
            ade.displayFoods()
            ade.addcart()
        }
        0 -> {
            println("--------------------------")
            showMenu()
        }
        else -> println("주문을 종료 합니다.")
    }
}

fun dessertMenu(dessertchoice: Int) {
    when (dessertchoice) {
        1 -> {
            val cheesecake = getFood("치즈케이크")
            cheesecake.displayFoods()
            cheesecake.addcart()
        }
        2 -> {
            val mangoice = getFood("망고주스")
            mangoice.displayFoods()
            mangoice.addcart()
        }
        3 -> {
            val applepie = getFood("애플파이")
            applepie.displayFoods()
            applepie.addcart()
        }
        4 -> {
            val saltbread = getFood("소금빵")
            saltbread.displayFoods()
            saltbread.addcart()
        }
        0 -> {
            println("--------------------------")
            showMenu()
        }
        else -> println("주문을 종료 합니다.")
    }
}





//장바구니에 넣은 메뉴들이 객체로 담길 리스트
var mycart = ArrayList<Food>()

//장바구니 확인
fun displaycart () {
    println("--------[ORDERS]--------") //장바구니 목록
    for (i in mycart) {
        println("${i.name}  ${i.price}원")
    }
    println("---------[TOTAL]---------") //총 금액
    println("${mycart.sumBy { it.price }}원")
    println("--------------------------")
    println("1. 주문 2. 장바구니 비우기 3. 뒤로 가기")

    var buycart = 0

    //문자, 공백입력 예외처리
    while (true) {
        try {
            buycart = readLine()!!.toInt()
            if (buycart == 1) {
                order()
            } else if (buycart == 2) {
                println("장바구니를 비웁니다.")

                //3초의 딜레이 끝에 장바구니 비움
                val job = GlobalScope.launch {
                    delay(3000)
                    mycart.clear()
                }
                runBlocking {
                    job.join()
                }
                println("장바구니를 비웠습니다! 처음 화면으로 돌아갑니다.")
                println("--------------------------")
                showMenu()
            } else {
                println("--------------------------")
                showMenu()
            }
        } catch (e: java.lang.NumberFormatException) {
            println("숫자를 입력하세요")
        } catch (e: KotlinNullPointerException) {
            println("숫자를 입력하세요")
        }
    }
}

//주문
fun order() {

    //현재 시간
    var nowTime = LocalDateTime.now().toLocalTime()
    //비교할 시간 범위 오후 11시 30분 ~ 오후 11시 59분
    var startTime = LocalTime.of(23, 30)
    var endTime = LocalTime.of(23, 59)

    if (mycart.size == 0) {
        println("주문할 상품이 없습니다.") //장바구니가 비어있을 때
        println("---------------------------------")
        showMenu()
    } else { //은행점검시간 결제 불가
        if (nowTime.isAfter(startTime) && nowTime.isBefore(endTime)) {
            println("오후 11시 30분 부터 오후 11시 30분까지 은행 점검시간으로 결제가 제한됩니다.")
            println("---------------------------------")
            showMenu()
        } else {
            pay()
        }
    }
}

//결제
fun pay() {
    var total = mycart.sumOf {it.price}
    println("총 금액은 ${mycart.sumOf { it.price }}원입니다.")
    println("고객님의 카드 잔액은 ${Balance.getBalance()}입니다.") //잔액 불러오기
    println("충전할 금액을 입력하십시오")
    var paycash = 0
    //var total = mycart.sumBy { it.price }

    //현재 날짜, 시간
    var nowDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))

    //문자, 공백입력 예외처리
    while (true) {
        try {
            paycash = readLine()!!.toInt()
            Balance.addChange(paycash) //잔액 충전
            var myBalance = Balance.getBalance()

            if (myBalance < total) { //잔액 부족
                println("현재 잔액은 ${myBalance}원으로 ${total - myBalance}원이 부족하여 결제가 불가합니다.")
                println("--------------------------")
                pay()
            } else {
                println("결제가 완료되었습니다:-) ${nowDateTime}")
                Balance.deductBalance(total) //결제 후 잔액 차감
                println("고객님의 카드 잔액은 ${Balance.getBalance()}입니다.")
                println("---------------------------------")

                //3초의 딜레이 끝에 메인 화면 띄움
                val job = GlobalScope.launch {
                    delay(3000)
                    mycart.clear()
                }
                runBlocking {
                    job.join()
                }

                main()
            }
        }
        catch (e: NumberFormatException) {
            println("숫자를 입력하세요")
        } catch (e: KotlinNullPointerException) {
            println("숫자를 입력하세요")
        }
    }
}