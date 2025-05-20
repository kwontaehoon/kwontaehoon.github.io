function Person() {
  this.age = 0;

  setInterval(() => {
    this.age++; // 화살표 함수는 this를 상위 스코프(Person 함수)의 this로 고정
    console.log(this.age); // 올바르게 증가
  }, 1000);
}

new Person();