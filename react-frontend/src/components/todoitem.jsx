import React, { Fragment, useEffect, useState } from 'react';

//console.log("sec useeff loaded");
//console.log("inside isdirt loaded");
// fetch  doesnt take it as json by default


const Todoitem=(props)=>{
    const [todoitem,setitem]=useState(props.data);
    const [isDirty,setDirty]=useState(false);
  
    useEffect(()=>{
      if(isDirty){
        fetch(`http://localhost:8080/api/todoitems/${todoitem.id}`,{
          method:"PUT",
          headers:{
            "content-type" : "application/json" , 
          },
          body: JSON.stringify(todoitem),
        })
          .then((data)=> data.json()).then((item)=>{
            console.log("fetch two done");
            setDirty(false);
            setitem(item);
          }); 
  
        console.log("todo item changed",todoitem);
        
      }
      },[todoitem, isDirty]);
      
  
    function CheckHandler(){
      console.log("handler fn loaded");
      setDirty(true);
      setitem({...todoitem, isDone:!todoitem.isDone});
    }

    function inputHandler(e){
      console.log("handler fn loaded");
      setDirty(true);
      setitem({...todoitem, task: e.target.value});
    }
  
    console.log("b4 ret frag loaded");
    return(
  <div>
      <span>{todoitem.id}.</span>
      <input type="checkbox" checked={todoitem.isDone} onChange={CheckHandler}></input>
      <span><input type="text" value={todoitem.task} onChange={inputHandler}></input></span>
  </div> 
  
    );
  };

  export default Todoitem;