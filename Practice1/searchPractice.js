'use strict'
//   function binarySeach(arr,left,right,x){
//   if(right>=left){
//     let mid=Math.floor(left+(right-left)/2);
//     if(arr[mid]==x) 
//     {
//       return mid;
//     }
//     if(input[mid]>target) {
//     binarySeach(input,left,mid-1,target);
//     }
//     else
//     {
//        binarySeach(input,mid+1,right,target);
//     }
//   }
//   return -1;
// }

function search(input, target) {
//   let right=input.length-1;
// return binarySeach(input,0,right,target);
for(let i=0;i<=input.length-1;i++){
  if(input[i]==target){
  return i;
  }
 }
return -1;
}

module.exports = search
