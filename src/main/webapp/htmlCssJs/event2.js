const b1 = document.getElementById("b1");
const p1 = document.getElementById("p1");
const b2 = document.getElementById("b2");
const p2 = document.getElementById("p2");
const naver = document.getElementById("naver");

naver.addEventListener('click',function(event){
    console.log('Naver Click');
    event.preventDefault();
    //return false;
});


b1.addEventListener('click',function(a){
    //e.stopPropagation();
    console.log('Button click');
    console.log(a);
},true);

p1.addEventListener('click',function(event){
    console.log('Div click');
    console.log(event);
    event.stopPropagation();
},true);


b2.addEventListener('click',function(e){
    e.stopPropagation();
    console.log('Button click');
    console.log(e);
    console.log("Button This :", this);

    
},false);

p2.addEventListener('click',function(event){
    console.log('Div click');
    console.log(event);
    console.log("Target : " +event.target);
    console.log("This :",this);
},false);