/*你将使用Object.freeze来防止数学常量被改变。
你需要冻结MATH_CONSTANTS对象，
使得没有人可以改变PI的值，抑或增加或删除属性。*/
function freezeObj() {
    "use strict";
    const MATH_CONSTANTS = {
        PI: 3.14
    };
    // 在这行以下修改代码
    Object.freeze(MATH_CONSTANTS);

    // 在这行以上修改代码
    try {
        MATH_CONSTANTS.PI = 99;
    } catch( ex ) {
        console.log(ex);
    }
    return MATH_CONSTANTS.PI;
}
const PI = freezeObj();