function printManyTimes(str) {
    "use strict";

    // 在这行以下修改代码

    const SENTENCE = str + " is cool!";
    for(let i = 0; i < str.length; i+=2) {
        console.log(SENTENCE);
    }

    // 在这行以上修改代码

}
printManyTimes("freeCodeCamp");