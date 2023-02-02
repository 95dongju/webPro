import React, {Component} from 'react';

class TOC extends Component{
    shouldComponentUpdate(newProps){ // render 실행 전 newProps(새props값), this.props(현재값)
        //return false; // render 실행하지 않음
        //return true; // render 실행
        if(newProps.data === this.props.data) {
            return false;
        } 
        return true;
    }
    render(){
        //<li><a href="1.html">HTML</a></li> 형태의 lists 배열
        var lists = [];
        var data = this.props.data;
        for (var i=0; i<data.length; i++){
            lists.push(
                <li key={data[i].id}>
                    <a href={data[i].id+".html"} 
                        data-id = {data[i].id}
                        onClick={function(event){
                        event.preventDefault();
                        //console.log(event.target.dataset.id);
                        this.props.onChangePage(event.target.dataset.id);
                    }.bind(this)}>
                        {data[i].title}
                    </a>
                </li>
            );
        }
        return (
        <nav>
            <ul>
                {lists}
            </ul>
        </nav>
        );
    }
}

export default TOC;
