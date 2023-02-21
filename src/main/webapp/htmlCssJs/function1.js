
const d1 =document.getElementById('d1');











/* fuction 선언*/


//전역 변수
let n='iu';
var old='iu';
function f1(){
    console.log("function Test");
    console.log(n);
    var old='winter';

}

//function 호출
f1();

//매개변수 선언 시 let,const는 생략
function f2(n1, n2){
    //지역 변수
    let name = 'iu';
    return n1+n2;
}
let result = f2(2,3);
console.log(result);
console.log(name);
//console.log(n1);
console.log('old :'+old);


//익명함수는 변수에 담을수 있음
let fun= function (){
    console.log('익명함수');
    return 1;
}
//변수를 호출하지만 뒤에 매개변수를 같이 호출
fun();

//함수를 매개변수로 넣기 위해서는 변수에다가 넣어야함
function f3(f){
    //콘솔에서는 연결 연산자를 +대신 ,사용 가능
     console.log('f3 :',f,1);
}

f3(fun);




//다른 곳에서도 같은 함수를 사용하고 싶을 때
////d1.addEventListener('click',callback1);
//d1.addEventListener('click',callback2);

//여기에서만 사용하는 함수 
d1.addEventListener('click',function(){
    callback1();
    callback2();
});

function callback1(){
    console.log('CollBacnk1');
}

let callback2 = function(){
    console.log('CollBacnk2');
}