const express=require("express");
const demo=express();

demo.use(express.static(__dirname + '/view'));


demo.get('/',(req,res)=>{
       res.sendFile(__dirname + "/view/OanhPham'sProfile.html")
})


demo.listen(9796,(err)=>{
    if(err)console.log(err);
    else console.log("success");
})