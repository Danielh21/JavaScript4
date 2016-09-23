$(function(){
    
    
    $("#timeinput").val(getTime());
    
function getTime(){
 var currentTime = new Date();
 var timeString =  currentTime.getHours() + ":" + currentTime.getMinutes() + ":" + currentTime.getSeconds();
 
 return timeString;

};

$("#timeupdate").on("click", function(){
    var jqxhr = $.get({
        url:"/JavaScript4/Servletfor3"
    });
    jqxhr.done(function(data,status){
        $("#timeinput").val(data);
    });
});


/*
 * Assigment 4
 */

$("#svddiv").on("click",function(evt){
   var target = evt.target;
   var targetparent = target.parentNode;
   var idForparent = $(targetparent).attr("id");
   alert("Clicked Element: " + idForparent);
    
});
    
});

