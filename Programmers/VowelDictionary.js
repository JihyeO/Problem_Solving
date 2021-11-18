/*
 * 모음 사전
 * 빈 문자에서 시작하여 5글자 이내의 모든 경우의 수를 구하면서 '단어(key)와 1씩 더한 값(value)'의 쌍으로 저장, 구하고자 하는 단어의 값을 반환한다.
 */

let order = 0;
let dictionary = {};

function solution(target) {
    makeDictionary("");
    return dictionary[target];
}

function makeDictionary(word) {
    dictionary[word] = order;
    order += 1;

    const alphabet = ["A", "E", "I", "O", "U"];
    for(let i = 0; i < 5; i ++) {
        if (word.length < 5) {
            makeDictionary(word+alphabet[i]);
        } else {
            break;
        }
    }
    return;
}