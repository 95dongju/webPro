import './Header.css';

const Header = (props) => {
  return(
    <header className="header">
      <h1 onClick={()=>{
        props.onChangeMode();
      }}>
        {props.title}
      </h1>
      {props.sub}
    </header>
  )
}
export default Header;