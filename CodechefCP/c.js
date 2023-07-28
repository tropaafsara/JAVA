//Explain what a callback function is and provide a simple example? 

function sum(a,b){
    console.log(a+b);
}
function operation(val1,val2,callback){
    callback(val1,val2);
}

operation(6,5,sum)