/*

      
            var inputValPassword = document.getElementById("SignUpPassword").value;
            

         var conversion;
         conversion={"userName":inputValName,"email":inputValEmail,"password":inputValPassword }

         var ConversionStringify=JSON.stringify(conversion);
         console.log(ConversionStringify);

  window.location.href="http://localhost:8080/QuickJob/Choice/WorkChoice.html";  
*/
let idGolbal;
$.ajax({ 
    url:"http://localhost:8080/workerProfiledate",
    type:"POST", 
    contentType: "application/json; charset=utf-8",
    data: "", //Stringified Json Object
    async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
    cache: false,    //This will force requested pages not to be cached by the browser  
     processData:false, //To avoid making query String instead of JSON
     success: function(resposeJsonObject){
       console.log("Its Work");
       console.log(resposeJsonObject);
            idGolbal=resposeJsonObject.id_number;
            console.log(resposeJsonObject.id_number);
            document.getElementById("Username").value=resposeJsonObject.userName;
            document.getElementById("email").value=resposeJsonObject.email;
            document.getElementById("PhoneNumber").value=resposeJsonObject.phonenumber;
            document.getElementById("Password").value=resposeJsonObject.password;
   			document.getElementById("Description").value=resposeJsonObject.description;
    }
});
console.log(idGolbal);
function getInputValue(){
      
            var inputValName = document.getElementById("Username").value;
            var inputValEmail = document.getElementById("email").value;
            var PhoneNumber = document.getElementById("PhoneNumber").value;
            var password = document.getElementById("Password").value;
            var TextArea = document.getElementById("Description").value;

         var conversion;
         conversion={"id_number":idGolbal,"userName":inputValName,"email":inputValEmail,"phonenumber":PhoneNumber,"password":password,"description":TextArea }

         var ConversionStringify=JSON.stringify(conversion);
         console.log(ConversionStringify);

if(inputValName!=""){

$.ajax({ 
    url:"http://localhost:8080/SaveDataWProfile",
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

function FindWork(){
window.location.href="http://localhost:8080/QuickJob/findwork/findwork.html";  
}

        

