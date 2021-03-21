
  function getInputValue(){
      
            var inputValName = document.getElementById("Username").value;
            var inputValEmail = "";
            var inputValPassword = document.getElementById("Password").value;
            

         var conversion;
         conversion={"userName":inputValName,"email":inputValEmail,"password":inputValPassword }

         var ConversionStringify=JSON.stringify(conversion);
         console.log(ConversionStringify);
 // window.location.href="http://localhost:8080/QuickJob/Choice/WorkChoice.html";  


$.ajax({ 
     url:"http://localhost:8080/LogInSubmit",
     type:"POST", 
     contentType: "application/json; charset=utf-8",
     data: ConversionStringify, 
     async: false,    
     cache: false,    
     processData:false, 
     success: function(resposeJsonObject){
     console.log("Its Work");
     console.log(resposeJsonObject);
      window.location.href=""+resposeJsonObject;
    },
      error: function(xhr) {
     console.log("Not working");
  }
});


        }
