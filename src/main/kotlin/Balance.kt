package org.example

//유일한 객체로 접근하기 위해 싱글턴 활용
object Balance {

    private var balance : Int = 0 //충전 전에도 잔액을 불러올 수 있도록

    //잔액 확인
    fun getBalance():Int {
        return balance
    }

    //결제 시 잔액 차감
    fun deductBalance(c:Int) {
        balance -= c
    }

    //충전 또는 거스름돈 추가
    fun addChange(a : Int) {
        balance += a
    }

}