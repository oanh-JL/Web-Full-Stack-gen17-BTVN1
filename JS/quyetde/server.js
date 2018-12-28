const fs= require("fs");
const express= require("express");
const app=express();
const bodyParser=require("body-parser");
app.use(bodyParser.urlencoded({extended:false}));
//lay cau hoi random
app.get("/",(req,res)=>{
    const questions=JSON.parse(fs.readFileSync("./question.json",{encoding:"utf-8"}));
    if(questions.length==0) res.send("chưa có câu hỏi nào!!!")
    else{
        const  randomQuestion =questions[Math.floor(Math.random()*questions.length)]
        // res.send(`<h1> ${randomQuestion.content} </h1>
          
        //     <a href="/vote/${randomQuestion.id}/yes"> <button>Đúng/Có/Phải</button>
        //     </a>
        //     <a href="/vote/${randomQuestion.id}/no"> <button>Sai/Không/Trái</button>
        //     </a>`
        // ); 
      res.sendFile(__dirname+"/view/answer.html");
    }
    
});

app.get("/api/random",(req,res)=>{
    const questions=JSON.parse(fs.readFileSync("./question.json",{encoding:"utf-8"}));
    const randomQuestion=questions[Math.floor(Math.random()*questions.length)];
    res.send({question:randomQuestion});
});
app.get("/vote/:questionId/:vote",(req,res)=>{
    const questionId=req.params.questionId;
    const vote=req.params.vote;
    const questions=JSON.parse(fs.readFileSync("./question.json",{encoding:"utf-8"}));
    questions.forEach((question,index)=>{
        if(question.id==questionId){
            // if(vote==yes) questions[index].yes+=1;
            // else questions[index].no+=1;
            questions[index][vote]+=1;
        }
    });
    fs.writeFileSync("./question.json",JSON.stringify(questions));
    res.redirect("/");
});
//do ask.html muon sd js trong folder public  sd methord dem so ky tu nen phai tao 1 con router sd static cho car folder
app.use(express.static("public"));
//gui form ask len router
app.get("/ask",(req,res)=>{
    res.sendFile(__dirname+"/view/ask.html");

});
app.get("/resolve",(req,res)=>{
    res.send(__dirname+"/question")
})

// app.post("/vote/:id",(req,res,next)=>{
//     var question=JSON.parse(fs.readFileSync("./question.json",{encoding:"utf-8"}));
//     for(let i=0;i<question.length;i++){
//       if(question[i].id==req.param.id){
//         var flagQuestion=question[i];
//          console.log(flagQuestion);
//           if(req.body.vote=="y"){
//               flagQuestion.yes++;
//           }
//           if(req.body.vote=="n"){
//               flagQuestion.no++;
//           }
//           console.log(flagQuestion);
//           break;
//       }
      
//       fs.writeFileSync("./question.json",JSON.stringify(question));
//       res.redirect("/");
//     }
// });

app.post("/addquestion",(req,res)=>{
    //cach pho thong lay du lieu ma hoa roi 
    // req.on("data",(rawData)=>{
    //     console.log(rawData +"");
    // });
     const question=JSON.parse(fs.readFileSync("./question.json",{encoding:"utf-8"}));
    const newQuestion={
        content:req.body.questionContent,
        yes:0,
        no:0,
        id:question.length
    }
    question.push(newQuestion);
    fs.writeFileSync("./question.json",JSON.stringify(question));
});

//tao ra 1 port http
app.listen(7000,(err)=>{
    if(err) console.log(err);
    else console.log("app was build success!");
});