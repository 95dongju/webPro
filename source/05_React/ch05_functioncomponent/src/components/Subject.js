import './Subject.css';

const Subject = (props) => {
  return(
    <header className="Subject">
      <h1 onClick={()=>{ // 매개변수 1개면 괄호 생략 가능
        props.onChangeMode(); 
      }}>
        {props.title}
      </h1>
      {props.sub}
    </header>
  );
};

// props.title = '수정 불가. ReadOnly';
// 배열은 반드시 props 사용해야 함

// const Subject = ({title, sub}) => {
//   return(
//     <header className="Subject">
//       <h1>{title}</h1>
//       {sub}
//     </header>
//   );
// };

export default Subject;