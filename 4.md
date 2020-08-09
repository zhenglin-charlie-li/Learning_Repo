块级元素想竖直排列，可以写一起。
想水平排列可以写一起然后都float-left

header，main，footer
nav，article，aside
语义化标签

box-size是可见宽的大小，包括boarder但不包括margin

<div class="clearfix"></div>
.clearfix::before,
        .clearfix::after{
            content: '';
            display: table;
            clear: both;
        }
清楚高度塌陷和外边距重叠