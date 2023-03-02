//css 선택자 유형
const btn1 = document.querySelector("#btn1"); //document.getElementById("btn1");

//querySelecor는 querySelecorAll[0]번 index를 가져오는 것과 같다
//querySelecor = querySelectorAll[0];

const buttons = document.querySelectorAll(".buttons");//document.getElementsByClassName("buttons");

const d1 = document.querySelector("#d1> .buttons li");

btn1.addEventListener("click",function(){

    console.log("버튼 1번");
});

for(let btn of buttons){
    btn.addEventListener("click",function(){
        console.log("버튼들");
    });
}