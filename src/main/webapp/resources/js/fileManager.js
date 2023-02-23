const fileList = document.getElementById("fileList");
const btn = document.getElementById("btn");


let clickCount=0;
let max=1;
let param='pic';

function setName(p){
    param=p;
}

function setMax(m){
    max=m;
}

btn.addEventListener('click',function(event){
    if(clickCount>=max){
        alert("파일 추가는"+max+"만큼만 가능합니다");
        return;
        
    }
   
    clickCount++;
   
    console.log("click");
    let div =document.createElement('div');
    let lab =document.createElement('label');
    let inp=document.createElement('input');
    
    //div
    let cl=document.createAttribute('class');
    cl.value='mb-3';
    div.setAttributeNode(cl);
    
    //label
    let te = document.createTextNode('Image');
    let c2=document.createAttribute('class');
    c2.value='form-label';
    lab.setAttributeNode(c2);
    lab.appendChild(te);
    c2=document.createAttribute('for');
    c2.value='files';
    lab.setAttributeNode(c2);
    
    //input    
    let c3 =document.createAttribute('type');
    c3.value='file';
    inp.setAttributeNode(c3);
    c3 =document.createAttribute('class');
    c3.value='form-control';
    inp.setAttributeNode(c3);
    c3 =document.createAttribute('id');
    c3.value='files';
    inp.setAttributeNode(c3);
    c3 =document.createAttribute('name');
    c3.value=param;
    inp.setAttributeNode(c3);
   
    div.appendChild(lab); //div안에 label추가
    div.appendChild(inp); //div 안에 input 추가
    fileList.prepend(div); //div file list안에 div를 새로 추가
    
});