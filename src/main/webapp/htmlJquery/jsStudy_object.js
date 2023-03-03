

let car = {
    brand:'audi', 
    price : 3000,
    info : function(){
        console.log(this.brand,this.price);
    }
};

const btn1=document.getElementById('btn1');

btn1.addEventListener('click',function(){
    // console.log(car.brand);
    // car.info();

    // console.log('For in');
    // for(let v in car){
    //     console.log(v);
    //     console.log(car[v]);
    // }
    //클래스 객체 만드는 방법
    let s = new Student();
    s.n='iu';
    s.kor=100;
    s.eng=100;
    s.info();
    console.log(s.eng);
    console.log(s.n,s.kor);
    

});
car.color='red';

//class 선언
class Student {
    #n='';
    #kor;
    set n(n){
        this.#n=n;
    }
    get n(){
        return this.#n;
    }
    set kor(kor){
        this.#kor=kor;
    }
    get kor(){
        return this.#kor;
    }
    info(){
        console.log(this.#n,this.#kor);
    }
}
let s1 = new Student();

