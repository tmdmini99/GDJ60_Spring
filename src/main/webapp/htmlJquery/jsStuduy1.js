//css 선택자 유형
const btn1 = document.querySelector("#btn1"); //document.getElementById("btn1");

//querySelecor는 querySelecorAll[0]번 index를 가져오는 것과 같다
//querySelecor = querySelectorAll[0];

const buttons =document.querySelectorAll(".buttons");//document.getElementsByClassName("buttons");

//const d1 = document.querySelector("#d1> .buttons li");

let ar = [1,2,3];

console.log('Old');
for(let i =0; i<ar.length;i++){
    console.log(ar[i]);
}

console.log('For of');
for(let a of ar){
    console.log(a);
}
//for in 은 index번호가 들어감
console.log('For in');
for(let j in ar){
    console.log(j);
    console.log(ar[j]);
}

console.log('For each');
ar.forEach(function(v , i , list){
    console.log('v :',v,'i :',i,'ar :',list);
});


btn1.addEventListener("click",function(){

    console.log("버튼 1번");
});

// for(let btn of buttons){
//     btn.addEventListener("click",function(){
//         console.log("버튼들");
//     });
// }

//alert(buttons);
//alert(ar);
console.log(buttons);
console.log(ar);

buttons.forEach(function(v,i){
    v.addEventListener('click',function(){
        console.log("버튼들");
    });
});


console.log(parseInt('1')+1);

console.log('1'*1+1);

