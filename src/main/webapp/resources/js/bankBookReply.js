const btn=document.getElementById("btn");
const di=document.getElementById("di");
const inp1 = document.getElementById("inp1");
const inp2 = document.getElementById("inp2");
const inp3 = document.getElementById("inp3");
const comment = document.getElementById("comment");

const pageLink = document.querySelectorAll(".page-link");







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
                getList(1);
                //comment.innerHTML=getList().responseText.trim();
                
            }else{
                alert("댓글이 등록실패");
            }
        }
    });
    
});
getList(1);

function getList(page){
    
    let count  =0;
    
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET","../bankBookComment/list?bookNumber="+btn.getAttribute('data-book-bookNumber')+"&page="+page);
    
    xhttp.send();
    xhttp.addEventListener("readystatechange",function(){
        
        if(this.readyState==4 && this.status==200){
            comment.innerHTML=this.responseText.trim();
            count++;
        }
    })
    //0이 출력 : 비동기 방식이기 때문에
    console.log("count : ",count);
}




pageLink.forEach(function(p){
    console.log("p :",p);
});





// const pageFirst = document.getElementById("pageFirst");
// const pageLast = document.getElementById("pageLast");
// const pageBefore = document.getElementById("pageBefore");
// const pageAfter = document.getElementById("pageAfter");









// comment.addEventListener("click",function(e){
      
//    if(e.target.classList.contains('btns')){
//         let a = e.target.getAttribute("data-page");
//         getList(a);
//         // let xhttp = new XMLHttpRequest();
//         // xhttp.open("GET","../bankBookComment/list?page="+a+"&bookNumber="+btn.getAttribute('data-book-bookNumber'));
//         // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//         // xhttp.send();
//         // xhttp.addEventListener("readystatechange",function(){
//         //     if(this.readyState==4 && this.status==200){
//         //         comment.innerHTML=this.responseText.trim();
//         //     }
//         // });

//    } 
//     if(e.target.classList.contains('pageFirst')){
//         getList(0);
//    }if(e.target.classList.contains('pageBefore')){
//         let a = e.target.getAttribute("data-page-before");
//         getList(a);
//    }if(e.target.classList.contains('pageAfter')){
//         let a = e.target.getAttribute("data-page-after");
//         getList(a);
//    }if(e.target.classList.contains('pageLast')){
//         let a = e.target.getAttribute("data-page-total");
//         getList(a);
//    }
// });

comment.addEventListener("click",function(e){
    let pageLink = e.target;
    if(pageLink.classList.contains("page-link")){
        let page=pageLink.getAttribute("data-board-page");
        getList(page);
    }

    
});

comment.addEventListener("click",function(e){
    let del = e.target;
    
    if(del.classList.contains("dt")){
        console.log("삭제 버튼");
        let xhttp = new XMLHttpRequest();
        xhttp.open("POST","../bankBookComment/delete");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("num="+del.getAttribute('data-delete'));
         xhttp.addEventListener("readystatechange",function(){
            if(this.readyState==4 && this.status==200){
                let result = this.responseText.trim();
                if(result>0){
                    alert("댓글이 삭제되었습니다");
                    getList(1);
                }else{
                    alert("삭제 실패");
                }
                
            }
        })
        
    }
    
    
});


// comment.addEventListener("click",function(e){
//     let up = e.target;
    
//     if(up.classList.contains("up")){
        
    
//         let xhttp = new XMLHttpRequest();
//         xhttp.open("GET","../bankBookComment/update?contents="+up.getAttribute("data-contents")+"&num="+up.getAttribute('data-update'));
        
//         xhttp.send();
//          xhttp.addEventListener("readystatechange",function(){
//             if(this.readyState==4 && this.status==200){
//                 comment.innerHTML= this.responseText.trim();
                
                
//             }
//         })
        
//     }
    
   
// });
comment.addEventListener("click",function(e){
    
    let up = e.target;
    
    
    if(up.classList.contains("upbtn")){
        
    
        let xhttp = new XMLHttpRequest();
        xhttp.open("POST","../bankBookComment/update");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("num="+up.getAttribute('data-update')+"&contents="+document.getElementById("update").value);
         xhttp.addEventListener("readystatechange",function(){
            if(this.readyState==4 && this.status==200){
                let result = this.responseText.trim();
                console.log("result는 :",this.responseText.trim());
                if(result>0){
                    alert("수정 성공");
                    
                }else{
                    alert("수정 실패");
                }
                getList(1);
                
            }
        })
        
    }  
});
let check = true;
comment.addEventListener("click",function(e){
    
    let updateButton = e.target;
    
    
    if(updateButton.classList.contains("up")){
        
        if(check){
            check=false;
            //console.log(updateButton.parentNode.previousSibling.previousSibling.previousSibling.previousSibling);
        let num = updateButton.getAttribute("data-update");
        let contents=document.getElementById("contents"+num);
        console.log(contents);
        //contents.innerHTML='<textarea>'+contents.innerHTML+'</textarea>';
        contents.firstChild.removeAttribute("readonly");
        let btn = document.createElement("button");
        let attr = document.createAttribute("class");
        attr.value="btn btn-primary";
        btn.setAttributeNode(attr);
        contents.appendChild(btn);
        attr = document.createTextNode("확인");
        btn.appendChild(attr);

        let btn2 = document.createElement("button");
        attr = document.createAttribute("class");
        attr.value="btn btn-info";
        btn2.setAttributeNode(attr);
        contents.appendChild(btn2);
        attr = document.createTextNode("취소");
        btn2.appendChild(attr);

        
        btn.addEventListener("click", function(){
            console.log(contents.firstChild.value);
            console.log(num);

            let xhttp = new XMLHttpRequest();
            xhttp.open("POST","../bankBookComment/update");
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("num="+num+"&contents="+contents.firstChild.value);
            xhttp.addEventListener("readystatechange",function(){
                if(this.readyState==4 && this.status==200){
                    let result = this.responseText.trim();
                    console.log("result는 :",this.responseText.trim());
                    if(result>0){
                        alert("수정 성공");
                        getList(1);
                        check=true;
                    }else{
                        alert("수정 실패");
                    }
                    
                    
                }
            })
        })

        btn2.addEventListener("click",function(){
            check=true;
            getList(1);
        })
        
    }
    else{
        alert("수정은 한번에 하나만 할수 있습니다");
    }
    }  

    e.preventDefault();
});



