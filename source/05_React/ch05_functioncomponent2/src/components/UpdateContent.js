import React, {useState} from 'react';

const UpdateContent = (props) => {
  const [title, setTitle] = useState(props.data.title);
  const [body, setBody] = useState(props.data.body);
  return(
    <article>
      <h2>UPDATE</h2>
      <form action="/update_process"
        onSubmit={(event)=>{
          event.preventDefault();
          props.onUpdate(title, body);
        }}>
        <p><input type="text" name="title" placeholder="title" value={title}
        onChange={(event)=>{
          setTitle(event.target.value);
        }}/></p>
        <p><textarea name="body" placeholder="body" value={body}
        onChange={(event)=>{
          setBody(event.target.value);
        }}></textarea></p>
        <p><input type="submit" value="수정"/></p>
      </form>
    </article>
  )
};
export default UpdateContent;