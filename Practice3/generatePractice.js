'use strict'
//searching target in parameter
function search(input, target){
return input.indexOf(target);
}
//sorting array 
function sort(input){
 return input.sort((a,b)=>{a-b});
}
//create a arr was sort
function generateSortArr(num){
let arr=[];
for(let i=0;i<num;i++){
  arr[i]=Math.floor(Math.random()*num);
}
sort(arr);
return arr;
}
function generate(testLengthArray){
  let Result=[];
  for (let i = 0; i < testLengthArray.length - 4; i++){
    var array = generateSortArr(testLengthArray[i]);
    var random = Math.floor(Math.random()*100);
    var obj = {
      input: array,
      target: random,
      output: search(array, random)
    };
    Result.push(obj);
  }

  var array =  generateSortArr(testLengthArray[testLengthArray.length - 4]);
  let randomInMiddle =  Math.floor(Math.random()*(array[array.length-1] - array[1])) + array[1];
  let objMI = {
    input: array,
    target: randomInMiddle,
    output: search(array, randomInMiddle)
  }
  Result.push(objMI);


  array = generateSortArr(testLengthArray[testLengthArray.length-3]);
  let randomExclusive = Math.floor(Math.random()*100) + array[array.length-1];
  let objNF = {
    input: array,
    target: randomExclusive,
    output:  search(array, randomExclusive)
  }
 Result.push(objNF);


 array = generateSortArr(testLengthArray[testLengthArray.length - 2]);
 let objLI = {
   input: array,
   target: array[array.length-1],
   output: search(array,array[array.length-1])
 }
 Result.push(objLI);


 array = generateSortArr(testLengthArray[testLengthArray.length - 1]);
 let objFI = {
   input: array,
   target: array[0],
   output: 0
 }
 Result.push(objFI);

 return Result;
}

module.exports = generate
