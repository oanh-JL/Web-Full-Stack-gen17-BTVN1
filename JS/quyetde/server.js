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
        var randomQuestion =questions[Math.floor(Math.random()*questions.length)]
        res.send(`<h1> ${randomQuestion.content} </h1>
            <form method="POST" action="vote/${randomQuestion.id}">
                <button type="submit" name="vote" value="y">Đúng/Có/Phải</button>
                <button type="submit" name="vote" value="n">Sai/Không/Trái</button>
            </form>` 
        ); 
      
    }
    
});
//do ask.html muon sd js trong folder public  sd methord dem so ky tu nen phai tao 1 con router sd static cho car folder
app.use(express.static("public"));
//gui form ask len router
app.get("/ask",(req,res)=>{
    res.sendFile(__dirname+"/view/ask.html");

});


app.post("/vote/:id",(req,res,next)=>{
    var question=JSON.parse(fs.readFileSync("./question.json",{encoding:"utf-8"}));
    for(let i=0;i<question.length;i++){
      if(question[i].id==req.param.id){
        var flagQuestion=question[i];
         console.log(flagQuestion);
          if(req.body.vote=="y"){
              flagQuestion.yes++;
          }
          if(req.body.vote=="n"){
              flagQuestion.no++;
          }
          console.log(flagQuestion);
          break;
      }
      
      fs.writeFileSync("./question.json",JSON.stringify(question));
      res.redirect("/");
    }
});

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