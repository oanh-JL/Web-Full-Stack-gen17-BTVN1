'use strict'
// function Swap( a, b){
//   var t;
//   t=a;
//   a=b;
//   b=t;
// }
// function partition(arr,low,high){
//   var i=low+1;
//   var p=arr[low];
//   for(var j=low+1;j<=high;j++){
//     if(arr[j]<p){
     
//       Swap(arr[i],arr[j]);
//       i++;
//     }
//   }
//   Swap(arr[low],arr[i-1]);
//   return i-1;
// }
// function QuickSort(arr, low, high){
// if(low<high){
//   var p=partition(arr,low,high);
//   QuickSort(arr,low,p-1);
//   QuickSort(arr,p+1,high);                                      
// }
// return arr;
// }
// function sort(input) {
// return QuickSort(input,1,input.length);

// }
function sort(input) {
  for (let i = 0; i <= input.length-2; i++) {
    for (let j = i+1; j <= input.length-1; j++) {
      if(input[i]>input[j]){
        let temp = input[j];  
        input[j] = input[i];  
        input[i] = temp;  
      }
    }
  }
  return input;
}


module.exports = sort
