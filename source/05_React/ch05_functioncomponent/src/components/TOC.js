const TOC = (props) => {
  let lists = [];
  let data = props.data;
  //    <li><a href="1.html">HTML</a></li>
  for(let idx=0; idx<data.length; idx++){
    lists.push(
      <li key={data[idx].id}>
        <a href={data[idx].id+'html'} 
          id={data[idx].id}
          onClick={event=>{ // 매개변수 1개면 괄호 생략
            event.preventDefault();
            props.onChangeMode(Number(event.target.id));
            // console.log(event.target); // event.target: 이벤트가 발생된 태그 객체
            // debugger;
            
          }}>
          {data[idx].title}
        </a>
      </li>
    );
  }
  return(
    <nav>
      <ol>
        {lists}
      </ol>
    </nav>
  );
};
export default TOC;