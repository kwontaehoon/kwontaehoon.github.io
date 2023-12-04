function solution(a, b) {
    let max = 0;
    let min = 0;
    let sum = sum;
    a >= b ? (max = a, min = b) : (min = a, max - b);
    while(true){
        if(min == max){ return min; }
        else{ sum += min++; }
    }
}

console.log(solution(3, 5));