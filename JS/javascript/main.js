// console.log("Hello world");

// // const let var
// const constVariable="ABC";

// //constVariable="xyz";

// let variable="12345";
// console.log(variable);
// variable=true;
// console.log(variable);
// variable=5;
// console.log(variable);
// let obj={
//     name:"oanh",
//     age:100
// }
// console.log(typeof obj);
// console.log(obj);
// console.log(obj.name);
// console.log(obj["age"]);

// obj.firstName="Pham";

// obj.lastName="Oanh";
// console.log(obj);
// obj.age=1;
// console.log(`minh ten la ${obj.name}`);
// //array
// let arr=[1,2,3,4,5,"oanh"];
// console.log(arr);
// for(let i=0;i<arr.length;i++){
//    let item=arr[i];
// }
// arr.forEach(function(item,index){
//     console.log(item,index);

// })
// console.log(arr.map(function(item){
//     return item*2;
// }));
// function functionA(){
//     console.log("Hellooooooooo");
// }
// functionA();
// function  t(A){
//     console.log(A);
// }
// t("oanh");
// const functionB= function(){
//     console.log("gHelllooooo");
// }
// functionB();

// let now= new Date();
// console.log(now);

// var a=5;
// function print(){
//     var b=10;
//     console.log(a);
//     console.log(b);

// }
// print();
// console.log(a);
// //console.log(b);

// setTimeout(function(){
// console.log("hello world");
// },5000)
function print(num, waitTime){
    setTimeout(function(){
        console.log(num);
    },waitTime)
}

function countDown(count){
    for(var i=count;i>=0;i--){
    print(i, count-i);
    }
}
countDown(5);
function callback(result){
    console.log(result);
}
function print(onWaitDone){
    setTimeout(function(){
        onWaitDone(resizeTo)
    })
}
