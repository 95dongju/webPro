function sumAll() {
    let result=0;
    if (arguments.length==0) {
        result = -999;
    } else if (arguments.length >= 1) {
        for (let i=0; i<arguments.length; i++) {
            result += arguments[i];
        }
    }
    return result;

}