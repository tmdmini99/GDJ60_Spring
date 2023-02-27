//BoardForm.js
//update버튼을 클릭하면 전송


const delete1=document.getElementById("delete");
const frm = document.getElementById("frm");

delete1.addEventListener("click",function(){
    let check=window.confirm("리얼로 삭제?");
    

    console.log("콘솔");
    if(check){

    window.confirm("한번만 더 물어볼게 리얼로 삭제?");
    window.confirm("찐으로 삭제?");
    frm.setAttribute("action","./delete");
    frm.setAttribute("method","post");
    
    
    // let me = document.createAttribute("method");
    // me.value="post";
    // frm.setAttributeNode(me);


    frm.submit();
}
});