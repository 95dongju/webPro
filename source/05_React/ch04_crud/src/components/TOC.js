import React, {Component} from 'react';

class TOC extends Component{
    shouldComponentUpdate(newProps){
        if(newProps.data === this.props.data){
            return false;
        }
        return true;
    }
    render(){
        var lists = [];
        var data = this.props.data;
        for (var i=0; i<data.length; i++){
            lists.push(
                <li key={data[i].id}>
                    <a href={data[i].id+".html"}
                    data-id={data[i].id}
                    onClick={function(event){
                        event.preventDefault();
                        this.props.onChangePage(event.target.dataset.id);
                    }.bind(this)}>
                        {data[i].title}
                    </a>
                </li>
            );
        }
        return(
            <nav>
                <ul>
                    {lists}
                </ul>
            </nav>
        );
    }
}
export default TOC;