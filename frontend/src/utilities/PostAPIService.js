import axios from 'axios';

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