$(function(){
    var $li = $('.slide_con .slide li');
    var len = $li.length;

    //将要运动过来的li 幻灯片
    var nowli = 0;
    //当前要离开的li
    var prevli = 0;

    //定义左右2个按钮
    var $prev = $('.prev');
    var $next = $('.next');

    //定义定时器占位符
    var timer = null;

    //选择器写法 除了第一个的
    $li.not(':first').css({left:990});

    //循环4次 加了4个li
    $li.each(function(index){
        //创建li 幻灯片下的小圆点 有<>就是创建 没有就是选择
        var $sli = $('<li></li>');
        if(index==0){
            $sli.addClass('active');
        }
        // 在ul下加入li 在现存元素的内部，从后面插入元素
        $sli.appendTo('.points');
    });

    $points = $('.points li');
    //alert($points.length);
    $points.click(function(){
        //当前将要运动过来的li 设置为点击的圆点的索引
        nowli = $(this).index();
        // 当点击是当前图的按钮时 不执行move函数
        if(nowli==prevli){
            return;
        }
        move();
        /* siblings()表示选中所有的同胞元素 */
        $(this).addClass('active').siblings().removeClass('active');
    });

    $prev.click(function(){
        nowli--;
        move();
        // ul下的第几个li 加上class active
        $points.eq(nowli).addClass('active').siblings().removeClass('active');
    });

    $next.click(function(){
        nowli++;
        move();
        $points.eq(nowli).addClass('active').siblings().removeClass('active');
    });

    //鼠标放上去时 进入子元素不触发 没有冒泡
    $('.slide_con').mouseenter(function(){
        clearInterval(timer);
    });

    //鼠标拿出去时
    $('.slide_con').mouseleave(function(){
        timer = setInterval(autoplay,4000);
    });

    timer = setInterval(autoplay,4000);

    // 自动幻灯片函数
    function autoplay(){
        nowli++;
        move();
        $points.eq(nowli).addClass('active').siblings().removeClass('active');
    }


    function move(){
        //第一种特殊情况，第一张幻灯片，点击向左，转到最后一张幻灯片
        if(nowli<0){
            // 从零开始数
            nowli = len-1;
            prevli = 0;
            //从左边过来 先把最后一张放到左边去
            $li.eq(nowli).css({left:-990});
            //	stop()解决多次按按钮排序执行 结束前面的动画
            //  将第一张放到右边
            $li.eq(prevli).stop().animate({left:990});
            // 将最后一张显示
            $li.eq(nowli).stop().animate({left:0});
            // 这时候 nowli就变成了 prevli  当前显示变为最后一张
            prevli = nowli;

            //和下面情况不同 所以return 不继续进行
            return;
        }

        // 第二种特殊情况  最后一张转第一张
        if(nowli>len-1){
            nowli = 0;
            prevli = len-1;
            // 第一张要从右边过来 先放到右边去
            $li.eq(nowli).css({left:990});
            $li.eq(prevli).animate({left:-990});
            $li.eq(nowli).animate({left:0});
            // 这时候 nowli就变成了 prevli
            prevli = nowli;
            return;

        }



        //从小图跳到大图 比如从第一张跳到第二张
        if(nowli>prevli){
            $li.eq(nowli).css({left:990});
            $li.eq(prevli).animate({left:-990});
        }
        //从大到小 比如第二张到第一张
        else{
            $li.eq(nowli).css({left:-990});
            $li.eq(prevli).animate({left:990});
        }
        // 因为if else都是相同的 所以可以拿出来共用
        $li.eq(nowli).animate({left:0});
        // 这时候 nowli就变成了 prevli
        prevli = nowli;


    }



});