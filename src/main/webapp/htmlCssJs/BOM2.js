

const ch=document.getElementsByClassName("ch");
for(let i=0; i<ch.length;i++){
    ch[i].addEventListener("click",function(){
        console.log(this.checked);
        for(let j=0; j<ch.length;j++){
            ch[j].checked=this.checked;
        }
    });
}










const s1 = document.getElementById("s1");

//유사 배열 
const options = document.getElementsByClassName("options");
s1.addEventListener("click",function(){
    for(let i =0;i<options.length;i++){ //select의 값은 true false임
        if(options[i].selected){
            console.log(options[i].value);
            break;
        }
    }

});


const s2 = document.getElementById("s2");

const foods=document.getElementsByClassName("foods");
const r1 = document.getElementsByName("r1");
s2.addEventListener("click",function(){
    //name으로 검색
    for(let i=0; i<r1.length; i++){
        if(r1[i].checked){
            console.log(r1[i].value);
            break;
        }
       
        
    }
    //class로 검색
    for(let i=0; i<foods.length; i++){
        if(foods[i].checked){
            console.log(foods[i].value);
            break;
        }
    }
});



const btn = document.getElementById("btn");
btn.addEventListener("click",function(){
    let r1= document.getElementById("r1");
    let c1= document.getElementById("c1");

    let c2= document.getElementById("c2");

    let result='';
    for(let i=0; i<r1.value;i++){ 
        result=result+'<tr>';
        for(let j=0; j<c1.value;j++){
            result=result+'<td>';
            result=result+'</td>';
        }
        result=result+'</tr>';
        
        
    }
    c2.innerHTML=result;
        
    
    
    console.log(r1.value*1+5);
});

