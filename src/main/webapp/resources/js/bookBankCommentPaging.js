const pageFirst = document.getElementById("pageFirst");
const pageLast = document.getElementById("pageLast");
const pageBefore = document.getElementById("pageBefore");
const pageAfter = document.getElementById("pageAfter");









comment.addEventListener("click",function(e){
    console.log("콘솔에 찍힘");    
   if(e.target.classList.contains('btns')){
        let a = e.target.getAttribute("data-page");
        let xhttp = new XMLHttpRequest();
        xhttp.open("GET","../bankBookComment/list?page="+a+"&bookNumber="+btn.getAttribute('data-book-bookNumber'));
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();
        xhttp.addEventListener("readystatechange",function(){
            if(this.readyState==4 && this.status==200){
                comment.innerHTML=this.responseText.trim();
            }
        });

   } if(e.target.classList.contains('pageFirst')){
        let xhttp = new XMLHttpRequest();
        xhttp.open("GET","../bankBookComment/list?bookNumber="+btn.getAttribute('data-book-bookNumber'));
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();
        xhttp.addEventListener("readystatechange",function(){
            if(this.readyState==4 && this.status==200){
                comment.innerHTML=this.responseText.trim();
            }
        });
   }if(e.target.classList.contains('pageBefore')){
        let a = e.target.getAttribute("data-page-before");
        let xhttp = new XMLHttpRequest();
        xhttp.open("GET","../bankBookComment/list?page="+a+"&bookNumber="+btn.getAttribute('data-book-bookNumber'));
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();
        xhttp.addEventListener("readystatechange",function(){
            if(this.readyState==4 && this.status==200){
                comment.innerHTML=this.responseText.trim();
            }
        });
   }if(e.target.classList.contains('pageAfter')){
        let a = e.target.getAttribute("data-page-after");
        let xhttp = new XMLHttpRequest();
        xhttp.open("GET","../bankBookComment/list?page="+a+"&bookNumber="+btn.getAttribute('data-book-bookNumber'));
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();
        xhttp.addEventListener("readystatechange",function(){
            if(this.readyState==4 && this.status==200){
                comment.innerHTML=this.responseText.trim();
            }
        });
   }if(e.target.classList.contains('pageLast')){
        let a = e.target.getAttribute("data-page-total");
        let xhttp = new XMLHttpRequest();
        xhttp.open("GET","../bankBookComment/list?page="+a+"&bookNumber="+btn.getAttribute('data-book-bookNumber'));
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();
        xhttp.addEventListener("readystatechange",function(){
            if(this.readyState==4 && this.status==200){
                comment.innerHTML=this.responseText.trim();
            }
        });
   }
});

