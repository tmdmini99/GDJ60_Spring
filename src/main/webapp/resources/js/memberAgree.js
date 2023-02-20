let checkAll=document.getElementById("checkAll");
let checka=document.getElementsByClassName("checkd");
let check1=document.getElementById("check1");
let check2=document.getElementById("check2");
let check3=document.getElementById("check3");
const agree = document.getElementById("agree");



checkAll.addEventListener("click",function(){

    for(let i=0; i<checka.length;i++){
        checka[i].checked=checkAll.checked;
        }

});

for(let i=0; i<checka.length;i++){
     checka[i].addEventListener("click",function(){
        let result=true;   
        for(let j=0; j<checka.length;j++){
            if(!checka[j].checked){
                result= checka[j].checked;
                break;
               }  
            }
            checkAll.checked=result;
    });

};

agree.addEventListener("click",function(){

    if(checkAll.checked){
        //alert('약관 동의함');
        location.href="./memberAdd";
    }else{
        alert('약관 동의 필요');
    }
});

        
    


 
