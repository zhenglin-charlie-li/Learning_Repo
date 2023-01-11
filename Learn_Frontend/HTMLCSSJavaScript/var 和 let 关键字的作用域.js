//比较 var 和 let 关键字的作用域
function checkScope() {
    "use strict";
    const i = "function scope";
    if (true) {
        let i = "block scope";
        console.log("Block scope i is: ", i);
    }
    console.log("Function scope i is: ", i);
    return i;
}

checkScope();