function doFisrt()
{
    barSize=600;   //注意不要使用px单位，且不要用var，是全局变量
    myMovie=document.getElementById('myMovie');
    playButton=document.getElementById('playButton');
    bar=document.getElementById('defaultBar');
    progressBar=document.getElementById('progressBar');

    playButton.addEventListener('click',playOrPause,false);  //第三个参数总是false, Register the event handler for the bubbling phase.
    bar.addEventListener('click',clickedBar,false);
}
//控制movie播放和停止
function playOrPause(){
    if(!myMovie.paused && !myMovie.ended){
        myMovie.pause();
        playButton.innerHTML='Play';
        window.clearInterval(updatedBar);
    }else{
        myMovie.play();
        playButton.innerHTML='pause';
        updatedBar=setInterval(update,500);
    }
}
//控制进度条的动态显示
function update(){
    if(!myMovie.ended){
        var size=parseInt(myMovie.currentTime*barSize/myMovie.duration);
        progressBar.style.width=size+'px';
    }else{
        progressBar.style.width='0px';
        playButton.innerHTML='Play';
        window.clearInterval(updatedBar);
    }
}
//鼠标点击进度条控制方法
function clickedBar(e){
    if(!myMovie.paused && !myMovie.ended){
        var mouseX=e.pageX-bar.offsetLeft;
        var newtime=mouseX*myMovie.duration/barSize;  //new starting time
        myMovie.currentTime=newtime;
        progressBar.style.width=mouseX+'px';
        window.clearInterval(updatedBar);
    }
}

window.addEventListener('load',doFisrt,false);
