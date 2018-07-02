window.onload = function () {
    var lis = document.querySelectorAll(".nav_tabs li");
    console.log(lis);
    var contents = document.getElementsByClassName("child");
    console.log(contents);

    for(var i = 0;i < lis.length;i++){
        lis[i].index= i;

        lis[i].onclick = function () {
            for(var x = 0;x < lis.length;x++){
                lis[x].style.color = "#333";
            }

            this.style.color = "#f56600";

            // 先将所有的content隐藏
            for (var y = 0;y < contents.length;y++){
                contents[y].style.display = "none";
            }

            // 让对应的content出现，这里要让content和li顺序对应。
            contents[this.index].style.display = "block";
        }

    }
};