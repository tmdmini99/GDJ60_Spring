
let c1=window.document.getElementById("c1");
let c2=window.document.getElementById("c2");
let c3=window.document.getElementById("c3");
const btn = document.getElementById("btn");
const btn2 = document.getElementById("btn2");
const btn3 = document.getElementById("btn3");
btn.addEventListener("click",function(){
    c2.innerHTML='<img src="../resources/images/iu.jpg">';

});
btn2.addEventListener("click",function(){
    console.log(c3.getAttribute("title"));

});
btn3.addEventListener("click",function(){
    let c5=window.document.getElementById("c5");
    let v=c5.value;
    let v2=c5.getAttribute("value");
    
    console.log(v);
    console.log(v2);

});

//alert(c1);

//console.log(c1);

//innerText는 Contents를  의미
console.log(c1.innerText);
console.log(c1.innerHTML);


//c1.innerText='Change Text';


//c2.innerText='test';



console.log(c2.innerText);
console.log(c2.innerHTML);




