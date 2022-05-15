import React, { useContext,  useEffect, useRef, useState,  } from 'react';
import Store from "../Store";

const HOST_API = "http://localhost:8080/api/";

export const ListTodo = () => {
    const { dispatch, state: { todo } } = useContext(Store);
    const currentList = todo.list;
    const [state, setState] = useState("");
    const formRef = useRef(null);

    useEffect(() => {
        fetch(HOST_API + "todo")
            .then(response => response.json())
            .then((list) => {
                dispatch({ type: "update-item", list: list.data })
            })
    }, [dispatch]
    );

    const onAdd = (event) => {
        event.preventDefault();
        const request = {
            name: state.name,
            id: null,
            completed: false
        };
        fetch(HOST_API + "todo", {
            method: "POST",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then((list) => {
                dispatch({ type: "add-item", item: list });
                setState({ name: "" });
                formRef.current.reset();
            });
            
    }

    const onDelete = (id) => {
        fetch(HOST_API + "/" + id + "todo", {
            method: "DELETE"
        }).then((list) => {
            dispatch({ type: "delete-item", id })
        })
    };

    const onEdit = (todo) => {
        dispatch({ type: "edit-item", item: todo })
    };

    const onChange = (event, todo) => {
        const request = {
            name: todo.name,
            id: todo.id,
            completed: event.target.checked
        };
        fetch(HOST_API + "list", {
            method: "PUT",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then((todo) => {
                dispatch({ type: "update-item", item: todo });
            });
    };

    const decorationDone = {
        textDecoration: 'line-through'
    };
    return <div>
        <table >
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Tarea</td>
                    <td>¿Completado?</td>
                </tr>
            </thead>
            <tbody>
                {currentList.map((todo) => {
                    return <tr key={todo.id} style={todo.completed ? decorationDone : {}}>
                        <td>{todo.id}</td>
                        <td>{todo.name}</td>
                        <td><input type="checkbox" defaultChecked={todo.completed} onChange={(event) => onChange(event, todo)}></input></td>
                        <td><button onClick={() => onDelete(todo.id)}>Eliminar</button></td>
                        <td><button onClick={() => onEdit(todo)}>Editar</button></td>
                        <td><button onClick={() => onAdd(todo)}>Crear</button></td>
                    </tr>
                })}
            </tbody>
        </table>
    </div>
}
export default ListTodo;