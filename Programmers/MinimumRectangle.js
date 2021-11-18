/*
 * 명함 사이즈 구하기
 * 명함의 가로, 세로 중 긴 값을 축으로 하기 위하여 정렬 & 하나씩 비교해가며 다른 값을 포함할 수 있는 최대값을 업데이트 해간다. 
 * 1) width와 height을 오름차순으로 정렬한다. 
 * 2) 사이즈 목록을 순회하며 width와 height의 최대값을 설정해나간다. 
 * 3) 완료하면 넓이를 return
 */

function solution(sizes) {
    let width = 0;
    let height = 0;
    sizes.map((size) => {
        const [w, h] = size.sort((a, b) => a - b);
        width = Math.max(width, w);
        height = Math.max(height, h);
    });
    return width * height;
}


