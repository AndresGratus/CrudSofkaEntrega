import React, { useContext, useRef, useState } from 'react';
import Store from "../Store";

const HOST_API = "http://localhost:8080/api/";

export const FormList = () => {
    const formRef = useRef(null);
    const { dispatch, state: { list } } = useContext(Store);
    const item = list;
    const [state, setState] = useState(list);

    const onAdd = (event) => {
        event.preventDefault();
        const request = {
            name: state.name,
            id: null,
            completed: false
        };
        fetch(HOST_API + "list", {
            method: "POST",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then((list) => {
                dispatch({ type: "add-list", item: list });
                setState({ name: "" });
                formRef.current.reset();
            });
            
    }

return <form ref={formRef}>
    <input
        type="text"
        name="name"
        placeholder="¿Qué piensas hacer hoy?"
        defaultValue={list}
        onChange={(event) => {
            setState({ ...state, name: event.target.value })
        }}  ></input>
    {!item.id && <button onClick={onAdd}>Crear</button>}
</form>
}
export default FormList;