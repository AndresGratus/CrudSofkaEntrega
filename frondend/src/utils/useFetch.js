import { useState, useEffect } from "react";

const useFetch = (endpoint) => {
    const [data, setData] = useState("");


    const fetchData = async (endpoint) => {
        let optionsFetch = {
            method: 'GET',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json',
            },
            credentials: 'same-origin',
        };

        try {
            const response = await fetch(`${process.env.REACT_APP_HOST_API}${endpoint}`, optionsFetch);
            const data = await response.json();
            setData(data);
        } catch (error) {
            console.log(error);
        }
    };

    useEffect(() => {
        fetchData(endpoint);
    }, [endpoint]);

    return data;
};

export { useFetch };