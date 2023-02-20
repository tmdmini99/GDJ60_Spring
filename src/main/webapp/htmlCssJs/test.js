console.log("Hello World");

//변수 선언과 대입
//데이터타입 변수명;

let num1 = 3;
num1="abc";

//옛날 버전 Hoisting에 문젝 발생, 쓰지 말것으 권장 
var num2=4;

//상수형 변수 : java final
const num3=5;

//연산자
let num4=num1+num2; //-,*,/,%

num4= num1>num2; //<,>,<=,>=,==,!=, ===,!==
//!== 는 값이 같지 않거나 타입이 같지 않으면 true

num4=num4+1;
num4++;
num4--;


num1=3;
num2='3';

num4='abc';
num4=null;
console.log(typeof num4);

//같은 값이면 데이터 타입에 상관없이 true를 출력
console.log(num1 == num2);

//===는값도 같아야하고 데이터 타입도 같아야함
console.log(num1 === num2);


console.log('NUM3 :'+num3);
console.log('NUM1 :'+num1);
