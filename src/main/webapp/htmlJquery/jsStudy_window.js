const btn1 = document.getElementById('btn1');

btn1.addEventListener('click',function(){
    //JSP를 띄우려고 하면 Controller로 가는 주소를 써야함
    //ex)/qna/* 이런식으로
    //window.open("./new.html",'test','width=200,height=100,top=100,left=100');
    clearInterval(st);
});

//setTimeout
//첫번째 매개변수는 실행해야할 콜백 함수
//두번째는 얼마만큼의 시간이 지난 후 실행 할껀지
setTimeout(function(){
    alert('timeout');
},1000);

let st =setInterval(function(){

    console.log('interval');
},1000);

