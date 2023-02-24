const d1=document.getElementById("d1");//div 태그
const add=document.getElementById("add");//button
const d1_1=document.getElementById("d1_1");
const d2=document.getElementById("d2");//div 태그
const result = document.getElementById('result');
const dels=document.getElementsByClassName("dels");

result.addEventListener("click",function(e){
    // console.log(e.currentTarget, e.target);
    // console.log(e.target.classList.contains('dels'));
    
    if(e.target.classList.contains('dels')){
        let a=e.target.getAttribute('data-del-id');
        console.log('del');
        console.log(a);
        document.getElementById(a).remove();
        
    }
});


let idx=0;
add.addEventListener("click",function(){
    let d = document.createElement("div");
    let btn = document.createElement("button");

    let attr = document.createAttribute("id");
    attr.value='del'+idx;
    
    d.setAttributeNode(attr);

    //button text
    let n=document.createTextNode("delete");
    btn.appendChild(n);
    //button class
    attr = document.createAttribute("class");
    attr.value='dels';
    btn.setAttributeNode(attr);
    //button data-
    attr =document.createAttribute("data-del-id");
     attr.value='del'+idx;
     btn.setAttributeNode(attr);
    
    d.appendChild(btn);

    result.append(d);

    idx++;
});


d1.addEventListener("click",function(){
    d1.removeChild(d1_1);
    
});



