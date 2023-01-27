// var str = '안녕00하세00요'; // 00 -> x로 교체
// console.log('원본 str : ' +str);
// var splitStr = str.split('00');
// console.log('분할된 str : ' +splitStr);
// var joinStr = splitStr.join('x');
// console.log('join된 str : ' +joinStr);

function replaceAll(str, oldStr, newStr) {
    let splitStr = str.split(oldStr);
    let result = splitStr.join(newStr);
    return result;
    // return str.split(oldStr).join(newStr);
}
// var replaceAll = replaceAll('인간에 우리 그들의 역사를 되려니와, 장식하는 밝은 행복스럽고 이것이다. 같이 하는 속에 노년에게서 앞이 교향악이다. 인간에 때까지 있는 산야에 꾸며 작고 있는가? 이상은 가진 같으며, 이것은 말이다. 쓸쓸한 보는 가슴이 이것은 들어 듣는다. 굳세게 고행을 설산에서 봄바람이다. 얼음이 것은 전인 이것은 밥을 우리 찾아 봄바람이다. 이상의 안고, 놀이 듣는다. 보내는 봄바람을 하는 뿐이다. 길지 우리의 무엇이 곳으로 실로 귀는 황금시대의 방황하여도, 별과 아름다우냐?', ' ', '');
// console.log('결과 : '+replaceAll);