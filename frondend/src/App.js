import React from 'react';
import ListTodoForm from './Components/ListTodoForm';
import TodoForm from './Components/TodoForm';
import { StoreProvider } from "./Store";

function App() {
    return <StoreProvider>
        <h3>To-Do List</h3>
        <ListTodoForm />
        <TodoForm />
    </StoreProvider>
}

export default App;