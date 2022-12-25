const realNumberArray = [4, 5.6, -9.8, 3.14, 42, 6, 8.34];
const squareList = (arr) => {
    "use strict";
    // 在这行以下修改代码
    const squaredIntegers = (arr)=>{
        for (let i=0;i<arr.length;i++){
            if (arr[i]==parseInt(arr[i])){
                arr[i] = arr[i] * arr[i];
            }
        }
        return arr;
    };
    // 在这行以上修改代码
    return squaredIntegers;
};
// 测试你的代码
const squaredIntegers = squareList(realNumberArray);
console.log(squaredIntegers);
console.log(realNumberArray);