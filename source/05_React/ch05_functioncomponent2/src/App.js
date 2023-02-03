import React, {useState} from 'react';
import Header from './components/Header';
import TOC from './components/TOC';
import ReadContent from './components/ReadContent';
import Control from './components/Control';
import CreateContent from './components/CreateContent';
import UpdateContent from './components/UpdateContent';

function App() {
  let header = {title:'WEB', sub:'World Wide Web!'};
  let welcome = {title:'WELCOME', body:'Hello, React!'};
  let [contents, setContents] = useState([
    {id:1, title:'HTML', body:'HTML is HyperText Markup Language.'},
    {id:2, title:'CSS', body:'CSS is for design.'},
    {id:3, title:'JavaScript', body:'JavaScript is for interactive.'},
  ]);
  let [nextId, setNextId] = useState(4);
  const [mode, setMode] = useState('read');
  const [selectedId, setSelectedId] = useState(1);
  let _title, _body, _article = null;
  if (mode === 'welcome'){
    _title = welcome.title;
    _body = welcome.body;
    _article = <ReadContent title={_title} body={_body}></ReadContent>
  }else if (mode === 'read'){
    for(var i=0; i<contents.length; i++){
      if(contents[i].id === selectedId){
        _title = contents[i].title;
        _body = contents[i].body;
        break;
      }
    }
    _article = <ReadContent title={_title} body={_body}></ReadContent>
  }else if(mode === 'create'){
    _article = <CreateContent onCreate={(_title, _body)=>{
      let _contents = Array.from(contents);
      _contents.push({id:nextId, title:_title, body:_body});
      setContents(_contents);
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
    _article = <UpdateContent data={_contents} onUpdate={(_title, _body)=>{
      let _contents = [...contents];
      for(var idx=0; idx<_contents.length; idx++){
        if (_contents[idx].id === selectedId){
          _contents[idx] = {id:selectedId, title:_title, body:_body};
        };
      }
      setContents(_contents);
      setMode('read');
    }}></UpdateContent>
  }else if(mode === 'delete'){
    if(window.confirm('삭제하면 복구 불가합니다. 삭제하시겠습니까?')){
      let _contents = [...contents];
      for(let idx=0; idx<_contents.length; idx++){
        if(_contents[idx].id === selectedId){
          _contents.splice(idx,1);
          let _id;
          if (_contents.length>0) {
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
  }
  return(
    <>
      <Header title={header.title}
              sub={header.sub}
              onChangeMode={()=>{
                setMode('welcome');
              }}>
      </Header>
      <TOC data={contents} onChangeMode={(_id)=>{
        setSelectedId(_id);
        setMode('read');
      }}>
      </TOC>
      <Control onChangeMode={(_mode)=>{
        setMode(_mode);
      }}>
      </Control>
      {_article}
    </>
  )
}

export default App;
