/*
 * 부족한 금액 계산하기
 * 가지고 있는 금액에서 count 횟수만큼 놀이기구를 이용하는 비용을 뺀 후, 결과(양수: 0, 음수: 부족한 금액)를 반환한다.
 */

function solution(price, money, count) {
    var totalPrice = 0;

    for (let i = 1; i <= count; i++) {
        totalPrice += i * price;
    }

    return money - totalPrice > 0 ? 0 : Math.abs(money - totalPrice);
}