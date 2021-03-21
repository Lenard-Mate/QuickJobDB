


$.ajax({ 
    url:"http://localhost:8080/DealarProfiledate",
    type:"POST", 
    contentType: "application/json; charset=utf-8",
    data: "", 
    async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
    cache: false,    //This will force requested pages not to be cached by the browser  
     processData:false, //To avoid making query String instead of JSON
     success: function(resposeJsonObject){
       console.log("Its Work");
      console.log(resposeJsonObject);
   
            document.getElementById("Title").value=resposeJsonObject.workTitle;
            document.getElementById("Paymant").value=resposeJsonObject.paymant;
            document.getElementById("Date").value=resposeJsonObject.date;
            document.getElementById("PhoneNumber").value=resposeJsonObject.phoneNumber;
   			document.getElementById("Description").value=resposeJsonObject.workDescriptionText;
    }
});

function getInputValue(){
      
            var Title = document.getElementById("Title").value;
            var Paymant = document.getElementById("Paymant").value;
            var Datee = document.getElementById("Date").value;
            var PhoneNumber = document.getElementById("PhoneNumber").value;
            var Description = document.getElementById("Description").value;
            console.log(Description);
         var conversion;
         conversion={"workTitle":Title,"paymant":Paymant,"phoneNumber":PhoneNumber,"date":Datee,"workDescriptionText":Description }

         var ConversionStringify=JSON.stringify(conversion);
         console.log(ConversionStringify);

if(Title!=""){

$.ajax({ 
    url:"http://localhost:8080/DealarProfile",
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


        

