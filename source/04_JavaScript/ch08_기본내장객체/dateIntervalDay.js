//today.getIntervalDay(openday) : today부터 openday까지 기간의 날짜를 return
//this는 today, that은 openday
console.log(new Date().getTime());
Date.prototype.getIntervalDay = function(that){ // this부터 that 까지의 기간 return
    if(this>that){
        var intervalMilisec = this.getTime() - that.getTime();
    }else if (that>this){
        var intervalMilisec = that.getTime() - this.getTime();
    } // this와 that 사이의 밀리세컨을 구함
    var day = intervalMilisec / (1000*60*60*24); // (1000)초 (1000*60)분 (1000*60*60)시 (1000*60*60*24)일
    return Math.trunc(day);
};

var openday = new Date(2022, 10, 28, 9, 30, 0); // 개강
var limitday = new Date(2023, 4, 12, 12, 20, 0); // 수료 > 월은 -1 필수
console.log (openday.getIntervalDay(limitday) +'일');
console.log (new Date().getIntervalDay(limitday) + '일');