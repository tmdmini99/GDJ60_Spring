


const id =document.getElementById("id");
const pw =document.getElementById("pw");
const pw1 =document.getElementById("pw1");
const name1 =document.getElementById("name1");
const address =document.getElementById("address");
const phone =document.getElementById("phone");
const email =document.getElementById("email");
const btn =document.getElementById("btn");
const idResult =document.getElementById("idResult");
const pwResult =document.getElementById("pwResult");
const pwResultCheck =document.getElementById("pwResultCheck");
const nameResult =document.getElementById("nameResult");
const addressResult =document.getElementById("addressResult");
const pehoneResult =document.getElementById("phoneResult");
const emailResult =document.getElementById("emailResult");
const frm =document.getElementById("frm");


let check1 = false;
let check2 = false;
let check3 = false;
let check4 = false;
let check5 = false;
let check6 = false;
let check7 = false;
let checks = [false,false,false,false,false,false,false];







id.addEventListener('blur',function(){
    //id.value=='' 와 id.value.length==0이 같음
        console.log();
    if(id.value==''){
        console.log('아무것도 없음');
        idResult.innerText='아이디는 필수입력사항입니다';
        
        idResult.classList.add('redResult');
        idResult.classList.remove('blueResult');
        checks[0] = false;
    }else{
        idResult.innerText='정상적인 아이디입니다';
        checks[0] = true;
        idResult.classList.add('blueResult'); 
        idResult.classList.remove('redResult');
        

        
    }
});
pw.addEventListener('blur',function(){
    console.log(pw.value.length);
    console.log("블러");
    if(pw.value.length<5 || pw.value.length>11){
        pwResult.innerText='PW는 필수입니다';
        checks[1] = false;
       pwResult.classList.add('redResult');
       pwResult.classList.remove('blueResult');
        
    }
});

pw.addEventListener('keyup',function(){
    console.log(pw.value.length);
    if(pw.value.length<6 || pw.value.length>11){
        pwResult.innerText='비밀번호는 6글자 이상 12글자 이하입니다';
        checks[1] = false;
        pwResult.classList.add('redResult');
        pwResult.classList.remove('blueResult');
        
    }else{
        pwResult.innerText='비밀번호 입력완료';
        checks[1] = true;
        pwResult.classList.add('blueResult');
        pwResult.classList.remove('redResult');
    }
});
pw.addEventListener("change", function(){
    checks[3]=false;
    pw1.value='';
    pwResultCheck.innerHTML='PW가 틀립니다';
    pwResultCheck.classList.add('redResult');
    pwResultCheck.classList.remove('blueResult');
    
})

pw1.addEventListener('blur',function(){
    console.log(pw.value.length);
    if(pw.value != pw1.value){
        pwResultCheck.innerText='PW는 필수사항입니다';
        checks[2] = false;
        pwResultCheck.classList.add('redResult');
        pwResultCheck.classList.remove('blueResult');
    }
});
pw1.addEventListener('keyup',function(){
    console.log(pw.value.length);
    if(pw.value != pw1.value || pw1.value.length==0){
        pwResultCheck.innerText='비밀번호가 틀렸습니다 다시 확인해주세요';
        checks[2] = false;
        pwResultCheck.classList.add('redResult');
        pwResultCheck.classList.remove('blueResult');
        
    }else{
        pwResultCheck.innerText='비밀번호가 일치합니다';
        checks[2] = true;
        pwResultCheck.classList.add('blueResult');
        pwResultCheck.classList.remove('redResult');
    }
});

name1.addEventListener('blur',function(){
    
    console.log();
    if(name1.value.length==0){
        console.log('아무것도 없음');
        nameResult.innerText='이름은는 필수입력사항입니다';
        checks[3] = false;
        nameResult.classList.add('redResult');
        nameResult.classList.remove('blueResult');
        
    }else{
        nameResult.innerText='이름 확인';
        checks[3] = true;
        nameResult.classList.add('blueResult');
        nameResult.classList.remove('redResult');
        
    }
});
address.addEventListener('blur',function(){
    
    console.log();
    if(address.value.length==0){
        console.log('아무것도 없음');
        addressResult.innerText='주소는 필수입력사항입니다';
        checks[4] = false;
        addressResult.classList.add('redResult');
        addressResult.classList.remove('blueResult');

    }else{
        addressResult.innerText='주소 확인';
        checks[4] = true;
        addressResult.classList.add('blueResult');
        addressResult.classList.remove('redResult');
    }
});
phone.addEventListener('blur',function(){
    
    console.log();
    if(phone.value.length==0){
        console.log('아무것도 없음');
        phoneResult.innerText='휴대전화는 필수입력사항입니다';
        checks[5] = false;
        phoneResult.classList.add('redResult');
        phoneResult.classList.remove('blueResult');

    }else{
        phoneResult.innerText='번호 확인';
        checks[5] = true;
        phoneResult.classList.add('blueResult');
        phoneResult.classList.remove('redResult');
    }
});
email.addEventListener('blur',function(){
    
    console.log();
    if(email.value.length==0){
        console.log('아무것도 없음');
        emailResult.innerText='이메일는 필수입력사항입니다';
        checks[6] = false;
        emailResult.classList.add('redResult');
        emailResult.classList.remove('blueResult');
        
    }else{
        emailResult.innerText='이메일 확인 완료';
        checks[6] = true;
        emailResult.classList.add('blueResult');
        emailResult.classList.remove('redResult');
    }   
});

    


//form 전송

btn.addEventListener('click',function(){
    
    
    if(!checks.includes(false)){
        frm.submit();
    }

    // if(check1 && check2 && check3 && check4 && check5 && check6 && check7){
    //     frm.submit();
    // }
    // if((idResult.value !=0 &&pwResult.value !=0 &&nameResult.value !=0 &&addressResult.value !=0 &&phoneResult.value !=0 &&email.value !=0) && (pw.value=pw1.value)){

    
    //    //밑에 두개의 방법중 아무거나 사용 가능
    //     //btn1.setAttribute("type","submit");
    //     //form 태그의 id인 frm을 강제로 submit 시킴
    //     frm.submit();
        
    // }
    else{
        alert("필수입력사항을 입력하세요");
    }
});





