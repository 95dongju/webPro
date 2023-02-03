import Subject from "./components/Subject";
import TOC from "./components/TOC";
import Control from "./components/Control"
import ReadContent from "./components/ReadContent";
import React, { useState } from 'react';
import CreateContent from "./components/CreateContent";
import UpdateContent from "./components/UpdateContent";

function App() {
  //let mode = 'read';
  const [mode, setMode] = useState('read');
  const [selectedId, setSelectedId] = useState(2);
  let [nextId, setNextId] = useState(4); // 현재 (또는 삭제되었을 수 있는) contents의 가장 큰 id ; create 모드에서 사용
  let [contents, setContents] = useState([
    {id:1, title:'HTML', body:'HTML is HyperText Markup Language.'},
    {id:2, title:'CSS', body:'CSS is for design.'},
    {id:3, title:'JavaScript', body:'JavaScript is for interactive.'},
  ]);
  let subject = {title: 'WEB', sub:'World Wide Web!'};
  let welcome = {title: 'WELCOME', body:'Hello, React!!'};
  let _title, _body, _article = null;
  if(mode === 'welcome'){
    _title = welcome.title;
    _body = welcome.body;
    _article = <ReadContent title={_title} body={_body}></ReadContent>
  }else if(mode === 'read'){
    for(var i=0; i<contents.length; i++){
      if(contents[i].id === selectedId) {
        _title = contents[i].title;
        _body = contents[i].body;
        break;
      }
    }
    _article = <ReadContent title={_title} body={_body}></ReadContent>
  }else if(mode === 'create'){
    _article = <CreateContent onCreate={(_title, _body)=>{
      // nextId++; {id:nextId, title:_title, body:_body} 객체를 contents에 추가
      
      let _contents = Array.from(contents); // 깊은 복사한 _contents에 push
      _contents.push({id:nextId, title:_title, body:_body}); // push 후
      setContents(_contents); // 콘텐츠 세팅 (화면에 보이도록)
      setSelectedId(nextId);
      setNextId(nextId+1);
    }}></CreateContent>
  }else if(mode === 'update'){
    let _contents;
    for (var idx=0; idx<contents.length; idx++){
      if(contents[idx].id === selectedId){
        _contents = contents[idx];
        break;
      }
    }
    _article = <UpdateContent data={_contents}
    onUpdate={(_title, _body)=>{
      // alert(_title+'/'+_body);
      // contents를 복제한 _contents의 id가 selectedId랑 같은 _contents 안의 객체를 변경
      let _contents = [...contents];
      for(var idx=0; idx<_contents.length; idx++){
        if(_contents[idx].id === selectedId){
          _contents[idx] = {id:selectedId, title:_title, body:_body};
          // _contents[idx].title = _title;
          // _contents[idx].body = _body;
        }
      }
      // setContents(_contents);
      setContents(_contents);
      // read 모드로 전환
      setMode('read');
    }}></UpdateContent>
  }
  return (
    <>
      <Subject title={subject.title} 
        sub={subject.sub} 
        onChangeMode={()=>{
        // mode='welcome';
        setMode('welcome');
      }}>
      </Subject>
      <TOC data={contents} onChangeMode={(_id)=>{
        // selecteId = _id;
        setSelectedId(_id);
        setMode('read');
      }}></TOC>
      <Control onChangeMode={(_mode)=>{
        if (_mode === 'delete'){
          // delete 작업
          if(window.confirm('삭제 복구 불가합니다. 삭제하시겠습니까?')){
            let _contents = [...contents];
            for(let idx=0; idx<_contents.length; idx++){
              if(_contents[idx].id === selectedId){
                _contents.splice(idx,1);
                let _id;
                if(_contents.length>0){
                  //_id = _contents[0].id;
                  _id = _contents[_contents.length-1].id;
                }else {
                  _id = 0;
                }
                setContents(_contents);
                setMode('read');
                setSelectedId(_id);
                break;
              }
            }
          }
        }else {
          setMode(_mode);
        }
      }}></Control>
      {_article}
    </>
  );
}

export default App;