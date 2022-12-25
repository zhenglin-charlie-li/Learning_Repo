function randomFraction() {

    // 请把你的代码写在这条注释以下

    var r;
    while ((r = Math.random()) == 0){

    }
        return r;

    // 请把你的代码写在这条注释以上.
}

console.log(randomFraction())

/*
JavaScript 基础：使用 JavaScript 生成随机分数
随机数非常适合用来创建随机行为。

Math.random()用来生成一个在0（包括 0）到1不包括 1）之间的随机小数，因此Math.random()可能返回 0 但绝不会返回 1。

提示
这一节讲过Storing Values with the Equal Operator，所有函数调用将在return执行之前解析，因此我们可以返回Math.random()函数的值。


更改randomFraction使其返回一个随机数而不是0。
*/