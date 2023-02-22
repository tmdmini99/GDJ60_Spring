const list = document.getElementById("list");
const add = document.getElementById("add");

add.addEventListener('click', function(){
    //<li>d</li>
    //<li><button>click</button></li>
    let li=document.createElement('li');
    let text=document.createTextNode('d');
    li.appendChild(text);
    //list.append(li);

    let lis = document.createElement('li');
    let bu = document.createElement('button');
    let te = document.createTextNode('click');
    let attr = document.createAttribute('class');
    attr.value='btn'//'btn bg';
    attr.value=attr.value+' bg';
    bu.setAttributeNode(attr);
    bu.appendChild(te);
    lis.appendChild(bu);
    //list.append(lis);

    //list.prepend(lis);
    //list.before(lis);
    list.after(lis);
    
});
