function getMinMax(meet, axis) {
    meet.sort((a, b) => a[axis] - b[axis]);
    return [meet[0][axis], meet[meet.length-1][axis]];
}

function drawRectangle(minX, maxX, minY, maxY, meet) {
    const rectangle = [];
    for (let y = maxY; y >= minY; y--) {
        let row = "";
        for (let x = minX; x <= maxX; x++) {
            row = meet.find(m => m[0] === x && m[1] === y) ? row + "*" : row + ".";
        }
        rectangle.push(row);
    }
    return rectangle;
}

function solution(line) {
    const meet = [];
    
    for (let i = 0; i < line.length; i ++) {
        for (let j = i + 1; j < line.length; j ++) {
            const [A, B, E] = line[i];
            const [C, D ,F] = line[j];
            
            if (A * D - B * C !== 0) {
                const meetX = (B * F - E * D) / (A * D - B * C);
                const meetY = (E * C - A * F) / (A * D - B * C);
                if (meetX % 1 === 0 && meetY % 1 === 0) {
                    meet.push([meetX, meetY]);
                }
            }
        }
    }
    
    const [minX, maxX] = getMinMax(meet, 0);
    const [minY, maxY] = getMinMax(meet, 1);
    
    return drawRectangle(minX, maxX, minY, maxY, meet);;
}
