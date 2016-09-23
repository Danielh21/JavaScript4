/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function(){
    
start();
function start(){
var timestamp = getTime();

$("#timebox").val(timestamp);
};

function getTime(){
 var currentTime = new Date();
 var timeString =  currentTime.getHours() + ":" + currentTime.getMinutes() + ":" + currentTime.getSeconds();
 
 return timeString;

};

$("#timebutton").on("click", function(){
    var jqxhr = $.ajax({
       url:"/JavaScript4/SmartServlet",
       type: "GET"
    });
  jqxhr.done(function(data,textstatus){
      $("#timebox").val(data);
     console.log(data); 
     console.log(textstatus); 
  });
});

/*
 * 2. Create a small application that can generate a list of people and show them in an html table<br>
        a. On the server – create a list of Person objekter.<br>
        b. Use gson library (the gson object) to create a json string from a person object.<br>
        c. When the user clicks a button a new person should be loaded from the server<br>
        d. Add a registration form so that the user can add himself to the personlist of the application<br>
        e. User the $.post() method to send the data to the server and add the person<br>
 */

$("#tableBut").on("click", function(){
        getfromServer();
});

function getfromServer(){
    var jqxhr = $.ajax({
       url:"/JavaScript4/SmartServlet",
       type: "GET"
    });
  jqxhr.done(function(data,textstatus){
     console.log(data); 
     console.log(textstatus); 
      var arrayOfPersons = JSON.parse(data);
      $("#tbody").html("");
      $(arrayOfPersons).each(function(){
        var rowString = "<tr>";
        rowString += "<td>" + $(this).attr("name") +"</td>";
        rowString += "<td>" + $(this).attr("age") +"</td></tr>";
        $("#tbody").append(rowString);
      });
  });
    
};


$("#submitBut").on("click",function(){
   var person = new Object();
   console.log($("#nameInput").val());
   person.name = $("#nameInput").val();
   person.age = $("#ageInput").val();
   var json_data = JSON.stringify(person);
    
    var jqxhr = $.post({
       url:"/JavaScript4/SmartServlet",
       data: json_data
   });
    jqxhr.done(function(data,textstatus){
            getfromServer();
    });
    
});

});