import axios from 'axios';

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