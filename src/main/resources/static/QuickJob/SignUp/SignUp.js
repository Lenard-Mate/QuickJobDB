
  function getInputValue(){
      
            var inputValName = document.getElementById("SignUpName").value;
            var inputValEmail = document.getElementById("SignUpemail").value;
            var inputValPassword = document.getElementById("SignUpPassword").value;
            

         var conversion;
         conversion={"userName":inputValName,"email":inputValEmail,"password":inputValPassword }

         var ConversionStringify=JSON.stringify(conversion);
         console.log(ConversionStringify);

if(inputValName!=""){
  window.location.href="http://localhost:8080/QuickJob/MainPage/QuickJobLogIn.html";  


$.ajax({ 
    url:"http://localhost:8080/formSubmit",
    type:"POST", 
    contentType: "application/json; charset=utf-8",
    data: ConversionStringify, //Stringified Json Object
    async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
    cache: false,    //This will force requested pages not to be cached by the browser  
     processData:false, //To avoid making query String instead of JSON
     success: function(resposeJsonObject){
       console.log("Its Work");
       
    }
});

}
        }

