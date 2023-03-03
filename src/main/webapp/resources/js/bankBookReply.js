const btn=document.getElementById("btn");
const di=document.getElementById("di");
const inp1 = document.getElementById("inp1");
const inp2 = document.getElementById("inp2");
const inp3 = document.getElementById("inp3");
const comment = document.getElementById("comment");







btn.addEventListener("click",function(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("POST","../bankBookComment/add");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
    console.log(btn.getAttribute("data-book-bookNumber"));
    //xhttp.send("bookNumber="+inp1.value+"&writer="+inp2.value+"&contents="+inp3.value);
    xhttp.send("contents="+inp3.value+"&bookNumber="+btn.getAttribute('data-book-bookNumber'));
    
    xhttp.addEventListener("readystatechange",function(){
        if(this.readyState==4 && this.status==200){
            //di.innerText=this.responseText.trim();
            if(this.responseText.trim() !=null){
                //alert("댓글이 등록되었습니다");
                inp3.value="";
                getList();
                //comment.innerHTML=getList().responseText.trim();
                
            }else{
                alert("댓글이 등록실패");
            }
        }
    });
    
});
getList();

function getList(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET","../bankBookComment/list?bookNumber="+btn.getAttribute('data-book-bookNumber'));
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();
    xhttp.addEventListener("readystatechange",function(){
        
        if(this.readyState==4 && this.status==200){
            comment.innerHTML=this.responseText.trim();
        }
    });
}

