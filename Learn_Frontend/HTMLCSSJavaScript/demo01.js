// 初始化变量
function phoneticLookup(val) {
    var result = "";

    // 请把你的代码写在这条注释以下
    var object={
        alpha:"Adams",
        bravo:"Boston",
        charlie:"Chicago",
        delta:"Denver",
        echo:"Easy",
        foxtrot:"Frank",
        '':undefined
    }
    result=object[val];
    // 请把你的代码写在这条注释以上
    return result;
}

// 你可以修改这一行来测试你的代码
phoneticLookup("charlie");