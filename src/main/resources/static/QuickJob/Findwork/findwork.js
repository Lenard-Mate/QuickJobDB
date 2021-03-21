
$.ajax({ 
    url:"http://localhost:8080/FindWorkData",
    type:"POST", 
    contentType: "application/json; charset=utf-8",
    data: "", //Stringified Json Object
    async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
    cache: false,    //This will force requested pages not to be cached by the browser  
     processData:false, //To avoid making query String instead of JSON
     success: function(resposeJsonObject){
       console.log("Its Work");
       console.log(resposeJsonObject);
      

for(var i=0;i<resposeJsonObject.length;i++){
  var div = document.createElement("div");
    div.className="item";
      div.innerHTML = "<img src='Images/images.png'><b>Title:</b><a>"+resposeJsonObject[i].workTitle+"</a><br><br><b>How many you pay:</b><a>"+resposeJsonObject[i].paymant+"</a><br><br><b>Date:</b><a>"+resposeJsonObject[i].date+"</a><br><br><b>PhoneNumber:</b><a>"+resposeJsonObject[i].phoneNumber+"</a><br><br><b>Work Description:</b><a>"+resposeJsonObject[i].workDescriptionText+"</a><br><br>";
      document.body.appendChild(div);

}

   
    }
});



