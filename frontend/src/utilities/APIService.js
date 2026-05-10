import axios from 'axios';

// User API Service
export const axiosSaveUser = async (user) => {
    try {
        const response = await axios.post('/api/v1/user', user);
        return response.data;
    } catch (error) {
        console.error('Error saving user:', error);
        throw error;
    }
};

export const axiosFindUserById = async (id) => {
    try {
        const response = await axios.get(`/api/v1/user/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching user:', error);
        throw error;
    }
};

export const axiosUpdateUser = async (user) => {
    try {
        const response = await axios.put ('/api/v1/user', user);
        return response.data;
    } catch (error) {
        console.error('Error updating user:', error);
        throw error;
    }
};

export const axiosDeleteUserById = async (id) => {
    try {
        await axios.delete(`/api/v1/user/${id}`);
    } catch (error) {
        console.error(`Error deleting user with id ${id}:`, error);
        throw error;
    }
};


// Post API Service
export const axiosSavePost = async (post) => {
    try {
        const response = await axios.post('/api/v1/post', post);
        return response.data;
    } catch (error) {
        console.error('Error saving post:', error);
        throw error;
    }
};

export const axiosFindAllPostsByCheckpointId = async (id) => {
    try {
        const response = await axios.get(`/api/v1/posts/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching posts:', error);
        throw error;
    }
};

export const axiosUpdatePost = async (post) => {
    try {
        const response = await axios.put ('/api/v1/post', post);
        return response.data;
    } catch (error) {
        console.error('Error updating post:', error);
        throw error;
    }
};

export const axiosDeleteExistingPost = async (id) => {
    try {
        await axios.delete(`/api/v1/post/${id}`);
    } catch (error) {
        console.error(`Error deleting post with id ${id}:`, error);
        throw error;
    }
};

// Checkpoint API Service
export const axiosGetAllCheckpointsByChapterId = async (id) => {
    try {
        const response = await axios.get(`/api/v1/checkpoint/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching checkpoints:', error);
        throw error;
    }
};

// Chapter API Service
export const axiosFindChapterById = async (id) => {
    try {
        const response = await axios.get(`/api/v1/chapter/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching chapter:', error);
        throw error;
    }
};


//import { useEffect, useState } from "react";
//        import axios from "axios";
//
//function Checkpoints() {
//  const [checkpoints, setCheckpoints] = useState([]);
//
//    useEffect(() => {
//            axios.get("http://localhost:8080/api/v1/checkpoints")
//                    .then(res => setCheckpoints(res.data))
//                    .catch(err => console.error(err));
//  }, []);
//
//    return (
//            <div>
//            {checkpoints.map(cp => (
//                    <div key={cp.id}>
//                    <h3>{cp.title}</h3>
//                    <p>{cp.description}</p>
//                    </div>
//            ))}
//    </div>
//  );
//}