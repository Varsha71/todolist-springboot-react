//mport logo from './logo.svg';
import {useEffect, useState } from 'react';
import './App.css';
import Todoitem from './components/todoitem';

/* function Input(props){
  ReactDOM.render(
    <input type="text"></input>
  )
}
 */

/*  const [inp,setInp]=
 <Input value=/> */


function App() {
 const [todoitems, settodo]= useState(null);
//  function CheckHandler(){
//   settodo({...todoitem, isDone:!isDone});

// }
useEffect(()=>{
  console.log("hey first loaded");

  if(!todoitems){
    
    fetch("http://localhost:8080/api/todoitems")
    .then((response)=>  response.json()) // if '{}' then use 'return'=> {return response.json()})
    .then((item)=>{
                settodo(item);
                console.log("hey loaded",item);
      });
                                                
  }
});

function addHandler(){
  fetch("http://localhost:8080/api/todoitems",{
    method: "POST",
    headers:{
      "content-type": "application/json",
    },
  })
  .then((response)=>response.json())
  .then((datz)=>settodo([...todoitems,datz]));
}

//<Todoitem key={todoitem.id} data={todoitem}/>
return(

  <>
  <div>
    <button onClick={addHandler}> Add todo item</button>
  </div>

  <div>
    
    { todoitems?todoitems.map((todoitem)=>{
  return(
    <Todoitem key={todoitem.id} data={todoitem}/>
 
  );
  }
  ):'loadin' 
 }

  </div>
  </>
 
  
  );
}

export default App;
